package br.ufs.dcomp.farms.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.ufs.dcomp.farms.common.message.ErrorMessage;
import br.ufs.dcomp.farms.core.FarmsCrypt;
import br.ufs.dcomp.farms.core.FarmsException;
import br.ufs.dcomp.farms.core.FarmsMail;
import br.ufs.dcomp.farms.model.dto.ResearcherLoggedDto;
import br.ufs.dcomp.farms.model.dto.ResearcherLoginDto;
import br.ufs.dcomp.farms.model.dto.ResearcherRegisterDto;
import br.ufs.dcomp.farms.model.dto.ResearcherRegisteredDto;
import br.ufs.dcomp.farms.model.entity.Researcher;
import br.ufs.dcomp.farms.model.enums.YesNoEnum;

@Component
public class AccountService {

	@Autowired
	private ResearcherService researcherService;

	@Transactional(rollbackFor = FarmsException.class)
	public Researcher register(ResearcherRegisterDto researcherRegisterDto) throws FarmsException {
		Researcher researcher = null;
		if (researcherService.save(researcherRegisterDto)) {
			researcher = researcherService.getByEmail(researcherRegisterDto.getDsEmail());
		}
		return researcher;
	}

	public ResearcherRegisteredDto registerAndSendAccountConfirmationEmail(ResearcherRegisterDto researcherRegisterDto) throws FarmsException {
		ResearcherRegisteredDto researcherRegisteredDto = null;
		Researcher researcher = register(researcherRegisterDto);
		if (researcher != null) {
			FarmsMail.sendAccountConfirmationEmail(
					researcher.getNmResearcher(),
					researcher.getDsEmail(), 
					researcher.getCdUuid().toString());
			researcherRegisteredDto = new ResearcherRegisteredDto(researcher);
		}
		return researcherRegisteredDto;
	}
	
	public ResearcherLoggedDto login(ResearcherLoginDto researcherLoginDto) throws FarmsException {
		ResearcherLoggedDto researcherLoggedDto = null;
		Researcher researcherLogged = researcherService.getByEmail(researcherLoginDto.getDsEmail());
		if (researcherLogged != null 
				&& FarmsCrypt.checkPassword(researcherLoginDto.getDsPassword(), researcherLogged.getDsPassword())) {
			researcherLoggedDto = new ResearcherLoggedDto(researcherLogged);
		} else {
			throw new FarmsException(ErrorMessage.LOGIN_INVALID);			
		}
		return researcherLoggedDto;
	}
	
	public void updatePassword(ResearcherRegisterDto researcherRegisterDto) throws FarmsException {
//		Researcher researcherFound = researcherService.getByEmail(researcherRegisterDto.getDsEmail());
//		if (researcherFound == null) {
//			researcherRegisterDto.setDsPassword(FarmsCrypt.hashPassword(researcherRegisterDto.getDsPassword()));
//			researcherService.update(researcherRegisterDto); 
//		} else {
//			throw new FarmsException(ErrorMessage.RESEARCHER_NOT_FOUND);
//		}
//		
//		Researcher researcherResult = researcherService.getByEmail(researcherRegisterDto.getDsEmail());
//		if (researcherResult == null || !FarmsCrypt.checkPassword(researcherRegisterDto.getDsPassword(), researcherResult.getDsPassword())) {
//			throw new FarmsException(ErrorMessage.LOGIN_INVALID);
//		}
	}
	
	public ResearcherRegisteredDto confirmAccount(String cdUuid) throws FarmsException {
		ResearcherRegisteredDto researcherRegisteredDto = null;
		Researcher researcherFound = researcherService.getByUuid(cdUuid);
		if (researcherFound == null) {
			throw new FarmsException(ErrorMessage.RESEARCHER_NOT_FOUND);
		} else {
			if (YesNoEnum.Y.equals(researcherFound.getTpConfirmed())) {
				throw new FarmsException(ErrorMessage.ACCOUNT_ALREADY_CONFIRMED);
			} else {
				researcherService.confirmAccount(researcherFound);
				researcherRegisteredDto = new ResearcherRegisteredDto(researcherFound);
			}
		}
		return researcherRegisteredDto;
	}
}