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
@Table(name = "author")
@XmlRootElement
@SequenceGenerator(name = "AuthorSequenceGenerator", sequenceName = "sq_author")
public class Author {

	private Long idAuthor;
	private String nmAuthor;
	private String snAuthor;
	private Institution institution;
	
	public Author() {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "AuthorSequenceGenerator")
	@Column(name = "id_author", nullable = false, unique = true)
	public Long getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(Long idAuthor) {
		this.idAuthor = idAuthor;
	}

	@Column(name = "nm_author", nullable = false, unique = true)
	public String getNmAuthor() {
		return nmAuthor;
	}

	public void setNmAuthor(String nmAuthor) {
		this.nmAuthor = nmAuthor;
	}

	@Column(name = "sn_author", nullable = false, unique = true)
	public String getSnAuthor() {
		return snAuthor;
	}

	public void setSnAuthor(String snAuthor) {
		this.snAuthor = snAuthor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_institution", nullable = false)
	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
}
