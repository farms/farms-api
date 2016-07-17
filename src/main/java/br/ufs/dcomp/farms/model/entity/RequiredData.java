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
@Table(name = "required_data")
@XmlRootElement
@SequenceGenerator(name = "RequiredDataSequenceGenerator", sequenceName = "sq_required_data")
public class RequiredData {

	private Long idRequiredData;
	private String dsRequiredData;
	private Project project;
	
	public RequiredData() {}
	
	public RequiredData(String dsRequiredData) {
		this.dsRequiredData = dsRequiredData;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "RequiredDataSequenceGenerator")
	@Column(name = "id_required_data", nullable = false, unique = true)
	public Long getIdRequiredData() {
		return idRequiredData;
	}

	public void setIdRequiredData(Long idRequiredData) {
		this.idRequiredData = idRequiredData;
	}

	@Column(name = "ds_required_data", nullable = false)
	public String getDsRequiredData() {
		return dsRequiredData;
	}

	public void setDsRequiredData(String dsRequiredData) {
		this.dsRequiredData = dsRequiredData;
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
