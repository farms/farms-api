package br.ufs.dcomp.farms.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "country")
@XmlRootElement
@SequenceGenerator(name = "CountrySequenceGenerator", sequenceName = "sq_country")
public class Country {

	private Long idCountry;
	private String nmCountry;
	
	private Set<Institution> institutions = new HashSet<Institution>(0);
	
	public Country() {}
	
	public Country(String nmCountry) {
		this.nmCountry = nmCountry;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "CountrySequenceGenerator")
	@Column(name = "id_country", nullable = false, unique = true)
	public Long getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Long idCountry) {
		this.idCountry = idCountry;
	}

	@Column(name = "nm_country", nullable = false)
	public String getNmCountry() {
		return nmCountry;
	}

	public void setNmCountry(String nmCountry) {
		this.nmCountry = nmCountry;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<Institution> getInstitutions() {
		return this.institutions;
	}

	public void setInstitutions(Set<Institution> institutions) {
		this.institutions = institutions;
	}
}
