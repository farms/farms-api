package br.ufs.dcomp.farms.model.dto;

import br.ufs.dcomp.farms.model.entity.Project;
import br.ufs.dcomp.farms.model.entity.ProjectMember;

public class ProjectCreatedDto {

	private String dsSlug;
	private String dsTitle;
	private String dsProject;
	private Integer tpReview;
	private ProjectMember projectMember;
	
	public ProjectCreatedDto() {
		super();
	}

	public ProjectCreatedDto(Project project) {
		super();
		this.dsSlug = project.getDsSlug();
		this.dsTitle = project.getDsTitle();
		this.dsProject = project.getDsProject();
		this.tpReview = project.getTpReview().getCode();
	}
	
	public ProjectCreatedDto(Project project, ProjectMember projectMember) {
		super();
		this.dsSlug = project.getDsSlug();
		this.dsTitle = project.getDsTitle();
		this.dsProject = project.getDsProject();
		this.tpReview = project.getTpReview().getCode();
		this.projectMember = projectMember;
	}

	public String getDsSlug() {
		return dsSlug;
	}

	public void setDsSlug(String dsSlug) {
		this.dsSlug = dsSlug;
	}

	public String getDsTitle() {
		return dsTitle;
	}

	public void setDsTitle(String dsTitle) {
		this.dsTitle = dsTitle;
	}
	
	public String getDsProject() {
		return dsProject;
	}

	public void setDsProject(String dsProject) {
		this.dsProject = dsProject;
	}

	public Integer getTpReview() {
		return tpReview;
	}

	public void setTpReview(Integer tpReview) {
		this.tpReview = tpReview;
	}

	public ProjectMember getProjectMember() {
		return projectMember;
	}

	public void setProjectMember(ProjectMember projectMember) {
		this.projectMember = projectMember;
	}
}