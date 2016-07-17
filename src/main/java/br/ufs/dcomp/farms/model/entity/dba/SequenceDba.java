package br.ufs.dcomp.farms.model.entity.dba;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "sequences", schema="information_schema")
@XmlRootElement
public class SequenceDba {

	private String nmSequence;
	private String tpData;
	private String nmCatalog;
	private String nmSchema;
	
	public SequenceDba() {
		super();
	}

	public SequenceDba(String nmSequence, String tpData, String nmCatalog, String nmSchema) {
		super();
		this.nmSequence = nmSequence;
		this.tpData = tpData;
		this.nmCatalog = nmCatalog;
		this.nmSchema = nmSchema;
	}

	@Id
	@Column(name = "sequence_name")
	public String getNmSequence() {
		return nmSequence;
	}
	
	public void setNmSequence(String nmSequence) {
		this.nmSequence = nmSequence;
	}
	
	@Column(name = "data_type")
	public String getTpData() {
		return tpData;
	}
	
	public void setTpData(String tpData) {
		this.tpData = tpData;
	}
	
	@Column(name = "sequence_catalog")
	public String getNmCatalog() {
		return nmCatalog;
	}
	
	public void setNmCatalog(String nmCatalog) {
		this.nmCatalog = nmCatalog;
	}
	
	@Column(name = "sequence_schema")
	public String getNmSchema() {
		return nmSchema;
	}
	
	public void setNmSchema(String nmSchema) {
		this.nmSchema = nmSchema;
	}
}