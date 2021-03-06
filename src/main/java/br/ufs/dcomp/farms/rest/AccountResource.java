package br.ufs.dcomp.farms.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.common.message.ErrorMessage;
import br.ufs.dcomp.farms.common.message.SuccessMessage;
import br.ufs.dcomp.farms.core.FarmsException;
import br.ufs.dcomp.farms.core.FarmsMail;
import br.ufs.dcomp.farms.core.FarmsResponse;
import br.ufs.dcomp.farms.model.dto.ResearcherLoggedDto;
import br.ufs.dcomp.farms.model.dto.ResearcherLoginDto;
import br.ufs.dcomp.farms.model.dto.ResearcherRegisterDto;
import br.ufs.dcomp.farms.model.dto.ResearcherRegisteredDto;
import br.ufs.dcomp.farms.model.service.AccountService;

@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
public class AccountResource {
	
	final static Logger logger = Logger.getLogger(AccountResource.class);
	
	@Autowired
	private AccountService accountService;
	
	@POST
	@Path("/login")
	public Response login(ResearcherLoginDto researcherLoginDto) {
		try {
			logger.info("Starting login.");
			ResearcherLoggedDto researcherLoggedDto = accountService.login(researcherLoginDto);
			logger.info(SuccessMessage.RESEARCHER_LOGGED);
			return FarmsResponse.ok(SuccessMessage.RESEARCHER_LOGGED, researcherLoggedDto);
		} catch (FarmsException fe) {
			logger.error(fe.getErrorMessage());
			return FarmsResponse.error(fe.getErrorMessage());
		} catch (Exception ex) {
			logger.error(ErrorMessage.OPERATION_NOT_RESPONDING, ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}
	
	@POST
	@Path("/register")
	public Response register(ResearcherRegisterDto researcherRegisterDto) {
		try {
			logger.info("Starting register.");
			ResearcherRegisteredDto researcherRegisteredDto = accountService.registerAndSendAccountConfirmationEmail(researcherRegisterDto);
			logger.info(SuccessMessage.RESEARCHER_REGISTERED);
			return FarmsResponse.ok(SuccessMessage.RESEARCHER_REGISTERED, researcherRegisteredDto);
		} catch (FarmsException fe) {
			return FarmsResponse.error(fe.getErrorMessage());
		} catch (Exception ex) {
			logger.error(ErrorMessage.OPERATION_NOT_RESPONDING, ex);
			FarmsMail.sendMailText("elissandro.messias@gmail.com", "Erro", ex.getMessage());
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}
	
	@GET
	@Path("/confirmation")
	public Response verifyAccount(@QueryParam("u") String cdUuid) {
		try {
			logger.info("Starting account confirmation.");
			ResearcherRegisteredDto researcherRegisteredDto = accountService.confirmAccount(cdUuid);
			logger.info(SuccessMessage.ACCOUNT_CONFIRMED);
			return FarmsResponse.ok(SuccessMessage.ACCOUNT_CONFIRMED, researcherRegisteredDto);
		} catch (FarmsException fe) {
			return FarmsResponse.error(fe.getErrorMessage());
		} catch (Exception ex) {
			logger.error(ErrorMessage.OPERATION_NOT_RESPONDING, ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}
}