package br.ufs.dcomp.farms.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.entity.ProjectMember;

@Component
@SuppressWarnings("unchecked")
public class ProjectMemberDao extends HibernateDao<ProjectMember> {

	/**
	 * Indicates the entity type to Hibernate.
	 */
	public ProjectMemberDao() {
		super(ProjectMember.class);
	}
	
	/**
	 * Inserts a project member.
	 * @param projectMember
	 */
	public void save(ProjectMember projectMember) {
		super.save(projectMember);
	}
	
	/**
	 * Returns all project members from the specified project.
	 *
	 * @param dsKey the identifier of the project.
	 * @return a list of all the project members of the specified project.
	 */
	public List<ProjectMember> getByDsKeyProject(String dsKey) {
		StringBuilder sbHql = new StringBuilder();
		sbHql.append("from ProjectMember pm");
		sbHql.append(" join fetch pm.project p");
		sbHql.append(" where p.dsKey = :dsKey");
		
		Query query = getSession().createQuery(sbHql.toString());
		query.setParameter("dsKey", dsKey);
		List<ProjectMember> projectMembers = query.list();
		return projectMembers;
	}
}