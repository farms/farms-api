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
@Table(name = "option")
@XmlRootElement
@SequenceGenerator(name = "OptionSequenceGenerator", sequenceName = "sq_option")
public class Option {

	private Long idOption;
	private String dsOption;
	private Category category;
	
	public Option() {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "OptionSequenceGenerator")
	@Column(name = "id_option", nullable = false, unique = true)
	public Long getIdOption() {
		return idOption;
	}

	public void setIdOption(Long idOption) {
		this.idOption = idOption;
	}

	@Column(name = "ds_option", nullable = false, unique = true)
	public String getDsOption() {
		return dsOption;
	}

	public void setDsOption(String dsOption) {
		this.dsOption = dsOption;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category", nullable = false)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
