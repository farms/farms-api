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
@Table(name = "secondary_question")
@XmlRootElement
@SequenceGenerator(name = "SecondaryQuestionSequenceGenerator", sequenceName = "sq_secondary_question")
public class SecondaryQuestion {

	private Long idSecondaryQuestion;
	private String dsSecondaryQuestion;
	private Project project;
	
	public SecondaryQuestion() {}
	
	public SecondaryQuestion(String dsSecondaryQuestion) {
		this.dsSecondaryQuestion = dsSecondaryQuestion;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SecondaryQuestionSequenceGenerator")
	@Column(name = "id_secondary_question", nullable = false, unique = true)
	public Long getIdSecondaryQuestion() {
		return idSecondaryQuestion;
	}

	public void setIdSecondaryQuestion(Long idSecondaryQuestion) {
		this.idSecondaryQuestion = idSecondaryQuestion;
	}

	@Column(name = "ds_secondary_question", nullable = false)
	public String getDsSecondaryQuestion() {
		return dsSecondaryQuestion;
	}

	public void setDsSecondaryQuestion(String dsSecondaryQuestion) {
		this.dsSecondaryQuestion = dsSecondaryQuestion;
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