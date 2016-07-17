package br.ufs.dcomp.farms.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "language")
@XmlRootElement
@SequenceGenerator(name = "LanguageSequenceGenerator", sequenceName = "sq_language")
public class Language {

	private Long idLanguage;
	private String nmLanguage;
	
	public Language() {}
	
	public Language(String nmLanguage) {
		this.nmLanguage = nmLanguage;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "LanguageSequenceGenerator")
	@Column(name = "id_language", nullable = false, unique = true)
	public Long getIdLanguage() {
		return idLanguage;
	}

	public void setIdLanguage(Long idLanguage) {
		this.idLanguage = idLanguage;
	}

	@Column(name = "nm_language", nullable = false)
	public String getNmLanguage() {
		return nmLanguage;
	}

	public void setNmLanguage(String nmLanguage) {
		this.nmLanguage = nmLanguage;
	}
}
