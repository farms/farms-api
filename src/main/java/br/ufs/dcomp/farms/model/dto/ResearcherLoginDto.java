package br.ufs.dcomp.farms.model.dto;

public class ResearcherLoginDto {

	private String dsEmail;
	private String dsPassword;
	
	public ResearcherLoginDto() {
		super();
	}

	public ResearcherLoginDto(String dsEmail, String dsPassword) {
		super();
		this.dsEmail = dsEmail;
		this.dsPassword = dsPassword;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getDsPassword() {
		return dsPassword;
	}

	public void setDsPassword(String dsPassword) {
		this.dsPassword = dsPassword;
	}
}