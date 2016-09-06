package br.ufs.dcomp.farms.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.entity.Objective;

@Component
@SuppressWarnings("unchecked")
public class ObjectiveDao extends HibernateDao<Objective> {

	public ObjectiveDao() {
		super(Objective.class);
	}

	/**
	 * Returns all objectives from the specified project.
	 *
	 * @param dsKey the identifier of the project.
	 * @return a list of all the objectives of the specified project.
	 */
	public List<Objective> getByDsKeyProject(String dsKey) {
		StringBuilder sbHql = new StringBuilder();
		sbHql.append("from Objective o");
		sbHql.append(" join fetch o.project p");
		sbHql.append(" where p.dsKey = :dsKey");
		
		Query query = getSession().createQuery(sbHql.toString());
		query.setParameter("dsKey", dsKey);
		List<Objective> objectives = query.list();
		return objectives;
	}
}
