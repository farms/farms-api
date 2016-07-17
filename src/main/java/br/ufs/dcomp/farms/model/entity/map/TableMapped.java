package br.ufs.dcomp.farms.model.entity.map;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Table;

public class TableMapped {

	private String nmTable;
	private SequenceMapped mappedSequence;
	private boolean tableExists = false;
	private List<String> nmColumnMappedList = new ArrayList<String>();
	private List<ColumnMapped> columnMappedList = new ArrayList<ColumnMapped>();
	
	public TableMapped() {
		super();
	}
	
	public TableMapped(Table table, SequenceMapped mappedSequence, List<ColumnMapped> mappedColumnList) {
		super();
		this.nmTable = table.name();
		this.mappedSequence = mappedSequence;
		this.columnMappedList = mappedColumnList;
	}

	public String getNmTable() {
		return nmTable;
	}
	
	public void setNmTable(String nmTable) {
		this.nmTable = nmTable;
	}
	
	public SequenceMapped getMappedSequence() {
		return mappedSequence;
	}
	
	public void setMappedSequence(SequenceMapped mappedSequence) {
		this.mappedSequence = mappedSequence;
	}

	public boolean isTableExists() {
		return tableExists;
	}

	public void setTableExists(boolean tableExists) {
		this.tableExists = tableExists;
	}

	public List<String> getNmMappedColumnList() {
		return nmColumnMappedList;
	}

	public void setNmMappedColumnList(List<String> nmMappedColumnList) {
		this.nmColumnMappedList = nmMappedColumnList;
	}
	
	public List<ColumnMapped> getMappedColumnList() {
		return columnMappedList;
	}
	
	public void setMappedColumnList(List<ColumnMapped> mappedColumnList) {
		this.columnMappedList = mappedColumnList;
	}
}
