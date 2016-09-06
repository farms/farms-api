package br.ufs.dcomp.farms.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.dao.StandardQueryDao;
import br.ufs.dcomp.farms.model.dto.StandardQueryCreatedDto;
import br.ufs.dcomp.farms.model.entity.StandardQuery;

@Component
public class StandardQueryService {

	@Autowired
	private StandardQueryDao standardQueryDao;

	public List<StandardQueryCreatedDto> getByDsKeyProject(String dsKey) {
		List<StandardQueryCreatedDto> languageCreatedDtos = new ArrayList<StandardQueryCreatedDto>();
		List<StandardQuery> standardQuerys = standardQueryDao.getByDsKeyProject(dsKey);
		if (standardQuerys != null) {
			for(StandardQuery standardQuery : standardQuerys) {
				languageCreatedDtos.add(new StandardQueryCreatedDto(standardQuery));
			}
		}
		return languageCreatedDtos;
	}
}