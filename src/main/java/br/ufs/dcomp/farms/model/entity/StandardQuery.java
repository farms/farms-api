package br.ufs.dcomp.farms.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "standard_query")
@XmlRootElement
@SequenceGenerator(name = "StandardQuerySequenceGenerator", sequenceName = "sq_search_keyword")
public class StandardQuery {

	private Long idStandardQuery;
	private String dsStandardQuery;
	private Project project;
	
	private Set<AdaptedQuery> adaptedQuerys = new HashSet<AdaptedQuery>(0);
	
	public StandardQuery() {}
	
	public StandardQuery(String dsStandardQuery) {
		this.dsStandardQuery = dsStandardQuery;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "StandardQuerySequenceGenerator")
	@Column(name = "id_standard_query", nullable = false, unique = true)
	public Long getIdStandardQuery() {
		return idStandardQuery;
	}

	public void setIdStandardQuery(Long idStandardQuery) {
		this.idStandardQuery = idStandardQuery;
	}

	@Column(name = "ds_standard_query", nullable = false)
	public String getDsStandardQuery() {
		return dsStandardQuery;
	}

	public void setDsStandardQuery(String dsStandardQuery) {
		this.dsStandardQuery = dsStandardQuery;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_project", nullable = false)
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "standardQuery")
	public Set<AdaptedQuery> getAdaptedQuerys() {
		return this.adaptedQuerys;
	}

	public void setAdaptedQuerys(Set<AdaptedQuery> adaptedQuerys) {
		this.adaptedQuerys = adaptedQuerys;
	}
}
