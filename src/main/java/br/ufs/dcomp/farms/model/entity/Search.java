package br.ufs.dcomp.farms.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import br.ufs.dcomp.farms.model.enums.SearchEnum;

@Entity
@Table(name = "search")
@XmlRootElement
@SequenceGenerator(name = "SearchSequenceGenerator", sequenceName = "sq_search")
public class Search implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idSearch;
	private Long nrSearch;
	private String nmSearch;
	private Date dhSearch;
	private String dsSearch;
	private SearchEnum tpSearch;
	private Project project;
	private AdaptedQuery adaptedQuery;
	
	private Set<Study> studies = new HashSet<Study>(0);
	
	public Search() {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SearchSequenceGenerator")
	@Column(name = "id_search", nullable = false, unique = true)
	public Long getIdSearch() {
		return idSearch;
	}

	public void setIdSearch(Long idSearch) {
		this.idSearch = idSearch;
	}

	@Column(name = "nr_search", nullable = false, unique = true)
	public Long getNrSearch() {
		return nrSearch;
	}

	public void setNrSearch(Long nrSearch) {
		this.nrSearch = nrSearch;
	}

	@Column(name = "nm_search", nullable = false, unique = true)
	public String getNmSearch() {
		return nmSearch;
	}

	public void setNmSearch(String nmSearch) {
		this.nmSearch = nmSearch;
	}

	@Column(name = "dh_search", nullable = false, unique = true)
	public Date getDhSearch() {
		return dhSearch;
	}

	public void setDhSearch(Date dhSearch) {
		this.dhSearch = dhSearch;
	}

	@Column(name = "ds_search", nullable = false, unique = true)
	public String getDsSearch() {
		return dsSearch;
	}

	public void setDsSearch(String dsSearch) {
		this.dsSearch = dsSearch;
	}

	@Column(name = "tp_search", nullable = false)
	@Enumerated(EnumType.ORDINAL)	
	public SearchEnum getTpSearch() {
		return tpSearch;
	}

	public void setTpSearch(SearchEnum tpSearch) {
		this.tpSearch = tpSearch;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_project", nullable = false)
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_adapted_query", nullable = false)
	public AdaptedQuery getAdaptedQuery() {
		return adaptedQuery;
	}

	public void setAdaptedQuery(AdaptedQuery adaptedQuery) {
		this.adaptedQuery = adaptedQuery;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "search")
	public Set<Study> getStudies() {
		return this.studies;
	}

	public void setStudies(Set<Study> studies) {
		this.studies = studies;
	}
}
