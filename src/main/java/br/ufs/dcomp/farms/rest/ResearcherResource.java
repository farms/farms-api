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
import br.ufs.dcomp.farms.model.entity.Researcher;
import br.ufs.dcomp.farms.model.service.ProjectService;
import br.ufs.dcomp.farms.model.service.ResearcherService;

@Path("/researchers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
public class ResearcherResource {

	final static Logger logger = Logger.getLogger(ResearcherResource.class);

	@Autowired
	private ResearcherService researcherService;
	
	@Autowired
	private ProjectService projectService;

	@GET
	@Path("/?dsSSO={dsSSO}")
	public Response getByDsSsoResearcher(@PathParam("dsSSO") String dsSSO) {
		try {
			Researcher researcher = researcherService.getBySSO(dsSSO);
			return FarmsResponse.ok(researcher);
		} catch (Exception ex) {
			logger.error(ErrorMessage.OPERATION_NOT_RESPONDING, ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}

	@GET
	@Path("/?dsEmail={dsEmail}")
	public Response getByDsEmail(@PathParam("dsEmail") String dsEmail) {
		try {
			Researcher researcher = researcherService.getByEmail(dsEmail);
			return FarmsResponse.ok(researcher);
		} catch (Exception ex) {
			logger.error(ErrorMessage.OPERATION_NOT_RESPONDING, ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}

	@GET
	@Path("/?nmResearcher={nmResearcher}")
	public Response getByNmResearcher(@PathParam("nmResearcher") String nmResearcher) {
		try {
			List<Researcher> researchers = researcherService.getByName(nmResearcher);
			return FarmsResponse.ok(researchers);
		} catch (Exception ex) {
			logger.error(ErrorMessage.OPERATION_NOT_RESPONDING, ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}
	
	@GET
	@Path("/{dsSSO}/projects")
	public Response GetByDsSsoResearcher(@PathParam("dsSSO") String dsSSO) {
		try {
			List<ProjectCreatedDto> projectCreatedDtos = projectService.GetByDsSsoResearcher(dsSSO);
			return FarmsResponse.ok(projectCreatedDtos);
		} catch (Exception ex) {
			logger.error(ErrorMessage.OPERATION_NOT_RESPONDING, ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}
}