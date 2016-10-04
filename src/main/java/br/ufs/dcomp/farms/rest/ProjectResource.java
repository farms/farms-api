package br.ufs.dcomp.farms.rest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.common.message.ErrorMessage;
import br.ufs.dcomp.farms.core.FarmsResponse;
import br.ufs.dcomp.farms.model.dto.InstitutionCreatedDto;
import br.ufs.dcomp.farms.model.dto.MainQuestionCreatedDto;
import br.ufs.dcomp.farms.model.dto.ObjectiveCreatedDto;
import br.ufs.dcomp.farms.model.dto.ProjectCreatedDto;
import br.ufs.dcomp.farms.model.dto.ProjectMemberDto;
import br.ufs.dcomp.farms.model.dto.SearchKeywordCreatedDto;
import br.ufs.dcomp.farms.model.dto.SecondaryQuestionCreatedDto;
import br.ufs.dcomp.farms.model.dto.SelectionCriteriaCreatedDto;
import br.ufs.dcomp.farms.model.dto.StandardQueryCreatedDto;
import br.ufs.dcomp.farms.model.dto.StudyCreatedDto;
import br.ufs.dcomp.farms.model.service.InstitutionService;
import br.ufs.dcomp.farms.model.service.LanguageService;
import br.ufs.dcomp.farms.model.service.MainQuestionService;
import br.ufs.dcomp.farms.model.service.ObjectiveService;
import br.ufs.dcomp.farms.model.service.ProjectMemberService;
import br.ufs.dcomp.farms.model.service.ProjectService;
import br.ufs.dcomp.farms.model.service.SearchKeywordService;
import br.ufs.dcomp.farms.model.service.SecondaryQuestionService;
import br.ufs.dcomp.farms.model.service.SelectionCriteriaService;
import br.ufs.dcomp.farms.model.service.StandardQueryService;
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
	@Autowired
	private ProjectMemberService projectMemberService;
	@Autowired
	private InstitutionService institutuionService;
	@Autowired
	private ObjectiveService objectiveService;
	@Autowired
	private MainQuestionService mainQuestionService;
	@Autowired
	private SecondaryQuestionService secondaryQuestionService;
	@Autowired
	private SearchKeywordService searchKeywordService;
	@Autowired
	private LanguageService languageService;
	@Autowired
	private StandardQueryService standardQueryService;
	@Autowired
	private SelectionCriteriaService selectionCriteriaService;
	
	// projects/{dsKey}
	@GET
	@Path("/{dsKey}")
	public Response getProjectByDsKey(@PathParam("dsKey") String dsKey) {
		try {
			ProjectCreatedDto projectCreatedDto = projectService.getByDsKey(dsKey);
			return FarmsResponse.ok(projectCreatedDto);
		} catch (Exception ex) {
			logger.error(ErrorMessage.OPERATION_NOT_RESPONDING, ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}

	// projects/{dsKey}/institutions
	@GET
	@Path("/{dsKey}/institutions")
	public Response getInstitutionsByDsKeyProject(@PathParam("dsKey") String dsKey) {
		try {
			List<InstitutionCreatedDto> institutionCreatedDtos = institutuionService.getByDsKeyProject(dsKey);
			return FarmsResponse.ok(institutionCreatedDtos);
		} catch (Exception ex) {
			logger.error(ErrorMessage.OPERATION_NOT_RESPONDING, ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}
	
	// projects/{dsKey}/members
	@GET
	@Path("/{dsKey}/members")
	public Response getMembersByDsKeyProject(@PathParam("dsKey") String dsKey) {
		try {
			List<ProjectMemberDto> projectMemberDtos = projectMemberService.getByDsKeyProject(dsKey);
			return FarmsResponse.ok(projectMemberDtos);
		} catch (Exception ex) {
			logger.error(ErrorMessage.OPERATION_NOT_RESPONDING, ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}

	// projects/{dsKey}/studies
	@GET
	@Path("/{dsKey}/studies")
	public Response getStudiesByDsKeyProject(@PathParam("dsKey") String dsKey) {
		try {
			List<StudyCreatedDto> studyCreatedDtos = studyService.getByDsKeyProject(dsKey);
			return FarmsResponse.ok(studyCreatedDtos);
		} catch (Exception ex) {
			logger.error(ErrorMessage.OPERATION_NOT_RESPONDING, ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}
	
	// projects/{dsKey}/objectives
	@GET
	@Path("/{dsKey}/objectives")
	public Response getObjectivesByDsKeyProject(@PathParam("dsKey") String dsKey) {
		try {
			List<ObjectiveCreatedDto> objectiveCreatedDtos = objectiveService.getByDsKeyProject(dsKey);
			return FarmsResponse.ok(objectiveCreatedDtos);
		} catch (Exception ex) {
			logger.error(ErrorMessage.OPERATION_NOT_RESPONDING, ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}
	
	// projects/{dsKey}/main-question
	@GET
	@Path("/{dsKey}/main-question")
	public Response getMainQuestionByDsKeyProject(@PathParam("dsKey") String dsKey) {
		try {
			List<MainQuestionCreatedDto> mainQuestionCreatedDtos = mainQuestionService.getByDsKeyProject(dsKey);
			return FarmsResponse.ok(mainQuestionCreatedDtos);
		} catch (Exception ex) {
			logger.error(ErrorMessage.OPERATION_NOT_RESPONDING, ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}
	
	// projects/{dsKey}/secondary-question
	@GET
	@Path("/{dsKey}/secondary-question")
	public Response getSecondaryQuestionByDsKeyProject(@PathParam("dsKey") String dsKey) {
		try {
			List<SecondaryQuestionCreatedDto> secondaryQuestionCreatedDtos = secondaryQuestionService.getByDsKeyProject(dsKey);
			return FarmsResponse.ok(secondaryQuestionCreatedDtos);
		} catch (Exception ex) {
			logger.error(ErrorMessage.OPERATION_NOT_RESPONDING, ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}
	
	// projects/{dsKey}/search-keywords
	@GET
	@Path("/{dsKey}/search-keywords")
	public Response getSearchKeywordsByDsKeyProject(@PathParam("dsKey") String dsKey) {
		try {
			List<SearchKeywordCreatedDto> searchKeywordCreatedDtos = searchKeywordService.getByDsKeyProject(dsKey);
			return FarmsResponse.ok(searchKeywordCreatedDtos);
		} catch (Exception ex) {
			logger.error(ErrorMessage.OPERATION_NOT_RESPONDING, ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}

//	// projects/{dsKey}/languages
//	@GET
//	@Path("/{dsKey}/languages")
//	public Response getLanguagesByDsKeyProject(@PathParam("dsKey") String dsKey) {
//		try {
//			List<LanguageCreatedDto> languageCreatedDtos = languageService.getByDsKeyProject(dsKey);
//			return FarmsResponse.ok(languageCreatedDtos);
//		} catch (Exception ex) {
//			logger.error(ErrorMessage.OPERATION_NOT_RESPONDING, ex);
//			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
//		}
//	}
	
	// projects/{dsKey}/standard-query
	@GET
	@Path("/{dsKey}/standard-query")
	public Response getStandardQueryByDsKeyProject(@PathParam("dsKey") String dsKey) {
		try {
			List<StandardQueryCreatedDto> standardQueryCreatedDtos = standardQueryService.getByDsKeyProject(dsKey);
			return FarmsResponse.ok(standardQueryCreatedDtos);
		} catch (Exception ex) {
			logger.error(ErrorMessage.OPERATION_NOT_RESPONDING, ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}
	
//	// projects/{dsKey}/search-engine
//	@GET
//	@Path("/{dsKey}/search-engine")
//	public Response getKeywordsByDsKeyProject(@PathParam("dsKey") String dsKey) {
//		try {
//			List<StudyCreatedDto> studyCreatedDtos = studyService.getByDsKeyProject(dsKey);
//			return FarmsResponse.ok(studyCreatedDtos);
//		} catch (Exception ex) {
//			logger.error(ErrorMessage.OPERATION_NOT_RESPONDING, ex);
//			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
//		}
//	}
	
	// projects/{dsKey}/selection-criterias
	@GET
	@Path("/{dsKey}/selection-criterias")
	public Response getSelectionCriteriasByDsKeyProject(@PathParam("dsKey") String dsKey) {
		try {
			List<SelectionCriteriaCreatedDto> selectionCriteriaCreatedDtos = selectionCriteriaService.getByDsKeyProject(dsKey);
			return FarmsResponse.ok(selectionCriteriaCreatedDtos);
		} catch (Exception ex) {
			logger.error(ErrorMessage.OPERATION_NOT_RESPONDING, ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}
	
	@POST
	@Path("/{dsKey}/upload-study")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile( 
				@FormDataParam("file") InputStream file,
				@FormDataParam("file") FormDataContentDisposition fileDisposition) {

		String fileName = fileDisposition.getFileName();
		
		saveFile(file, fileName);
		
		String fileDetails = "File saved at /Volumes/Drive2/temp/file/" + fileName;

		System.out.println(fileDetails);

		return Response.ok(fileDetails).build();
	}
	
	private void saveFile(InputStream file, String name) {
		try {
			/* Change directory path */
			java.nio.file.Path path = FileSystems.getDefault().getPath("/Volumes/Drive2/temp/file/" + name); 
			/* Save InputStream as file */
			Files.copy(file, path);
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}