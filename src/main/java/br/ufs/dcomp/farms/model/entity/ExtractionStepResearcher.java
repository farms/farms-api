package br.ufs.dcomp.farms.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "extraction_step_researcher")
@XmlRootElement
public class ExtractionStepResearcher {

	private Long idExtractionStep;
	private Researcher researcher;
	
	@Id
	@Column(name = "id_extraction_step", nullable = false, unique = true)
	public Long getIdExtractionStep() {
		return idExtractionStep;
	}

	public void setIdExtractionStep(Long idExtractionStep) {
		this.idExtractionStep = idExtractionStep;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_researcher", nullable = false)
	public Researcher getResearcher() {
		return researcher;
	}

	public void setResearcher(Researcher researcher) {
		this.researcher = researcher;
	}
}
