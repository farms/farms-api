package br.ufs.dcomp.farms.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import br.ufs.dcomp.farms.rest.EmailHtmlTemplate;

public class FarmsMail {

	final static String ACCOUNT_CONFIRMATION_EMAIL_TEMPLATE_HTML = "templates/account-confirmation-email-template.html";

	/**
	 * Send registration confirmation email.
	 * 
	 * @param dsMailTo
	 * @param dsSubject
	 */
	public static void sendAccountConfirmationEmail(String nmResearcher, String dsMailTo, String cdUuid) {
		String farmsSiteUrl = FarmsProperties.load().getProperty("farms.site.url");
		String dsSubject = "Confirm email";
		// Set key values.
		Map<String, String> bodyKeyValueMap = new HashMap<String, String>();
		bodyKeyValueMap.put("{{researcher-name}}", nmResearcher);
		bodyKeyValueMap.put("{{url-site}}", farmsSiteUrl);
		String urlEmailConfirmation = farmsSiteUrl + "/account/confirmation?u=" + cdUuid;
		bodyKeyValueMap.put("{{url-email-confirmation}}", urlEmailConfirmation);
		new FarmsMail().sendMail(dsMailTo, dsSubject, bodyKeyValueMap);
	}

	/**
	 * Method to send an Email.
	 * 
	 * @param dsMailTo
	 * @param dsSubject
	 */
	public void sendMail(String dsMailTo, String dsSubject, Map<String, String> bodyKeyValueMap) {
		try {
			String farmsMailSmtpHost = FarmsProperties.load().getProperty("farms.mail.smtp.host");
			String farmsMailFromName = FarmsProperties.load().getProperty("farms.mail.contact.name");
			String farmsMailFrom = FarmsProperties.load().getProperty("farms.mail.contact");
			String farmsMailPassword = FarmsProperties.load().getProperty("farms.mail.password");
			
			// Set mail properties.
			Properties props = System.getProperties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", farmsMailSmtpHost);
			props.put("mail.smtp.user", farmsMailFrom);
			props.put("mail.smtp.password", farmsMailPassword);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");

			Session session = Session.getDefaultInstance(props);
			MimeMessage message = new MimeMessage(session);

			try {
				// Set email data.
				message.setFrom(new InternetAddress(farmsMailFrom, farmsMailFromName));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(dsMailTo));
				message.setSubject(dsSubject);
				MimeMultipart multipart = new MimeMultipart();
				BodyPart messageBodyPart = new MimeBodyPart();

				// HTML mail content.
				ClassLoader classLoader = this.getClass().getClassLoader();
				File htmlTemplateFile = new File(classLoader.getResource(ACCOUNT_CONFIRMATION_EMAIL_TEMPLATE_HTML).getFile());

				String htmlText = readEmailFromHtml(htmlTemplateFile.getPath(), bodyKeyValueMap);
				messageBodyPart.setContent(htmlText, "text/html");

				multipart.addBodyPart(messageBodyPart);
				message.setContent(multipart);

				// Connect to smtp server and send Email.
				Transport transport = session.getTransport("smtp");
				transport.connect(farmsMailSmtpHost, farmsMailFrom, farmsMailPassword);
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();
				System.out.println("Mail sent successfully...");
			} catch (MessagingException ex) {
				Logger.getLogger(EmailHtmlTemplate.class.getName()).log(Level.SEVERE, null, ex);
			} catch (Exception ae) {
				ae.printStackTrace();
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Method to replace the values for keys
	 * 
	 * @param filePath
	 * @param input
	 * @return
	 */
	protected String readEmailFromHtml(String filePath, Map<String, String> input) {
		String msg = readContentFromFile(filePath);
		try {
			Set<Entry<String, String>> entries = input.entrySet();
			for (Map.Entry<String, String> entry : entries) {
				msg = msg.replace(entry.getKey().trim(), entry.getValue().trim());
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return msg;
	}

	/**
	 * Method to read HTML file as a String.
	 * 
	 * @param fileName
	 * @return
	 */
	private String readContentFromFile(String fileName) {
		StringBuffer contents = new StringBuffer();
		try {
			// Use buffering, reading one line at a time.
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					contents.append(line);
					contents.append(System.getProperty("line.separator"));
				}
			} finally {
				reader.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return contents.toString();
	}
}
