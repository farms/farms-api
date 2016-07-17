package br.ufs.dcomp.farms.model.dao.map;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.dao.HibernateDao;
import br.ufs.dcomp.farms.model.entity.dba.ColumnDba;

@Component
@SuppressWarnings("unchecked")
public class ColumnsDao extends HibernateDao<ColumnDba> {

	public ColumnsDao() {
		super(ColumnDba.class);
	}
	
	/**
	 * Search columns by schema name.
	 * @param nmSchema
	 * @return List<Columns>
	 */
	public List<ColumnDba> getByNmSchema(String nmSchema) {
		Query query = getSession().createQuery("from ColumnDba where lower(table_schema) = lower(?)");
		query.setString(0, nmSchema);
		return query.list();
	}
	
	/**
	 * Search columns by table name.
	 * @param nmTable
	 * @return List<Columns>
	 */
	public List<ColumnDba> getByNmTable(String nmTable) {
		Query query = getSession().createQuery("from ColumnDba where lower(table_name) = lower(?)");
		query.setString(0, nmTable);
		return query.list();
	}
	
	/**
	 * Search column by name.
	 * @param nmColumn
	 * @return Column column
	 */
	public ColumnDba getByNmColumn(String nmColumn) {
		Query query = getSession().createQuery("from ColumnDba where lower(column_name) = lower(?)");
		query.setString(0, nmColumn);
		return (query.list() != null && !query.list().isEmpty()) ? (ColumnDba)query.list().get(0) : null;
	}
}