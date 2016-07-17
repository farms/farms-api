package br.ufs.dcomp.farms.model.service.map;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.core.map.ClassTest;
import br.ufs.dcomp.farms.model.dao.map.ColumnsDao;
import br.ufs.dcomp.farms.model.dao.map.SequencesDao;
import br.ufs.dcomp.farms.model.dao.map.TablesDao;
import br.ufs.dcomp.farms.model.entity.dba.ColumnDba;
import br.ufs.dcomp.farms.model.entity.dba.SequenceDba;
import br.ufs.dcomp.farms.model.entity.dba.TableDba;
import br.ufs.dcomp.farms.model.entity.map.ColumnMapped;
import br.ufs.dcomp.farms.model.entity.map.GlobalMapping;
import br.ufs.dcomp.farms.model.entity.map.SequenceMapped;
import br.ufs.dcomp.farms.model.entity.map.TableMapped;

@Component
@SuppressWarnings({ "rawtypes" })
public class MappingService {

	private List<Class> clazzList = null;
	
	private String SCHEMA_NAME = "public";
	private String PACKAGE_NAME = "br.ufs.dcomp.farms.model.entity";
	
	@Autowired
	private TablesDao tablesDao;
	
	@Autowired
	private SequencesDao sequencesDao;
	
	@Autowired
	private ColumnsDao columnsDao;
	
	
	public MappingService() {
		super();
		try {
			clazzList = ClassTest.getClasses(PACKAGE_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Obtém todos os objetos mapeados por annotations JPA.
	 * 
	 * @return GlobalMapped
	 */
	public GlobalMapping getMappingAllClasses() {
		
		GlobalMapping globalMapping = new GlobalMapping();
		List<TableMapped> mappedTableList = new ArrayList<TableMapped>();
		
		for (Class<?> clazz : clazzList) {
			TableMapped mappedTable = new TableMapped();
			SequenceMapped mappedSequence = new SequenceMapped();
			
			// Tabelas mapeadas nas classes.
			Table tableAnnotation = clazz.getAnnotation(Table.class);
			if (tableAnnotation != null) {
				//System.out.println("TABLE NAME: " + tableAnnotation.name());
				globalMapping.getNmMappedTableList().add(tableAnnotation.name());
				
				mappedTable.setNmTable(tableAnnotation.name());
				TableDba tableDb = tablesDao.getByNmTable(tableAnnotation.name());
				boolean tableExists = (tableDb != null) ? true : false;
				mappedTable.setTableExists(tableExists);
			}

			// Sequences mapeadas nas classes.
			SequenceGenerator sequenceGeneratorAnnotation = clazz.getAnnotation(SequenceGenerator.class);
			if (sequenceGeneratorAnnotation != null) {
				//System.out.println("  -> SEQUENCE NAME: " + sequenceGenerator.sequenceName());
				globalMapping.getNmMappedSequenceList().add(sequenceGeneratorAnnotation.sequenceName());
				
				mappedSequence.setNmSequence(sequenceGeneratorAnnotation.sequenceName());
				SequenceDba sequenceDb = sequencesDao.getByNmSequence(sequenceGeneratorAnnotation.sequenceName());
				boolean sequenceExists = (sequenceDb != null) ? true : false;
				mappedSequence.setSequenceExists(sequenceExists);
				mappedTable.setMappedSequence(mappedSequence);
			}
			
			// Methods mapeados nas classes.
			Method[] methodAnnotation = clazz.getMethods();
			List<ColumnMapped> mappedColumnList = new ArrayList<ColumnMapped>();
			for (Method method : methodAnnotation) {
				Column columnAnnotation = method.getAnnotation(Column.class);
				if (columnAnnotation != null) {
					ColumnMapped mappedColumn = new ColumnMapped();
					//System.out.println("    -> Column name: " + column.name());
					mappedTable.getNmMappedColumnList().add(columnAnnotation.name());
					
					mappedColumn.setNmColumn(columnAnnotation.name());;
					ColumnDba columnDb = columnsDao.getByNmColumn(columnAnnotation.name());
					boolean columnsExists = (columnDb != null) ? true : false;
					mappedColumn.setColumnsExists(columnsExists);;
					mappedColumnList.add(mappedColumn);
				}
				
				JoinColumn joinColumnAnnotation = method.getAnnotation(JoinColumn.class);
				if (joinColumnAnnotation != null) {
					mappedTable.getNmMappedColumnList().add(joinColumnAnnotation.name());
				}
			}
			mappedTable.setMappedColumnList(mappedColumnList);
			if (mappedTable.getNmTable() != null) {
				mappedTableList.add(mappedTable);
			}
		}
		
		globalMapping.setMappedTableList(mappedTableList);
		return globalMapping;
	}
	
	/**
	 * Exibe colunas que não estão mapeadas.
	 * @param mappedGlobal
	 */
	public void getAllTableColumnsNotMapped() {
		List<TableDba> tableDbList = tablesDao.getByNmSchema(SCHEMA_NAME);
		GlobalMapping globalMapping = getMappingAllClasses();
		for (TableDba tableDba : tableDbList) {
			int countColumns = 0;
			for (TableMapped tableMapped : globalMapping.getMappedTableList()) {
				if (tableMapped.getNmTable() != null && tableDba.getNmTable().equals(tableMapped.getNmTable())) {
					List<ColumnDba> columnDbaList = columnsDao.getByNmTable(tableDba.getNmTable());
					for (ColumnDba columnDba : columnDbaList) {
						if (!tableMapped.getNmMappedColumnList().contains(columnDba.getNmColumn())) {
							System.out.println(columnDba.getNmColumn());
							++countColumns;
						}
					}
					if (countColumns > 0) {
						System.out.println("TABLE: " + tableDba.getNmTable());
						System.out.println("COLUMN NOT MAPPED: ");
					}
				}
			}
			if (countColumns > 0) {
				System.out.println(" ");
			}
		}
	}

	/**
	 * // Exibe o que não existe no banco de dados, mas está mapeado nas classes.
	 * @param mappedGlobal
	 */
	public void getAllObjectsMappedWithoutMatchingDatabaseObject() {
		GlobalMapping globalMapping = getMappingAllClasses();
		for (TableMapped tableMapped : globalMapping.getMappedTableList()) {
			
			// SEQUENCES
			if (tableMapped.getMappedSequence() != null && tableMapped.getMappedSequence().getNmSequence() != null) {
				SequenceMapped sequenceMapped = tableMapped.getMappedSequence();
				if (!sequenceMapped.isSequenceExists()) {
					System.out.println("SEQUENCE: " + sequenceMapped.getNmSequence() + " -> " + sequenceMapped.isSequenceExists());
				}
			}
			
			// TABLES
			if (tableMapped.getNmTable() != null) {
				if (!tableMapped.isTableExists()) {
					System.out.println("TABLE: " + tableMapped.getNmTable() + " -> " + tableMapped.isTableExists());
				}
			}
			
			// COLUMNS
			for (ColumnMapped columnTable : tableMapped.getMappedColumnList()) {
				if (!columnTable.isColumnsExists()) {
					System.out.println("TABLE: " + tableMapped.getNmTable() + " -> " + tableMapped.isTableExists());
					System.out.println("COLUMN: " + columnTable.getNmColumn() + " -> " + columnTable.isColumnsExists());
				}
			}
		}
	}

	/**
	 * Exibe tabelas que não estão mapeadas.
	 * @param mappedGlobal
	 */
	public void getAllTablesNotMapped() {
		GlobalMapping globalMapping = getMappingAllClasses();
		int totalTables = 0;
		List<TableDba> tableDbList = tablesDao.getByNmSchema(SCHEMA_NAME);
		for (TableDba tableDb : tableDbList) {
			if (!globalMapping.getNmMappedTableList().contains(tableDb.getNmTable())) {
				System.out.println("TABLE NOT EXISTS: " + tableDb.getNmTable());
				++totalTables;
			}
		}
		System.out.println("TOTAL TABLES: " + totalTables);
	}

	public List<String> getAllTableMappedName(Class<?> clazz) {
		List<String> nmMappedTableList = new ArrayList<String>();
		Table table = clazz.getAnnotation(Table.class);
		if (table != null) {
			System.out.println("TABLE NAME: " + table.name());
			nmMappedTableList.add(table.name());
		}
		return nmMappedTableList;
	}

	public List<String> getAllSequenceMappedName(Class<?> clazz) {
		List<String> nmMappedSequenceList = new ArrayList<String>();
		SequenceGenerator sequenceGenerator = clazz.getAnnotation(SequenceGenerator.class);
		if (sequenceGenerator != null) {
			System.out.println("SEQUENCE NAME: " + sequenceGenerator.sequenceName());
			nmMappedSequenceList.add(sequenceGenerator.sequenceName());
		}
		return nmMappedSequenceList;
	}

	public List<String> getAllClassMappedMethodName(Class<?> clazz) {
		List<String> nmMappedColumnList = new ArrayList<String>();
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			Column column = method.getAnnotation(Column.class);
			if (column != null) {
				System.out.println("COLUMN NAME: " + column.name());
				nmMappedColumnList.add(column.name());
			}
		}
		return nmMappedColumnList;
	}
	
	public void getAllClassField(Class<?> clazz) {
		for (Field field : clazz.getDeclaredFields()) {
			 System.out.println(field.getName());
			 //Method method = clazz.getMethod("get"+field.getName());
		}
	}

	public void getAllObjectMapped() throws NoSuchMethodException, SecurityException {
		for (Class<?> clazz : clazzList) {
			getAllTableMappedName(clazz);
			getAllSequenceMappedName(clazz);
			getAllClassMappedMethodName(clazz);
			System.out.println(" ");
		}
	}
}