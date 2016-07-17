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
@Table(name = "study_author")
@XmlRootElement
public class StudyAuthor {

	private Long idStudyAuthor;
	private Author author;

	@Id
	@Column(name = "id_study", nullable = false, unique = true)
	public Long getIdStudyAuthor() {
		return idStudyAuthor;
	}

	public void setIdStudyAuthor(Long idStudyAuthor) {
		this.idStudyAuthor = idStudyAuthor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_author", nullable = false)
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
}
