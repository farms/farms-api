package br.ufs.dcomp.farms.model.dao.map;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.dao.HibernateDao;
import br.ufs.dcomp.farms.model.entity.dba.TableDba;

@Component
@SuppressWarnings("unchecked")
public class TablesDao  extends HibernateDao<TableDba> {

	public TablesDao() {
		super(TableDba.class);
	}
	
	/**
	 * Search tables by schema name.
	 * @param nmSchema
	 * @return List<Tables>
	 */
	public List<TableDba> getByNmSchema(String nmSchema) {
		Query query = getSession().createQuery("from TableDba where lower(table_schema) = lower(?)");
		query.setString(0, nmSchema);
		return query.list();
	}
	
	/**
	 * Search table by name.
	 * @param nmTable
	 * @return Table table
	 */
	public TableDba getByNmTable(String nmTable) {
		Query query = getSession().createQuery("from TableDba where lower(table_name) = lower(?)");
		query.setString(0, nmTable);
		return (query.list() != null && !query.list().isEmpty()) ? (TableDba)query.list().get(0) : null;
	}
}