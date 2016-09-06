package br.ufs.dcomp.farms.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.dao.InstitutionDao;
import br.ufs.dcomp.farms.model.dto.InstitutionCreatedDto;
import br.ufs.dcomp.farms.model.entity.Institution;

@Component
public class InstitutionService {

	@Autowired
	private InstitutionDao institutionDao;

	public List<InstitutionCreatedDto> getByDsKeyProject(String dsKey) {
		List<InstitutionCreatedDto> institutionCreatedDto = new ArrayList<InstitutionCreatedDto>();
		List<Institution> institutions = institutionDao.getByDsKeyProject(dsKey);
		if (institutions != null) {
			for(Institution institution : institutions) {
				institutionCreatedDto.add(new InstitutionCreatedDto(institution));
			}
		}
		return institutionCreatedDto;
	}
}