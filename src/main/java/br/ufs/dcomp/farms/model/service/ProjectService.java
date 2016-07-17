package br.ufs.dcomp.farms.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.ufs.dcomp.farms.common.message.ErrorMessage;
import br.ufs.dcomp.farms.core.FarmsException;
import br.ufs.dcomp.farms.model.dao.InstitutionDao;
import br.ufs.dcomp.farms.model.dao.ProjectDao;
import br.ufs.dcomp.farms.model.dao.ProjectMemberDao;
import br.ufs.dcomp.farms.model.dao.ResearcherDao;
import br.ufs.dcomp.farms.model.dto.ProjectCreateDto;
import br.ufs.dcomp.farms.model.dto.ProjectCreatedDto;
import br.ufs.dcomp.farms.model.entity.Institution;
import br.ufs.dcomp.farms.model.entity.Project;
import br.ufs.dcomp.farms.model.entity.ProjectMember;
import br.ufs.dcomp.farms.model.entity.Researcher;
import br.ufs.dcomp.farms.model.enums.ReviewEnum;
import br.ufs.dcomp.farms.model.enums.RoleEnum;

@Component
public class ProjectService {

	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private ResearcherDao researcherDao;
	
	@Autowired
	private InstitutionDao institutionDao;
	
	@Autowired
	private ProjectMemberDao projectMemberDao;

	@Transactional(rollbackFor = FarmsException.class)
	public ProjectCreatedDto save(ProjectCreateDto projectCreateDto) throws FarmsException {
		
		ProjectCreatedDto projectFoundByDsSlug = this.getByDsSlug(projectCreateDto.getDsSlug());
		if (projectFoundByDsSlug != null) {
			throw new FarmsException(ErrorMessage.SLUG_ALREADY_IN_USE);
		}
		
		Researcher researcher = researcherDao.getByDsSSO(projectCreateDto.getDsSsoResearcher());
		if (researcher == null) {
			throw new FarmsException(ErrorMessage.RESEARCHER_NOT_FOUND);
		}
		
		Institution institution = institutionDao.getById(projectCreateDto.getIdInstitution());
		if (institution == null) {
			throw new FarmsException(ErrorMessage.INSTITUTION_NOT_FOUND);
		}
		
		Project project = new Project();
		project.setDsSlug(projectCreateDto.getDsSlug());
		project.setDsTitle(projectCreateDto.getDsTitle());
		project.setDsProject(projectCreateDto.getDsProject());
		project.setTpReview(ReviewEnum.fromCode(projectCreateDto.getTpReview()));
		projectDao.save(project);
		
		ProjectMember projectMember = new ProjectMember();
		projectMember.setResearcher(researcher);
		projectMember.setProject(project);
		projectMember.setInstitution(institution);
		projectMember.setTpRole(RoleEnum.COORDINATOR);
		projectMemberDao.save(projectMember);
		
		ProjectCreatedDto projectCreatedDto = new ProjectCreatedDto(project, projectMember);
		
		return projectCreatedDto;
	}

	public ProjectCreatedDto getByDsSlug(String dsSlug) {
		Project project = projectDao.getByDsSlug(dsSlug);
		ProjectCreatedDto projectCreatedDto = new ProjectCreatedDto(project);
		return projectCreatedDto;
	}

	public List<ProjectCreatedDto> GetByDsSsoResearcher(String dsSSO) {
		List<ProjectCreatedDto> projectCreatedDtos = new ArrayList<ProjectCreatedDto>();
		List<Project> projects = projectDao.getByDsSsoResearcher(dsSSO);
		if (projects != null) {
			for(Project project : projects) {
				projectCreatedDtos.add(new ProjectCreatedDto(project));
			}
		}
		return projectCreatedDtos;
	}
}