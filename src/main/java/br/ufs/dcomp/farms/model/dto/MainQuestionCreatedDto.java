package br.ufs.dcomp.farms.model.dto;

import br.ufs.dcomp.farms.model.entity.MainQuestion;

public class MainQuestionCreatedDto {

	private String dsMainQuestion;
	private String dsPopulation;
	private String dsIntervation;
	private String dsControl;
	private String dsResult;
	private String dsApplicationContext;
	private String dsExperimentalDesign;
	private String dsProjectKey;
	
	public MainQuestionCreatedDto(MainQuestion mainQuestion) {
		this.dsMainQuestion = mainQuestion.getDsMainQuestion();
		this.dsPopulation = mainQuestion.getDsPopulation();
		this.dsIntervation = mainQuestion.getDsIntervation();
		this.dsControl = mainQuestion.getDsControl();
		this.dsResult = mainQuestion.getDsResult();
		this.dsApplicationContext = mainQuestion.getDsApplicationContext();
		this.dsExperimentalDesign = mainQuestion.getDsExperimentalDesign();
		this.dsProjectKey = mainQuestion.getProject().getDsKey();
	}
	
	public String getDsMainQuestion() {
		return dsMainQuestion;
	}
	
	public void setDsMainQuestion(String dsMainQuestion) {
		this.dsMainQuestion = dsMainQuestion;
	}
	
	public String getDsPopulation() {
		return dsPopulation;
	}
	
	public void setDsPopulation(String dsPopulation) {
		this.dsPopulation = dsPopulation;
	}
	
	public String getDsIntervation() {
		return dsIntervation;
	}
	
	public void setDsIntervation(String dsIntervation) {
		this.dsIntervation = dsIntervation;
	}
	
	public String getDsControl() {
		return dsControl;
	}
	
	public void setDsControl(String dsControl) {
		this.dsControl = dsControl;
	}
	
	public String getDsResult() {
		return dsResult;
	}
	
	public void setDsResult(String dsResult) {
		this.dsResult = dsResult;
	}
	
	public String getDsApplicationContext() {
		return dsApplicationContext;
	}
	
	public void setDsApplicationContext(String dsApplicationContext) {
		this.dsApplicationContext = dsApplicationContext;
	}
	
	public String getDsExperimentalDesign() {
		return dsExperimentalDesign;
	}
	public void setDsExperimentalDesign(String dsExperimentalDesign) {
		this.dsExperimentalDesign = dsExperimentalDesign;
	}
	
	public String getDsProjectKey() {
		return dsProjectKey;
	}
	
	public void setDsProjectKey(String dsProjectKey) {
		this.dsProjectKey = dsProjectKey;
	}
}
