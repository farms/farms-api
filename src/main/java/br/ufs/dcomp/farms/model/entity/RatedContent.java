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
@Table(name = "rated_content")
@XmlRootElement
@SequenceGenerator(name = "RatedContentSequenceGenerator", sequenceName = "sq_rated_content")
public class RatedContent {

	private Long idRatedContent;
	private String dsRatedContent;
	
	public RatedContent() {}
	
	public RatedContent(String dsRatedContent) {
		this.dsRatedContent = dsRatedContent;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "RatedContentSequenceGenerator")
	@Column(name = "id_rated_content", nullable = false, unique = true)
	public Long getIdRatedContent() {
		return idRatedContent;
	}

	public void setIdRatedContent(Long idRatedContent) {
		this.idRatedContent = idRatedContent;
	}

	@Column(name = "ds_rated_content", nullable = false)
	public String getDsRatedContent() {
		return dsRatedContent;
	}

	public void setDsRatedContent(String dsRatedContent) {
		this.dsRatedContent = dsRatedContent;
	}
}
