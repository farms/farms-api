package br.ufs.dcomp.farms.model.entity.map;

public class ColumnMapped {
	
	private String nmColumn;
	private boolean columnsExists = false;
	private String nmTable;
	
	public ColumnMapped() {
		super();
	}

	public ColumnMapped(String nmColumn) {
		super();
		this.nmColumn = nmColumn;
	}

	public String getNmColumn() {
		return nmColumn;
	}

	public void setNmColumn(String nmColumn) {
		this.nmColumn = nmColumn;
	}

	public boolean isColumnsExists() {
		return columnsExists;
	}

	public void setColumnsExists(boolean columnsExists) {
		this.columnsExists = columnsExists;
	}

	public String getNmTable() {
		return nmTable;
	}

	public void setNmTable(String nmTable) {
		this.nmTable = nmTable;
	}
}
