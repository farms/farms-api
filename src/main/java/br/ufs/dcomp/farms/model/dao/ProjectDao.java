package br.ufs.dcomp.farms.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.entity.Project;

@Component
@SuppressWarnings("unchecked")
public class ProjectDao extends HibernateDao<Project> {

	/**
	 * Indicates the entity type to Hibernate.
	 */
	public ProjectDao() {
		super(Project.class);
	}

	/**
	 * Returns all projects from the specified researcher.
	 *
	 * @param dsSSO the identifier of the researcher.
	 * @return a list of all the projects of the specified researcher.
	 */
	public List<Project> getByDsSsoResearcher(String dsSSO) {
		StringBuilder sbHql = new StringBuilder();
		sbHql.append("from Project p");
		sbHql.append(" join fetch p.projectMembers pm");
		sbHql.append(" where pm.researcher.dsSSO = :dsSSO");
		
		Query query = getSession().createQuery(sbHql.toString());
		query.setParameter("dsSSO", dsSSO);
		List<Project> projects = query.list();
		return projects;
	}
	
	/**
	 * Search a project by dsSlug.
	 * @param dsSSO
	 * @return
	 */
	public Project getByDsSlug(String dsSlug) {
		Query query = getSession().createQuery("from Project p where lower(p.dsSlug) = lower(?)");
		query.setString(0, dsSlug);
		List<Project> results = query.list();
		return (results != null && !results.isEmpty()) ? (Project) results.get(0) : null;
	}
}
