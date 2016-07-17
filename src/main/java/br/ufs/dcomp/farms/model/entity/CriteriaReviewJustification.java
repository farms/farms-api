package br.ufs.dcomp.farms.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "criteria_review_justification")
@XmlRootElement
public class CriteriaReviewJustification {

	private CriteriaReviewJustificationPk CriteriaReviewJustificationPk;
	private String dsJustification;
	
	@Id
	public CriteriaReviewJustificationPk getCriteriaReviewJustificationPk() {
		return CriteriaReviewJustificationPk;
	}
	
	public void setCriteriaReviewJustificationPk(CriteriaReviewJustificationPk criteriaReviewJustificationPk) {
		CriteriaReviewJustificationPk = criteriaReviewJustificationPk;
	}
	
	@Column(name = "ds_justification", nullable = false)
	public String getDsJustification() {
		return dsJustification;
	}
	
	public void setDsJustification(String dsJustification) {
		this.dsJustification = dsJustification;
	}
}
