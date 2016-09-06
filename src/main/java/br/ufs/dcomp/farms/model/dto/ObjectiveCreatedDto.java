package br.ufs.dcomp.farms.model.dto;

import br.ufs.dcomp.farms.model.entity.Objective;

public class ObjectiveCreatedDto {

	private String dsObjective;
	private String dsProjectKey;
	
	public ObjectiveCreatedDto(Objective objective) {
		this.dsObjective = objective.getDsObjective();
		this.dsProjectKey = objective.getProject().getDsKey();
	}

	public String getDsObjective() {
		return dsObjective;
	}

	public void setDsObjective(String dsObjective) {
		this.dsObjective = dsObjective;
	}

	public String getDsProjectKey() {
		return dsProjectKey;
	}

	public void setDsProjectKey(String dsProjectKey) {
		this.dsProjectKey = dsProjectKey;
	}
}