package br.ufs.dcomp.farms.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "study_summary")
@XmlRootElement
@SequenceGenerator(name = "StudySummarySequenceGenerator", sequenceName = "sq_study_summary")
public class StudySummary {

	private Long idStudySummary;
	private String dsContext;
	private String dsObjective;
	private String dsHypothese;
	private String dsProposedApproach;
	private String dsResearchMethodology;
	private String dsResult;
	private String dsConclusion;
	private Researcher researcher;
	private Study study;
	
	public StudySummary() {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "StudySummarySequenceGenerator")
	@Column(name = "id_study_summary", nullable = false, unique = true)
	public Long getIdStudySummary() {
		return idStudySummary;
	}

	public void setIdStudySummary(Long idStudySummary) {
		this.idStudySummary = idStudySummary;
	}
	
	@Column(name = "ds_context", nullable = false, unique = true)
	public String getDsContext() {
		return dsContext;
	}

	public void setDsContext(String dsContext) {
		this.dsContext = dsContext;
	}

	@Column(name = "ds_objective", nullable = false, unique = true)
	public String getDsObjective() {
		return dsObjective;
	}

	public void setDsObjective(String dsObjective) {
		this.dsObjective = dsObjective;
	}

	@Column(name = "ds_hypotheses", nullable = false, unique = true)
	public String getDsHypothese() {
		return dsHypothese;
	}

	public void setDsHypothese(String dsHypothese) {
		this.dsHypothese = dsHypothese;
	}

	@Column(name = "ds_proposed_approach", nullable = false, unique = true)
	public String getDsProposedApproach() {
		return dsProposedApproach;
	}

	public void setDsProposedApproach(String dsProposedApproach) {
		this.dsProposedApproach = dsProposedApproach;
	}

	@Column(name = "ds_research_methodology", nullable = false, unique = true)
	public String getDsResearchMethodology() {
		return dsResearchMethodology;
	}

	public void setDsResearchMethodology(String dsResearchMethodology) {
		this.dsResearchMethodology = dsResearchMethodology;
	}

	@Column(name = "ds_result", nullable = false, unique = true)
	public String getDsResult() {
		return dsResult;
	}

	public void setDsResult(String dsResult) {
		this.dsResult = dsResult;
	}

	@Column(name = "ds_conclusion", nullable = false, unique = true)
	public String getDsConclusion() {
		return dsConclusion;
	}

	public void setDsConclusion(String dsConclusion) {
		this.dsConclusion = dsConclusion;
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
	@JoinColumn(name = "id_study", nullable = false)
	public Study getStudy() {
		return study;
	}

	public void setStudy(Study study) {
		this.study = study;
	}
}
