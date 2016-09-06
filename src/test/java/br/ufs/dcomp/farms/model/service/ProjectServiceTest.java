package br.ufs.dcomp.farms.model.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.ufs.dcomp.farms.core.FarmsException;
import br.ufs.dcomp.farms.model.dto.ProjectCreateDto;
import br.ufs.dcomp.farms.model.dto.ProjectCreatedDto;
import br.ufs.dcomp.farms.model.dto.ResearcherRegisterDto;
import br.ufs.dcomp.farms.model.dto.ResearcherRegisteredDto;
import br.ufs.dcomp.farms.model.entity.ProjectMember;
import br.ufs.dcomp.farms.model.entity.Researcher;
import br.ufs.dcomp.farms.model.enums.ReviewEnum;
import br.ufs.dcomp.farms.model.enums.RoleEnum;
import br.ufs.dcomp.farms.model.enums.StateEnum;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-application-context.xml")
@SuppressWarnings("unused")
public class ProjectServiceTest {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ResearcherService researcherService;

	@Test
	@Transactional
    @Rollback(true)
	public void testShouldCreateProject() throws FarmsException {
		
		ResearcherRegisterDto researcherRegisterDto = this.getValidResearcher_Maria();
		ResearcherRegisteredDto researcherRegisteredDto = accountService.registerAndSendAccountConfirmationEmail(researcherRegisterDto);
		Researcher researcher = researcherService.getByEmail(researcherRegisteredDto.getDsEmail());
		
		String dsKey = "ospseems";
		String dsTitle = "Open source projects in software engineering education: a mapping study";
		StringBuilder dsProject = new StringBuilder();
		dsProject.append("One possibility to bring practice to Software Engineering Course is to make students participate in Open Source Projects with supervision of teachers. Many researches have been approaching this idea.");
		dsProject.append("The aim of this systematic mapping study is to summarize all existing information about the use of Open Source Projects in Software Engineering or Computer Science Courses, and how student learning has been evaluated in order to identify possible gaps that justifies further research activities.");
		Integer tpReview = 1;
		Long idInstitution = 1L;
		
		ProjectCreateDto projectCreateDto = new ProjectCreateDto();
		projectCreateDto.setDsKey(dsKey);
		projectCreateDto.setDsTitle(dsTitle);
		projectCreateDto.setDsProject(dsProject.toString());
		projectCreateDto.setTpReview(tpReview);
		projectCreateDto.setDsSsoResearcher(researcher.getDsSSO());
		projectCreateDto.setIdInstitution(idInstitution);
		
		ProjectCreatedDto projectCreatedDto = projectService.save(projectCreateDto);
		ProjectMember projectMember = projectCreatedDto.getProjectMember();
		
		Assert.assertNotNull(projectCreatedDto);
		Assert.assertEquals(dsKey, projectCreatedDto.getDsKey());
		Assert.assertEquals(dsTitle, projectCreatedDto.getDsTitle());
		Assert.assertEquals(dsProject.toString(), projectCreatedDto.getDsProject());
		Assert.assertEquals(tpReview, projectCreatedDto.getTpReview());
		
		Assert.assertNotNull(projectMember);
		Assert.assertNotNull(projectMember.getResearcher());
		Assert.assertEquals(researcher.getDsSSO(), projectMember.getResearcher().getDsSSO());
		Assert.assertEquals(dsKey, projectMember.getProject().getDsKey());
		Assert.assertEquals(idInstitution, projectMember.getInstitution().getIdInstitution());
		Assert.assertEquals(RoleEnum.COORDINATOR, RoleEnum.fromCode(projectMember.getTpRole().getCode()));
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testShouldGetByDsSsoResearcher() throws FarmsException {
		ResearcherRegisterDto researcherRegisterDto1 = getValidResearcher_Maria();
		ResearcherRegisterDto researcherRegisterDto2 = getValidResearcher_Jose();
		
		researcherService.save(researcherRegisterDto1);
		researcherService.save(researcherRegisterDto2);
		
		ProjectCreateDto projectCreateDto1 = getValidProject_SR_Maria();
		ProjectCreateDto projectCreateDto2 = getValidProject_SM_Jose();
		ProjectCreateDto projectCreateDto3 = getValidProject_NS_Maria();
		
		projectService.save(projectCreateDto1);
		projectService.save(projectCreateDto2);
		projectService.save(projectCreateDto3);
		
		List<ProjectCreatedDto> projectCreatedDtos = projectService.GetByDsSsoResearcher(researcherRegisterDto1.getDsSSO());
		
		Assert.assertNotNull(projectCreatedDtos);
		Assert.assertFalse(projectCreatedDtos.isEmpty());
		Assert.assertEquals(2, projectCreatedDtos.size());
	}
	
	@Test
    @Transactional
    @Rollback(true)
	public void testShouldGetStudiesByDsKey() throws FarmsException {
		
	}
	
	private ResearcherRegisterDto getValidResearcher_Maria() {
		ResearcherRegisterDto researcherRegisterDto = new ResearcherRegisterDto("Maria José Santos", "mariajsantos",
				"mariajsantos@gmail.com", "12345678", "12345678", StateEnum.A);
		return researcherRegisterDto;
	}
	
	private ResearcherRegisterDto getValidResearcher_Jose() {
		ResearcherRegisterDto researcherRegisterDto = new ResearcherRegisterDto("José Silva", "josesilva",
				"josesilva@gmail.com", "87654321", "12345678", StateEnum.A);
		return researcherRegisterDto;
	}
	
	private ResearcherRegisterDto getValidResearcher_Joao() {
		ResearcherRegisterDto researcherRegisterDto = new ResearcherRegisterDto("João Carlos", "joaocarlos",
				"joaocarlos@gmail.com", "56781234", "12345678", StateEnum.A);
		return researcherRegisterDto;
	}
	
	private ProjectCreateDto getValidProject_SR_Maria() {
		ResearcherRegisterDto researcherRegisterDto = this.getValidResearcher_Maria();
		String dsKey = "ospseesr";
		String dsTitle = "Open source projects in software engineering education: a mapping study";
		StringBuilder dsProject = new StringBuilder();
		dsProject.append("One possibility to bring practice to Software Engineering Course is to make students participate in Open Source Projects with supervision of teachers. Many researches have been approaching this idea.");
		dsProject.append("The aim of this systematic mapping study is to summarize all existing information about the use of Open Source Projects in Software Engineering or Computer Science Courses, and how student learning has been evaluated in order to identify possible gaps that justifies further research activities.");
		ReviewEnum tpReview = ReviewEnum.SYSTEMATIC_REVIEW;
		Long idInstitution = 1L;
		
		ProjectCreateDto projectCreateDto = new ProjectCreateDto();
		projectCreateDto.setDsKey(dsKey);
		projectCreateDto.setDsTitle(dsTitle);
		projectCreateDto.setDsProject(dsProject.toString());
		projectCreateDto.setTpReview(tpReview.getCode());
		projectCreateDto.setDsSsoResearcher(researcherRegisterDto.getDsSSO());
		projectCreateDto.setIdInstitution(idInstitution);
		return projectCreateDto;
	}
	
	private ProjectCreateDto getValidProject_NS_Maria() {
		ResearcherRegisterDto researcherRegisterDto = this.getValidResearcher_Maria();
		String dsKey = "ospseens";
		String dsTitle = "Open source projects in software engineering education: a mapping study";
		StringBuilder dsProject = new StringBuilder();
		dsProject.append("One possibility to bring practice to Software Engineering Course is to make students participate in Open Source Projects with supervision of teachers. Many researches have been approaching this idea.");
		dsProject.append("The aim of this systematic mapping study is to summarize all existing information about the use of Open Source Projects in Software Engineering or Computer Science Courses, and how student learning has been evaluated in order to identify possible gaps that justifies further research activities.");
		ReviewEnum tpReview = ReviewEnum.NOT_SYSTEMATIC;
		Long idInstitution = 1L;
		
		ProjectCreateDto projectCreateDto = new ProjectCreateDto();
		projectCreateDto.setDsKey(dsKey);
		projectCreateDto.setDsTitle(dsTitle);
		projectCreateDto.setDsProject(dsProject.toString());
		projectCreateDto.setTpReview(tpReview.getCode());
		projectCreateDto.setDsSsoResearcher(researcherRegisterDto.getDsSSO());
		projectCreateDto.setIdInstitution(idInstitution);
		return projectCreateDto;
	}
	
	private ProjectCreateDto getValidProject_SM_Jose() {
		ResearcherRegisterDto researcherRegisterDto = this.getValidResearcher_Jose();
		String dsKey = "ospseesmjs";
		String dsTitle = "Open source projects in software engineering education: a mapping study";
		StringBuilder dsProject = new StringBuilder();
		dsProject.append("One possibility to bring practice to Software Engineering Course is to make students participate in Open Source Projects with supervision of teachers. Many researches have been approaching this idea.");
		dsProject.append("The aim of this systematic mapping study is to summarize all existing information about the use of Open Source Projects in Software Engineering or Computer Science Courses, and how student learning has been evaluated in order to identify possible gaps that justifies further research activities.");
		ReviewEnum tpReview = ReviewEnum.SYSTEMATIC_MAPPING;
		Long idInstitution = 1L;
		
		ProjectCreateDto projectCreateDto = new ProjectCreateDto();
		projectCreateDto.setDsKey(dsKey);
		projectCreateDto.setDsTitle(dsTitle);
		projectCreateDto.setDsProject(dsProject.toString());
		projectCreateDto.setTpReview(tpReview.getCode());
		projectCreateDto.setDsSsoResearcher(researcherRegisterDto.getDsSSO());
		projectCreateDto.setIdInstitution(idInstitution);
		return projectCreateDto;
	}
	
	private ProjectCreateDto getValidProject_SR_Joao() {
		ResearcherRegisterDto researcherRegisterDto = this.getValidResearcher_Joao();
		String dsKey = "ospseesrjo";
		String dsTitle = "Open source projects in software engineering education: a mapping study";
		StringBuilder dsProject = new StringBuilder();
		dsProject.append("One possibility to bring practice to Software Engineering Course is to make students participate in Open Source Projects with supervision of teachers. Many researches have been approaching this idea.");
		dsProject.append("The aim of this systematic mapping study is to summarize all existing information about the use of Open Source Projects in Software Engineering or Computer Science Courses, and how student learning has been evaluated in order to identify possible gaps that justifies further research activities.");
		ReviewEnum tpReview = ReviewEnum.SYSTEMATIC_REVIEW;
		Long idInstitution = 1L;
		
		ProjectCreateDto projectCreateDto = new ProjectCreateDto();
		projectCreateDto.setDsKey(dsKey);
		projectCreateDto.setDsTitle(dsTitle);
		projectCreateDto.setDsProject(dsProject.toString());
		projectCreateDto.setTpReview(tpReview.getCode());
		projectCreateDto.setDsSsoResearcher(researcherRegisterDto.getDsSSO());
		projectCreateDto.setIdInstitution(idInstitution);
		return projectCreateDto;
	}
}
