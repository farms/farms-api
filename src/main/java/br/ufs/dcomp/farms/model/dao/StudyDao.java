package br.ufs.dcomp.farms.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.entity.Study;

@Component
@SuppressWarnings("unchecked")
public class StudyDao extends HibernateDao<Study> {

	public StudyDao() {
		super(Study.class);
	}

	/**
	 * Returns all studies from the specified project.
	 *
	 * @param dsSlug the identifier of the project.
	 * @return a list of all the studies of the specified project.
	 */
	public List<Study> getByDsSlugProject(String dsSlug) {
		StringBuilder sbHql = new StringBuilder();
		sbHql.append("from Study s");
		sbHql.append(" join fetch s.project p");
		sbHql.append(" where p.dsSlug = :dsSlug");
		
		Query query = getSession().createQuery(sbHql.toString());
		query.setParameter("dsSlug", dsSlug);
		List<Study> studies = query.list();
		return studies;
	}
}
