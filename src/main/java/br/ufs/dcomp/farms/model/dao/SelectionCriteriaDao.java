package br.ufs.dcomp.farms.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.entity.SelectionCriteria;

@Component
@SuppressWarnings("unchecked")
public class SelectionCriteriaDao extends HibernateDao<SelectionCriteria> {

	public SelectionCriteriaDao() {
		super(SelectionCriteria.class);
	}

	/**
	 * Returns all studies from the specified project.
	 *
	 * @param dsKey the identifier of the project.
	 * @return a list of all the studies of the specified project.
	 */
	public List<SelectionCriteria> getByDsKeyProject(String dsKey) {
		StringBuilder sbHql = new StringBuilder();
		sbHql.append("from SelectionCriteria sc");
		sbHql.append(" join fetch sc.project p");
		sbHql.append(" where p.dsKey = :dsKey");
		
		Query query = getSession().createQuery(sbHql.toString());
		query.setParameter("dsKey", dsKey);
		List<SelectionCriteria> selectionCriterias = query.list();
		return selectionCriterias;
	}
}
