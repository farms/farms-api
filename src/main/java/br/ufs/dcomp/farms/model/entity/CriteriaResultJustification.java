package br.ufs.dcomp.farms.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "criteria_result_justification")
@XmlRootElement
public class CriteriaResultJustification {

	private CriteriaResultJustificationPk criteriaResultJustificationPk;
	private String dsJustification;
	
	@Id
	public CriteriaResultJustificationPk getCriteriaResultJustificationPk() {
		return this.criteriaResultJustificationPk;
	}
	
	public void setCriteriaResultJustificationPk(CriteriaResultJustificationPk criteriaResultJustificationPk) {
		this.criteriaResultJustificationPk = criteriaResultJustificationPk;
	}
	
	@Column(name = "ds_justification", nullable = false)
	public String getDsJustification() {
		return dsJustification;
	}
	
	public void setDsJustification(String dsJustification) {
		this.dsJustification = dsJustification;
	}
}