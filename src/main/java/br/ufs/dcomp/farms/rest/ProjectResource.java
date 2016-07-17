package br.ufs.dcomp.farms.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.common.message.ErrorMessage;
import br.ufs.dcomp.farms.core.FarmsResponse;
import br.ufs.dcomp.farms.model.dto.ProjectCreatedDto;
import br.ufs.dcomp.farms.model.dto.StudyCreatedDto;
import br.ufs.dcomp.farms.model.service.ProjectService;
import br.ufs.dcomp.farms.model.service.StudyService;

@Path("/projects")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
public class ProjectResource {
	
	final static Logger logger = Logger.getLogger(ProjectResource.class);
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private StudyService studyService;

	// projects/{dsSlug}
	@GET
	@Path("/{dsSlug}")
	public Response getProjectByDsSlug(@PathParam("dsSlug") String dsSlug) {
		try {
			ProjectCreatedDto projectCreatedDto = projectService.getByDsSlug(dsSlug);
			return FarmsResponse.ok(projectCreatedDto);
		} catch (Exception ex) {
			logger.error(ErrorMessage.OPERATION_NOT_RESPONDING, ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}
	
	// projects/{dsSlug}/studies
	@GET
	@Path("/{dsSlug}/studies")
	public Response getStudiesByDsSlugProject(@PathParam("dsSlug") String dsSlug) {
		try {
			List<StudyCreatedDto> studyCreatedDtos = studyService.getByDsSlugProject(dsSlug);
			return FarmsResponse.ok(studyCreatedDtos);
		} catch (Exception ex) {
			logger.error(ErrorMessage.OPERATION_NOT_RESPONDING, ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}
}