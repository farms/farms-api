package br.ufs.dcomp.farms.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.entity.StandardQuery;

@Component
@SuppressWarnings("unchecked")
public class StandardQueryDao extends HibernateDao<StandardQuery> {

	public StandardQueryDao() {
		super(StandardQuery.class);
	}

	/**
	 * Returns the standard query from the specified project.
	 *
	 * @param dsKey the identifier of the project.
	 * @return a list with a standard query of the specified project.
	 */
	public List<StandardQuery> getByDsKeyProject(String dsKey) {
		StringBuilder sbHql = new StringBuilder();
		sbHql.append("from StandardQuery sq");
		sbHql.append(" join fetch sq.project p");
		sbHql.append(" where p.dsKey = :dsKey");
		
		Query query = getSession().createQuery(sbHql.toString());
		query.setParameter("dsKey", dsKey);
		List<StandardQuery> standardQueries = query.list();
		return standardQueries;
	}
}
