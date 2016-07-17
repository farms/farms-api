package br.ufs.dcomp.farms.model.dto;

import br.ufs.dcomp.farms.model.entity.Researcher;

public class ResearcherLoggedDto {

	private String nmResearcher;
	private String dsSSO;
	private String dsEmail;
	
	public ResearcherLoggedDto() {
		super();
	}

	public ResearcherLoggedDto(Researcher researcher) {
		this.nmResearcher = researcher.getNmResearcher();
		this.dsSSO = researcher.getDsSSO();
		this.dsEmail = researcher.getDsEmail();
	}
	
	public ResearcherLoggedDto(String nmResearcher, String dsEmail) {
		this.nmResearcher = nmResearcher;
		this.dsEmail = dsEmail;
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
}