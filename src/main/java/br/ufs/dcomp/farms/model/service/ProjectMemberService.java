package br.ufs.dcomp.farms.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.dao.ProjectMemberDao;
import br.ufs.dcomp.farms.model.dto.ProjectMemberDto;
import br.ufs.dcomp.farms.model.entity.ProjectMember;

@Component
public class ProjectMemberService {

	@Autowired
	private ProjectMemberDao projectMemberDao;

	public List<ProjectMemberDto> getByDsKeyProject(String dsKey) {
		List<ProjectMemberDto> projectMemberDto = new ArrayList<ProjectMemberDto>();
		List<ProjectMember> projectMembers = projectMemberDao.getByDsKeyProject(dsKey);
		if (projectMembers != null) {
			for(ProjectMember projectMember : projectMembers) {
				projectMemberDto.add(new ProjectMemberDto(projectMember));
			}
		}
		return projectMemberDto;
	}
}