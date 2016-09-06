package br.ufs.dcomp.farms.model.dto;

import br.ufs.dcomp.farms.model.entity.Institution;

public class InstitutionCreatedDto {

	private String dsAbbreviation;
	private String nmInstitution;
	private String nmCountry;
		
	public InstitutionCreatedDto() {}
	
	public InstitutionCreatedDto(Institution institution) {
		super();
		this.dsAbbreviation = institution.getDsAbbreviation();
		this.nmInstitution = institution.getNmInstitution();
		this.nmCountry = institution.getCountry().getNmCountry();
	}

	public String getDsAbbreviation() {
		return dsAbbreviation;
	}

	public void setDsAbbreviation(String dsAbbreviation) {
		this.dsAbbreviation = dsAbbreviation;
	}

	public String getNmInstitution() {
		return nmInstitution;
	}

	public void setNmInstitution(String nmInstitution) {
		this.nmInstitution = nmInstitution;
	}

	public String getNmCountry() {
		return nmCountry;
	}

	public void setNmCountry(String nmCountry) {
		this.nmCountry = nmCountry;
	}
}