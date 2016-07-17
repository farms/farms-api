package br.ufs.dcomp.farms.model.dto;

import br.ufs.dcomp.farms.model.enums.StateEnum;

public class ResearcherRegisterDto {

	private String nmResearcher;
	private String dsSSO;
	private String dsEmail;
	private String dsPassword;
	private String dsConfirmPassword;
	private StateEnum tpState;
	
	public ResearcherRegisterDto() {
		super();
	}

	public ResearcherRegisterDto(String nmResearcher, String dsSSO, String dsEmail, String dsPassword, String dsConfirmPassword, StateEnum tpState) {
		super();
		this.nmResearcher = nmResearcher;
		this.dsSSO = dsSSO;
		this.dsEmail = dsEmail;
		this.dsPassword = dsPassword;
		this.dsConfirmPassword = dsConfirmPassword;
		this.setTpState(tpState);
	}
	
	public String getNmResearcher() {
		return nmResearcher;
	}
	
	public void setNmResearcher(String nmResearcher) {
		this.nmResearcher = nmResearcher;
	}
	
	public String getDsSSO() {
		return dsSSO;
	}
	
	public void setDsSSO(String dsSSO) {
		this.dsSSO = dsSSO;
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
	
	public String getDsConfirmPassword() {
		return dsConfirmPassword;
	}
	
	public void setDsConfirmPassword(String dsConfirmPassword) {
		this.dsConfirmPassword = dsConfirmPassword;
	}

	public StateEnum getTpState() {
		return tpState;
	}

	public void setTpState(StateEnum tpState) {
		this.tpState = tpState;
	}
}