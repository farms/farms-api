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
@Table(name = "search_field")
@XmlRootElement
@SequenceGenerator(name = "SearchFieldSequenceGenerator", sequenceName = "sq_search_field")
public class SearchField {

	private Long idSearchField;
	private String dsSearchField;
	
	public SearchField() {}
	
	public SearchField(String dsSearchField) {
		this.dsSearchField = dsSearchField;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SearchFieldSequenceGenerator")
	@Column(name = "id_search_field", nullable = false, unique = true)
	public Long getIdSearchField() {
		return idSearchField;
	}

	public void setIdSearchField(Long idSearchField) {
		this.idSearchField = idSearchField;
	}

	@Column(name = "ds_search_field", nullable = false)
	public String getDsSearchField() {
		return dsSearchField;
	}

	public void setDsSearchField(String dsSearchField) {
		this.dsSearchField = dsSearchField;
	}
}
