package br.ufs.dcomp.farms.rest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;
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

public class EmailHTMLTemplate {
	
	final static String URL_SITE = "http://www.farms.nords.com.br";
	final static String TEMPLATE_MAIL = "FarmsEmailTemplate.html";
	
	public static void main(String[] args) {
		String nmResearcher = "Elissandro Messias Santos";
		String dsMailTo = "elissandro.messias@gmail.com";
		UUID uuid = UUID.randomUUID();
        String dsGuid = uuid.toString();
		sendAccountConfirmationEmail(nmResearcher, dsMailTo, dsGuid);
	}

	/**
	 * Send registration confirmation email.
	 * 
	 * @param dsMailTo
	 * @param dsSubject
	 */
	private static void sendAccountConfirmationEmail(String nmResearcher, String dsMailTo, String dsGuid) {
		String dsSubject = "Verify your email address.";
		// Set key values.
		Map<String, String> bodyKeyValueMap = new HashMap<String, String>();
		bodyKeyValueMap.put("{{researcher-name}}", nmResearcher);
		bodyKeyValueMap.put("{{url-site}}", URL_SITE);
		String urlEmailConfirmation = URL_SITE + "/account/confirmation/" + dsGuid;
		bodyKeyValueMap.put("{{url-email-confirmation}}", urlEmailConfirmation);
		new EmailHTMLTemplate().sendMail(dsMailTo, dsSubject, bodyKeyValueMap);
	}

	/**
	 * Method to send an Email.
	 * 
	 * @param dsMailTo
	 * @param dsSubject
	 */
	public void sendMail(String dsMailTo, String dsSubject, Map<String, String> bodyKeyValueMap) {
		try {
			// Email data.
			String dsMailFrom = "contato@nords.com.br";
			String dsPassword = "contato7Nords";

			// Set mail properties.
			Properties props = System.getProperties();
			String nmHost = "mail.nords.com.br";
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", nmHost);
			props.put("mail.smtp.user", dsMailFrom);
			props.put("mail.smtp.password", dsPassword);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");

			Session session = Session.getDefaultInstance(props);
			MimeMessage message = new MimeMessage(session);

			try {
				// Set email data.
				message.setFrom(new InternetAddress(dsMailFrom,"FARMS"));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(dsMailTo));
				message.setSubject(dsSubject);
				MimeMultipart multipart = new MimeMultipart();
				BodyPart messageBodyPart = new MimeBodyPart();

				// HTML mail content.
				ClassLoader classLoader = this.getClass().getClassLoader();
				File htmlTemplateFile = new File(classLoader.getResource(TEMPLATE_MAIL).getFile());

				String htmlText = readEmailFromHtml(htmlTemplateFile.getPath(), bodyKeyValueMap);
				messageBodyPart.setContent(htmlText, "text/html");

				multipart.addBodyPart(messageBodyPart);
				message.setContent(multipart);

				// Conect to smtp server and send Email.
				Transport transport = session.getTransport("smtp");
				transport.connect(nmHost, dsMailFrom, dsPassword);
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();
				System.out.println("Mail sent successfully...");
			} catch (MessagingException ex) {
				Logger.getLogger(EmailHTMLTemplate.class.getName()).log(Level.SEVERE, null, ex);
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
