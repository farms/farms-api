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
@Table(name = "adapted_query_search_field")
@XmlRootElement
public class AdaptedQuerySearchField {

	private Long idAdaptedQuery;
	private SearchField searchField;
	
	@Id
	@Column(name = "id_adapted_query", nullable = false, unique = true)
	public Long getIdAdaptedQuery() {
		return idAdaptedQuery;
	}

	public void setIdAdaptedQuery(Long idAdaptedQuery) {
		this.idAdaptedQuery = idAdaptedQuery;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_search_field", nullable = false)
	public SearchField getSearchField() {
		return searchField;
	}

	public void setSearchField(SearchField searchField) {
		this.searchField = searchField;
	}
}