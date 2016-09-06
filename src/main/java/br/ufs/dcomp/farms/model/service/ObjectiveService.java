package br.ufs.dcomp.farms.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.dao.ObjectiveDao;
import br.ufs.dcomp.farms.model.dto.ObjectiveCreatedDto;
import br.ufs.dcomp.farms.model.entity.Objective;

@Component
public class ObjectiveService {

	@Autowired
	private ObjectiveDao objectiveDao;

	public List<ObjectiveCreatedDto> getByDsKeyProject(String dsKey) {
		List<ObjectiveCreatedDto> objectiveCreatedDto = new ArrayList<ObjectiveCreatedDto>();
		List<Objective> objectives = objectiveDao.getByDsKeyProject(dsKey);
		if (objectives != null) {
			for(Objective objective : objectives) {
				objectiveCreatedDto.add(new ObjectiveCreatedDto(objective));
			}
		}
		return objectiveCreatedDto;
	}
}