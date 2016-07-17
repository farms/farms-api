package br.ufs.dcomp.farms.model.entity;

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

import br.ufs.dcomp.farms.model.enums.CriteriaEnum;

@Entity
@Table(name = "selection_criteria")
@XmlRootElement
@SequenceGenerator(name = "SelectionCriteriaSequenceGenerator", sequenceName = "sq_selection_criteria")
public class SelectionCriteria {

	private Long idSelectionCriteria;
	private String dsSelectionCriteria;
	private CriteriaEnum tpCriteria;
	private Project project;
	
	public SelectionCriteria() {}
	
	public SelectionCriteria(String dsSelectionCriteria, CriteriaEnum tpCriteria) {
		this.dsSelectionCriteria = dsSelectionCriteria;
		this.tpCriteria = tpCriteria;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SelectionCriteriaSequenceGenerator")
	@Column(name = "id_selection_criteria", nullable = false, unique = true)
	public Long getIdSelectionCriteria() {
		return idSelectionCriteria;
	}

	public void setIdSelectionCriteria(Long idSelectionCriteria) {
		this.idSelectionCriteria = idSelectionCriteria;
	}

	@Column(name = "ds_selection_criteria", nullable = false)
	public String getDsSelectionCriteria() {
		return dsSelectionCriteria;
	}

	public void setDsSelectionCriteria(String dsSelectionCriteria) {
		this.dsSelectionCriteria = dsSelectionCriteria;
	}
	
	@Column(name = "tp_criteria", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	public CriteriaEnum getTpCriteria() {
		return this.tpCriteria;
	}

	public void setTpCriteria(CriteriaEnum tpCriteria) {
		this.tpCriteria = tpCriteria;
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
