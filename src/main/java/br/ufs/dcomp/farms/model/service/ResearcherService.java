package br.ufs.dcomp.farms.model.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.ufs.dcomp.farms.common.message.ErrorMessage;
import br.ufs.dcomp.farms.core.FarmsCrypt;
import br.ufs.dcomp.farms.core.FarmsException;
import br.ufs.dcomp.farms.model.dao.ResearcherDao;
import br.ufs.dcomp.farms.model.dto.ResearcherRegisterDto;
import br.ufs.dcomp.farms.model.entity.Researcher;
import br.ufs.dcomp.farms.model.enums.StateEnum;
import br.ufs.dcomp.farms.model.enums.YesNoEnum;

@Component
public class ResearcherService {

	@Autowired
	private ResearcherDao researcherDAO;

	@Transactional(rollbackFor = FarmsException.class)
	public boolean save(ResearcherRegisterDto researcherRegisterDto) throws FarmsException {
		
		Researcher researcherFoundByDsSSO = this.getBySSO(researcherRegisterDto.getDsSSO());
		if (researcherFoundByDsSSO != null) {
			throw new FarmsException(ErrorMessage.USERNAME_ALREADY_IN_USE);
		}
		
		Researcher researcherFoundByEmail = this.getByEmail(researcherRegisterDto.getDsEmail());
		if (researcherFoundByEmail != null) {
			throw new FarmsException(ErrorMessage.EMAIL_ALREADY_IN_USE);
		}
		
		Researcher researcher = new Researcher();
		UUID uuid = UUID.randomUUID();
		researcher.setCdUuid(uuid.toString());
		researcher.setNmResearcher(researcherRegisterDto.getNmResearcher());
		researcher.setDsSSO(researcherRegisterDto.getDsSSO());
		researcher.setDsEmail(researcherRegisterDto.getDsEmail());
		researcher.setDsPassword(FarmsCrypt.hashPassword(researcherRegisterDto.getDsPassword()));
		researcher.setTpState(StateEnum.A);
		researcher.setTpConfirmed(YesNoEnum.N);
		researcherDAO.save(researcher);
		return true;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public boolean update(ResearcherRegisterDto researcherRegisterDto) {
		Researcher researcher = new Researcher();
		researcher.setNmResearcher(researcherRegisterDto.getNmResearcher());
		researcher.setDsSSO(researcherRegisterDto.getDsSSO());
		researcher.setDsEmail(researcherRegisterDto.getDsEmail());
		researcher.setDsPassword(researcherRegisterDto.getDsPassword());
		researcherDAO.update(researcher);
		return true;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public boolean confirmAccount(Researcher researcher) {
		researcher.setTpConfirmed(YesNoEnum.Y);
		researcherDAO.update(researcher);
		return true;
	}
	
	// TODO Obter todos por projeto. Mover para ProjectService.
	public List<Researcher> getAll() {
		List<Researcher> researchers = researcherDAO.getAll();
		return researchers;
	}

	public List<Researcher> getByName(String nmResearcher) {
		return researcherDAO.getByNmResearcher(nmResearcher);
	}
	
	public Researcher getBySSO(String dsSSO) {
		Researcher researcher = researcherDAO.getByDsSSO(dsSSO);
		return researcher;
	}
	
	public Researcher getByEmail(String dsEmail) {
		Researcher researcher = researcherDAO.getByDsEmail(dsEmail);
		return researcher;
	}

	public Researcher getByUuid(String cdUuid) {
		Researcher researcher = null;
		if (cdUuid != null) {
			researcher = researcherDAO.getByUuid(cdUuid);
		}
		return researcher;
	}
}