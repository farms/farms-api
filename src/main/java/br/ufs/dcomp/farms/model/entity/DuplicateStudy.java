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
@Table(name = "duplicate_study")
@XmlRootElement
public class DuplicateStudy {

	private Long idStudy;
	private Study study;
	
	public DuplicateStudy() {}

	@Id
	@Column(name = "id_study", nullable = false, unique = true)
	public Long getIdStudy() {
		return idStudy;
	}

	public void setIdStudy(Long idStudy) {
		this.idStudy = idStudy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_duplicate_study", nullable = false)
	public Study getStudy() {
		return study;
	}

	public void setStudy(Study study) {
		this.study = study;
	}
}
