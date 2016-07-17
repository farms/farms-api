package br.ufs.dcomp.farms.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.ufs.dcomp.farms.model.enums.ExtractionStatusEnum;

@Entity
@Table(name = "classification")
@XmlRootElement
@SequenceGenerator(name = "ClassificationSequenceGenerator", sequenceName = "sq_classification")
public class Classification {

	private Long idClassification;
	private Date dhClassification;
	private Study study;
	private Category category;
	private Option option;
	private ExtractionStatusEnum tpStatus;
	
	public Classification() {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ClassificationSequenceGenerator")
	@Column(name = "id_classification", nullable = false, unique = true)
	public Long getIdClassification() {
		return idClassification;
	}

	public void setIdClassification(Long idClassification) {
		this.idClassification = idClassification;
	}
	
	@Column(name = "dh_classification", nullable = false, unique = true)
	public Date getDhClassification() {
		return dhClassification;
	}

	public void setDhClassification(Date dhClassification) {
		this.dhClassification = dhClassification;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_study", nullable = false)
	public Study getStudy() {
		return study;
	}

	public void setStudy(Study study) {
		this.study = study;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category", nullable = false)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_option", nullable = false)
	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	@Column(name = "tp_status", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	public ExtractionStatusEnum getTpStatus() {
		return tpStatus;
	}

	public void setTpStatus(ExtractionStatusEnum tpStatus) {
		this.tpStatus = tpStatus;
	}
}