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
@Table(name = "study_data")
@XmlRootElement
@SequenceGenerator(name = "StudyDataSequenceGenerator", sequenceName = "sq_study_data")
public class StudyData {

	private Long idStudyData;
	private String dsData;
	private Date dhExtraction;
	private Study study;
	private Researcher researcher;
	private RequiredData requiredData;
	private ExtractionStatusEnum tpStatus;
	
	public StudyData() {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "StudyDataSequenceGenerator")
	@Column(name = "id_study_data", nullable = false, unique = true)
	public Long getIdStudyData() {
		return idStudyData;
	}

	public void setIdStudyData(Long idStudyData) {
		this.idStudyData = idStudyData;
	}

	@Column(name = "ds_data", nullable = false, unique = true)
	public String getDsData() {
		return dsData;
	}

	public void setDsData(String dsData) {
		this.dsData = dsData;
	}

	@Column(name = "dh_extraction", nullable = false, unique = true)
	public Date getDhExtraction() {
		return dhExtraction;
	}

	public void setDhExtraction(Date dhExtraction) {
		this.dhExtraction = dhExtraction;
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
	@JoinColumn(name = "id_researcher", nullable = false)
	public Researcher getResearcher() {
		return researcher;
	}

	public void setResearcher(Researcher researcher) {
		this.researcher = researcher;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_required_data", nullable = false)
	public RequiredData getRequiredData() {
		return requiredData;
	}

	public void setRequiredData(RequiredData requiredData) {
		this.requiredData = requiredData;
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
