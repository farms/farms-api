package br.ufs.dcomp.farms.rest;

import java.util.UUID;

import br.ufs.dcomp.farms.core.FarmsMail;

public class EmailHtmlTemplate {
	
	public static void main(String[] args) {
		String nmResearcher = "Elissandro Messias Santos";
		String dsMailTo = "elissandro.messias@gmail.com";
		UUID uuid = UUID.randomUUID();
        String dsGuid = uuid.toString();
        FarmsMail.sendAccountConfirmationEmail(nmResearcher, dsMailTo, dsGuid);
	}
}