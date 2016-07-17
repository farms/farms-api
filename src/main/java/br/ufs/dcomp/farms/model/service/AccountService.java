package br.ufs.dcomp.farms.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.ufs.dcomp.farms.common.message.ErrorMessage;
import br.ufs.dcomp.farms.core.FarmsCrypt;
import br.ufs.dcomp.farms.core.FarmsException;
import br.ufs.dcomp.farms.model.dto.ResearcherLoggedDto;
import br.ufs.dcomp.farms.model.dto.ResearcherLoginDto;
import br.ufs.dcomp.farms.model.dto.ResearcherRegisterDto;
import br.ufs.dcomp.farms.model.dto.ResearcherRegisteredDto;
import br.ufs.dcomp.farms.model.entity.Researcher;

@Component
public class AccountService {

	@Autowired
	private ResearcherService researcherService;

	@Transactional(rollbackFor = FarmsException.class)
	public ResearcherRegisteredDto register(ResearcherRegisterDto researcherRegisterDto) throws FarmsException {
		ResearcherRegisteredDto researcherRegisteredDto = null;
		if (researcherService.save(researcherRegisterDto)) {
			Researcher researcherFoundByEmail = researcherService.getByEmail(researcherRegisterDto.getDsEmail());
			researcherRegisteredDto = new ResearcherRegisteredDto(researcherFoundByEmail);
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
		Researcher researcherFound = researcherService.getByEmail(researcherRegisterDto.getDsEmail());
		if (researcherFound == null) {
			researcherRegisterDto.setDsPassword(FarmsCrypt.hashPassword(researcherRegisterDto.getDsPassword()));
			researcherService.update(researcherRegisterDto); 
		} else {
			throw new FarmsException(ErrorMessage.RESEARCHER_NOT_FOUND);
		}
		
		Researcher researcherResult = researcherService.getByEmail(researcherRegisterDto.getDsEmail());
		if (researcherResult == null || !FarmsCrypt.checkPassword(researcherRegisterDto.getDsPassword(), researcherResult.getDsPassword())) {
			throw new FarmsException(ErrorMessage.LOGIN_INVALID);
		}
	}
}
