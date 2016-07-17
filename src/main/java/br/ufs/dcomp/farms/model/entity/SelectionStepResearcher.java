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
@Table(name = "selection_step_researcher")
@XmlRootElement
public class SelectionStepResearcher {

	private Long idSelectionStep;
	private Researcher researcher;
	
	@Id
	@Column(name = "id_selection_step", nullable = false, unique = true)
	public Long getIdSelectionStep() {
		return idSelectionStep;
	}

	public void setIdSelectionStep(Long idSelectionStep) {
		this.idSelectionStep = idSelectionStep;
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
