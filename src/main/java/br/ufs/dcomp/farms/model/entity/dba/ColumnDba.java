package br.ufs.dcomp.farms.model.entity.dba;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "columns", schema="information_schema")
@XmlRootElement
public class ColumnDba {

	private String nmColumn;
	private String tpData;
	private String isNullable;
	private Integer nrCaracterMaximum;
	private String nmCatalog;
	private String nmSchema;
	private String nmTable;
	
	public ColumnDba() {
		super();
	}

	@Id
	@Column(name = "column_name")
	public String getNmColumn() {
		return nmColumn;
	}
	
	public void setNmColumn(String nmColumn) {
		this.nmColumn = nmColumn;
	}
	
	@Column(name = "data_type")
	public String getTpData() {
		return tpData;
	}

	public void setTpData(String tpData) {
		this.tpData = tpData;
	}
	
	@Column(name = "is_nullable")
	public String getIsNullable() {
		return isNullable;
	}
	
	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}
	
	@Column(name = "character_maximum_length")
	public Integer getNrCaracterMaximum() {
		return nrCaracterMaximum;
	}
	
	public void setNrCaracterMaximum(Integer nrCaracterMaximum) {
		this.nrCaracterMaximum = nrCaracterMaximum;
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
	
	@Column(name = "table_name")
	public String getNmTable() {
		return nmTable;
	}
	
	public void setNmTable(String nmTable) {
		this.nmTable = nmTable;
	}
}