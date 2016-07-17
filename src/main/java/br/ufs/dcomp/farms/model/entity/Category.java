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
@Table(name = "category")
@XmlRootElement
@SequenceGenerator(name = "CategorySequenceGenerator", sequenceName = "sq_category")
public class Category {

	private Long idCategory;
	private String dsCategory;
	private Project project;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "CategorySequenceGenerator")
	@Column(name = "id_category", nullable = false, unique = true)
	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	@Column(name = "ds_category", nullable = false)
	public String getDsCategory() {
		return dsCategory;
	}

	public void setDsCategory(String dsCategory) {
		this.dsCategory = dsCategory;
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
