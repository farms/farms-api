package br.ufs.dcomp.farms.model.dao.map;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.dao.HibernateDao;
import br.ufs.dcomp.farms.model.entity.dba.SequenceDba;

@Component
@SuppressWarnings("unchecked")
public class SequencesDao  extends HibernateDao<SequencesDao> {

	public SequencesDao() {
		super(SequencesDao.class);
	}
	
	/**
	 * Search sequences by schema name.
	 * @param nmSchema
	 * @return List<Sequences>
	 */
	public List<SequenceDba> getByNmSchema(String nmSchema) {
		Query query = getSession().createQuery("from SequenceDba where lower(sequence_schema) = lower(?)");
		query.setString(0, nmSchema);
		return query.list();
	}
	
	/**
	 * Search sequence by name.
	 * @param nmTable
	 * @return Sequence sequence
	 */
	public SequenceDba getByNmSequence(String nmSequence) {
		Query query = getSession().createQuery("from SequenceDba where lower(sequence_name) = lower(?)");
		query.setString(0, nmSequence);
		return (query.list() != null && !query.list().isEmpty()) ? (SequenceDba)query.list().get(0) : null;
	}
}