package br.ufs.dcomp.farms.model.dto;

import br.ufs.dcomp.farms.model.entity.SelectionCriteria;

public class SelectionCriteriaCreatedDto {

	private String dsSelectionCriteria;
	private Integer tpCriteria;
	private String dsProjectKey;
	
	public SelectionCriteriaCreatedDto(SelectionCriteria selectionCriteria) {
		this.dsSelectionCriteria = selectionCriteria.getDsSelectionCriteria();
		this.tpCriteria = selectionCriteria.getTpCriteria().getCode();
		this.dsProjectKey = selectionCriteria.getProject().getDsKey();
	}
	
	public String getDsSelectionCriteria() {
		return dsSelectionCriteria;
	}
	
	public void setDsSelectionCriteria(String dsSelectionCriteria) {
		this.dsSelectionCriteria = dsSelectionCriteria;
	}
	
	public Integer getTpCriteria() {
		return tpCriteria;
	}
	
	public void setTpCriteria(Integer tpCriteria) {
		this.tpCriteria = tpCriteria;
	}
	
	public String getDsProjectKey() {
		return dsProjectKey;
	}
	
	public void setDsProjectKey(String dsProjectKey) {
		this.dsProjectKey = dsProjectKey;
	}
}