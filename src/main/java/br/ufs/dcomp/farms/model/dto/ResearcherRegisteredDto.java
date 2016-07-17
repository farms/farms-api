package br.ufs.dcomp.farms.model.dto;

import br.ufs.dcomp.farms.model.entity.Researcher;

public class ResearcherRegisteredDto {

	private String dsSSO;
	private String nmResearcher;
	private String dsEmail;
	
	public ResearcherRegisteredDto() {
		super();
	}

	public ResearcherRegisteredDto(Researcher researcher) {
		this.dsSSO = researcher.getDsSSO();
		this.nmResearcher = researcher.getNmResearcher();
		this.dsEmail = researcher.getDsEmail();
	}
	
	public ResearcherRegisteredDto(String nmResearcher, String dsEmail) {
		this.nmResearcher = nmResearcher;
		this.dsEmail = dsEmail;
	}
	
	public String getDsSSO() {
		return dsSSO;
	}

	public void setDsSSO(String dsSSO) {
		this.dsSSO = dsSSO;
	}

	public String getNmResearcher() {
		return nmResearcher;
	}

	public void setNmResearcher(String nmResearcher) {
		this.nmResearcher = nmResearcher;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}
}