package br.ufs.dcomp.farms.model.dao;

import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.entity.ProjectMember;

@Component
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
}
