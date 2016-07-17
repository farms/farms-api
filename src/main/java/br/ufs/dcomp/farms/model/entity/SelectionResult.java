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

import br.ufs.dcomp.farms.model.enums.SelectionResultStatusEnum;

@Entity
@Table(name = "selection_result")
@XmlRootElement
@SequenceGenerator(name = "SelectionResultSequenceGenerator", sequenceName = "sq_selection_result")
public class SelectionResult {

	private Long idSelectionResult;
	private Date dhAssign;
	private Date dhSolution;
	private Study study;
	private Researcher researcher;
	private SelectionStep selectionStep;
	private SelectionResultStatusEnum selectionResultStatus;
	
	public SelectionResult() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SelectionResultSequenceGenerator")
	@Column(name = "id_selection_result", nullable = false, unique = true)
	public Long getIdSelectionResult() {
		return idSelectionResult;
	}

	public void setIdSelectionResult(Long idSelectionResult) {
		this.idSelectionResult = idSelectionResult;
	}

	@Column(name = "dh_assign", nullable = false, unique = true)
	public Date getDhAssign() {
		return dhAssign;
	}

	public void setDhAssign(Date dhAssign) {
		this.dhAssign = dhAssign;
	}

	@Column(name = "dh_solution", nullable = false, unique = true)
	public Date getDhSolution() {
		return dhSolution;
	}

	public void setDhSolution(Date dhSolution) {
		this.dhSolution = dhSolution;
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
	@JoinColumn(name = "id_selection_step", nullable = false)
	public SelectionStep getSelectionStep() {
		return selectionStep;
	}

	public void setSelectionStep(SelectionStep selectionStep) {
		this.selectionStep = selectionStep;
	}

	@Column(name = "tp_status", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	public SelectionResultStatusEnum getSelectionResultStatus() {
		return selectionResultStatus;
	}

	public void setSelectionResultStatus(SelectionResultStatusEnum selectionResultStatus) {
		this.selectionResultStatus = selectionResultStatus;
	}
}
