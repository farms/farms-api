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

import br.ufs.dcomp.farms.model.enums.ExtractionStepStatusEnum;

@Entity
@Table(name = "extraction_step")
@XmlRootElement
@SequenceGenerator(name = "ExtractionStepSequenceGenerator", sequenceName = "sq_extraction_step")
public class ExtractionStep {

	private Long idExtractionStep;
	private Integer qtExtraction;
	private Date dhStartExtractionStep;
	private Date dhEndExtractionStep;
	private Date dhReviewerExtractionEnd;
	private Date dhConflictsSolvingEnd;
	private Project project;
	private ExtractionStepStatusEnum tpStatus;
	private Integer vlLowerScore;
	
	public ExtractionStep() {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ExtractionStepSequenceGenerator")
	@Column(name = "id_extraction_step", nullable = false, unique = true)
	public Long getIdExtractionStep() {
		return idExtractionStep;
	}

	public void setIdExtractionStep(Long idExtractionStep) {
		this.idExtractionStep = idExtractionStep;
	}

	@Column(name = "qt_extraction", nullable = false, unique = true)
	public Integer getQtExtraction() {
		return qtExtraction;
	}

	public void setQtExtraction(Integer qtExtraction) {
		this.qtExtraction = qtExtraction;
	}

	@Column(name = "dh_start_extraction_step", nullable = false, unique = true)
	public Date getDhStartExtractionStep() {
		return dhStartExtractionStep;
	}

	public void setDhStartExtractionStep(Date dhStartExtractionStep) {
		this.dhStartExtractionStep = dhStartExtractionStep;
	}
	
	@Column(name = "dh_end_extraction_step", nullable = false, unique = true)
	public Date getDhEndExtractionStep() {
		return dhEndExtractionStep;
	}

	public void setDhEndExtractionStep(Date dhEndExtractionStep) {
		this.dhEndExtractionStep = dhEndExtractionStep;
	}

	@Column(name = "dh_reviewer_extraction_end", nullable = false, unique = true)
	public Date getDhReviewerExtractionEnd() {
		return dhReviewerExtractionEnd;
	}

	public void setDhReviewerExtractionEnd(Date dhReviewerExtractionEnd) {
		this.dhReviewerExtractionEnd = dhReviewerExtractionEnd;
	}

	@Column(name = "dh_conflicts_solving_end", nullable = false, unique = true)
	public Date getDhConflictsSolvingEnd() {
		return dhConflictsSolvingEnd;
	}

	public void setDhConflictsSolvingEnd(Date dhConflictsSolvingEnd) {
		this.dhConflictsSolvingEnd = dhConflictsSolvingEnd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_project", nullable = false)
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Column(name = "tp_status", nullable = false)
	@Enumerated(EnumType.STRING)
	public ExtractionStepStatusEnum getTpStatus() {
		return tpStatus;
	}

	public void setTpStatus(ExtractionStepStatusEnum tpStatus) {
		this.tpStatus = tpStatus;
	}

	@Column(name = "vl_lower_score", nullable = false, unique = true)
	public Integer getVlLowerScore() {
		return vlLowerScore;
	}

	public void setVlLowerScore(Integer vlLowerScore) {
		this.vlLowerScore = vlLowerScore;
	}
}