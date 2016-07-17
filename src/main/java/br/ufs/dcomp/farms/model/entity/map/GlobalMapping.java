package br.ufs.dcomp.farms.model.entity.map;

import java.util.ArrayList;
import java.util.List;

public class GlobalMapping {

	private List<String> nmMappedTableList = new ArrayList<String>();
	private List<String> nmMappedSequenceList = new ArrayList<String>();
	
	private List<TableMapped> mappedTableList = new ArrayList<TableMapped>();
	private List<SequenceMapped> mappedSequenceList = new ArrayList<SequenceMapped>();
	private List<ColumnMapped> mappedColumnList = new ArrayList<ColumnMapped>();
	
	public GlobalMapping() {
		super();
	}

	public List<String> getNmMappedTableList() {
		return nmMappedTableList;
	}

	public void setNmMappedTableList(List<String> nmMappedTableList) {
		this.nmMappedTableList = nmMappedTableList;
	}

	public List<String> getNmMappedSequenceList() {
		return nmMappedSequenceList;
	}

	public void setNmMappedSequenceList(List<String> nmMappedSequenceList) {
		this.nmMappedSequenceList = nmMappedSequenceList;
	}

	public List<TableMapped> getMappedTableList() {
		return mappedTableList;
	}

	public void setMappedTableList(List<TableMapped> mappedTableList) {
		this.mappedTableList = mappedTableList;
	}

	public List<SequenceMapped> getMappedSequenceList() {
		return mappedSequenceList;
	}

	public void setMappedSequenceList(List<SequenceMapped> mappedSequenceList) {
		this.mappedSequenceList = mappedSequenceList;
	}

	public List<ColumnMapped> getMappedColumnList() {
		return mappedColumnList;
	}

	public void setMappedColumnList(List<ColumnMapped> mappedColumnList) {
		this.mappedColumnList = mappedColumnList;
	}
}