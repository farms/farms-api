package br.ufs.dcomp.farms.model.dto;

import br.ufs.dcomp.farms.model.entity.StandardQuery;

public class StandardQueryCreatedDto {

	private String dsStandardQuery;
	private String dsProjectKey;
	
	public StandardQueryCreatedDto(StandardQuery standardQuery) {
		this.dsStandardQuery = standardQuery.getDsStandardQuery();
		this.dsProjectKey = standardQuery.getProject().getDsKey();
	}
	
	public String getDsStandardQuery() {
		return dsStandardQuery;
	}
	
	public void setDsStandardQuery(String dsStandardQuery) {
		this.dsStandardQuery = dsStandardQuery;
	}
	
	public String getDsProjectKey() {
		return dsProjectKey;
	}
	
	public void setDsProjectKey(String dsProjectKey) {
		this.dsProjectKey = dsProjectKey;
	}
}
