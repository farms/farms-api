package br.ufs.dcomp.farms.model.entity.dba;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tables", schema="information_schema")
@XmlRootElement
public class TableDba {

	private String nmTable;
	private String tpTable;
	private String nmCatalog;
	private String nmSchema;
	
	public TableDba() {
		super();
	}

	public TableDba(String nmTable, String tpTable, String nmCatalog, String nmSchema) {
		super();
		this.nmTable = nmTable;
		this.tpTable = tpTable;
		this.nmCatalog = nmCatalog;
		this.nmSchema = nmSchema;
	}

	@Id
	@Column(name = "table_name")
	public String getNmTable() {
		return nmTable;
	}

	public void setNmTable(String nmTable) {
		this.nmTable = nmTable;
	}

	@Column(name = "table_type")
	public String getTpTable() {
		return tpTable;
	}

	public void setTpTable(String tpTable) {
		this.tpTable = tpTable;
	}

	@Column(name = "table_catalog")
	public String getNmCatalog() {
		return nmCatalog;
	}

	public void setNmCatalog(String nmCatalog) {
		this.nmCatalog = nmCatalog;
	}
	
	@Column(name = "table_schema")
	public String getNmSchema() {
		return nmSchema;
	}

	public void setNmSchema(String nmSchema) {
		this.nmSchema = nmSchema;
	}
}
