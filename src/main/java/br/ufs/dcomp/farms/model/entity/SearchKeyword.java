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
@Table(name = "search_keyword")
@XmlRootElement
@SequenceGenerator(name = "SearchKeywordSequenceGenerator", sequenceName = "sq_search_keyword")
public class SearchKeyword {

	private Long idSearchKeyword;
	private String dsSearchKeyword;
	private Project project;
	
	public SearchKeyword() {}
	
	public SearchKeyword(String dsSearchKeyword) {
		this.dsSearchKeyword = dsSearchKeyword;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SearchKeywordSequenceGenerator")
	@Column(name = "id_search_keyword", nullable = false, unique = true)
	public Long getIdSearchKeyword() {
		return idSearchKeyword;
	}

	public void setIdSearchKeyword(Long idSearchKeyword) {
		this.idSearchKeyword = idSearchKeyword;
	}

	@Column(name = "ds_search_keyword", nullable = false)
	public String getDsSearchKeyword() {
		return dsSearchKeyword;
	}

	public void setDsSearchKeyword(String dsSearchKeyword) {
		this.dsSearchKeyword = dsSearchKeyword;
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
