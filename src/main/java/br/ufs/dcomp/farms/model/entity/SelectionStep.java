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

import br.ufs.dcomp.farms.model.enums.SelectionStepStatusEnum;

@Entity
@Table(name = "selection_step")
@XmlRootElement
@SequenceGenerator(name = "SelectionStepSequenceGenerator", sequenceName = "sq_selection_step")
public class SelectionStep {
	
	private Long idSelectionStep;
	private Integer nrSerial;
	private Integer qtReview;
	private Date dhStartSelectionStep;
	private Date dhEndSelectionStep;
	private Date dhReviewEnd;
	private Date dhConflictsSolvingEnd;
	private RatedContent ratedContent;
	private Project project;
	private SelectionStepStatusEnum tpStatus;
	private Integer vlLowerScore;
	
	public SelectionStep() {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SelectionStepSequenceGenerator")
	@Column(name = "id_selection_step", nullable = false, unique = true)
	public Long getIdSelectionStep() {
		return idSelectionStep;
	}

	public void setIdSelectionStep(Long idSelectionStep) {
		this.idSelectionStep = idSelectionStep;
	}

	@Column(name = "nr_serial", nullable = false, unique = true)
	public Integer getNrSerial() {
		return nrSerial;
	}

	public void setNrSerial(Integer nrSerial) {
		this.nrSerial = nrSerial;
	}

	@Column(name = "qt_review", nullable = false, unique = true)
	public Integer getQtReview() {
		return qtReview;
	}

	public void setQtReview(Integer qtReview) {
		this.qtReview = qtReview;
	}

	@Column(name = "dh_start_selection_step", nullable = false, unique = true)
	public Date getDhStartSelectionStep() {
		return dhStartSelectionStep;
	}

	public void setDhStartSelectionStep(Date dhStartSelectionStep) {
		this.dhStartSelectionStep = dhStartSelectionStep;
	}

	@Column(name = "dh_end_selection_step", nullable = false, unique = true)
	public Date getDhEndSelectionStep() {
		return dhEndSelectionStep;
	}

	public void setDhEndSelectionStep(Date dhEndSelectionStep) {
		this.dhEndSelectionStep = dhEndSelectionStep;
	}

	@Column(name = "dh_review_end", nullable = false, unique = true)
	public Date getDhReviewEnd() {
		return dhReviewEnd;
	}

	public void setDhReviewEnd(Date dhReviewEnd) {
		this.dhReviewEnd = dhReviewEnd;
	}

	@Column(name = "dh_conflicts_solving_end", nullable = false, unique = true)
	public Date getDhConflictsSolvingEnd() {
		return dhConflictsSolvingEnd;
	}

	public void setDhConflictsSolvingEnd(Date dhConflictsSolvingEnd) {
		this.dhConflictsSolvingEnd = dhConflictsSolvingEnd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rated_content", nullable = false)
	public RatedContent getRatedContent() {
		return ratedContent;
	}

	public void setRatedContent(RatedContent ratedContent) {
		this.ratedContent = ratedContent;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_project", nullable = false)
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Column(name = "tp_status", nullable = false)
	@Enumerated(EnumType.STRING)
	public SelectionStepStatusEnum getTpStatus() {
		return tpStatus;
	}

	public void setTpStatus(SelectionStepStatusEnum tpStatus) {
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