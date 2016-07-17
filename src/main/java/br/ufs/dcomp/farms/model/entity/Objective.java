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
@Table(name = "objective")
@XmlRootElement
@SequenceGenerator(name = "ObjectiveSequenceGenerator", sequenceName = "sq_objective")
public class Objective {

	private Long idObjective;
	private String dsObjective;
	private Project project;
	
	public Objective() {}
	
	public Objective(String dsObjective) {
		this.dsObjective = dsObjective;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ObjectiveSequenceGenerator")
	@Column(name = "id_objective", nullable = false, unique = true)
	public Long getIdObjective() {
		return idObjective;
	}

	public void setIdObjective(Long idObjective) {
		this.idObjective = idObjective;
	}

	@Column(name = "ds_objective", nullable = false)
	public String getDsObjective() {
		return dsObjective;
	}

	public void setDsObjective(String dsObjective) {
		this.dsObjective = dsObjective;
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
