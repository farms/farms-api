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
@Table(name = "main_question")
@XmlRootElement
@SequenceGenerator(name = "MainQuestionSequenceGenerator", sequenceName = "sq_main_question")
public class MainQuestion {

	private Long idMainQuestion;
	private String dsMainQuestion;
	private String dsPopulation;
	private String dsIntervation;
	private String dsControl;
	private String dsResult;
	private String dsApplicationContext;
	private String dsExperimentalDesign;
	private Project project;
	
	public MainQuestion() {}
	
	public MainQuestion(String dsMainQuestion) {
		this.dsMainQuestion = dsMainQuestion;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "MainQuestionSequenceGenerator")
	@Column(name = "id_main_question", nullable = false, unique = true)
	public Long getIdMainQuestion() {
		return idMainQuestion;
	}

	public void setIdMainQuestion(Long idMainQuestion) {
		this.idMainQuestion = idMainQuestion;
	}

	@Column(name = "ds_main_question", nullable = false)
	public String getDsMainQuestion() {
		return dsMainQuestion;
	}

	public void setDsMainQuestion(String dsMainQuestion) {
		this.dsMainQuestion = dsMainQuestion;
	}
	
	@Column(name = "ds_population")
	public String getDsPopulation() {
		return dsPopulation;
	}

	public void setDsPopulation(String dsPopulation) {
		this.dsPopulation = dsPopulation;
	}

	@Column(name = "ds_intervation")
	public String getDsIntervation() {
		return dsIntervation;
	}

	public void setDsIntervation(String dsIntervation) {
		this.dsIntervation = dsIntervation;
	}

	@Column(name = "ds_control")
	public String getDsControl() {
		return dsControl;
	}

	public void setDsControl(String dsControl) {
		this.dsControl = dsControl;
	}

	@Column(name = "ds_result")
	public String getDsResult() {
		return dsResult;
	}

	public void setDsResult(String dsResult) {
		this.dsResult = dsResult;
	}

	@Column(name = "ds_application_context")
	public String getDsApplicationContext() {
		return dsApplicationContext;
	}

	public void setDsApplicationContext(String dsApplicationContext) {
		this.dsApplicationContext = dsApplicationContext;
	}

	@Column(name = "ds_experimental_design")
	public String getDsExperimentalDesign() {
		return dsExperimentalDesign;
	}

	public void setDsExperimentalDesign(String dsExperimentalDesign) {
		this.dsExperimentalDesign = dsExperimentalDesign;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_project", nullable = false)
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
