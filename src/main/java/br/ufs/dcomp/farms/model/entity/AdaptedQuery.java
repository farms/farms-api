package br.ufs.dcomp.farms.model.entity;

import java.io.Serializable;

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
@Table(name = "adapted_query")
@XmlRootElement
@SequenceGenerator(name = "AdaptedQuerySequenceGenerator", sequenceName = "sq_adapted_query")
public class AdaptedQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idStandardQuery;
	private String dsStandardQuery;
	private String dsObservation;
	private SearchEngine searchEngine;
	private StandardQuery standardQuery;
	
	public AdaptedQuery() {}
	
	public AdaptedQuery(String dsStandardQuery) {
		this.dsStandardQuery = dsStandardQuery;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "AdaptedQuerySequenceGenerator")
	@Column(name = "id_adapted_query", nullable = false, unique = true)
	public Long getIdStandardQuery() {
		return idStandardQuery;
	}

	public void setIdStandardQuery(Long idStandardQuery) {
		this.idStandardQuery = idStandardQuery;
	}

	@Column(name = "ds_adapted_query", nullable = false)
	public String getDsStandardQuery() {
		return dsStandardQuery;
	}

	public void setDsStandardQuery(String dsStandardQuery) {
		this.dsStandardQuery = dsStandardQuery;
	}

	@Column(name = "ds_observation")
	public String getDsObservation() {
		return dsObservation;
	}

	public void setDsObservation(String dsObservation) {
		this.dsObservation = dsObservation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_search_engine", nullable = false)
	public SearchEngine getSearchEngine() {
		return searchEngine;
	}

	public void setSearchEngine(SearchEngine searchEngine) {
		this.searchEngine = searchEngine;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_standard_query", nullable = false)
	public StandardQuery getStandardQuery() {
		return standardQuery;
	}

	public void setStandardQuery(StandardQuery standardQuery) {
		this.standardQuery = standardQuery;
	}
}
