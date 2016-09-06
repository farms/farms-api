package br.ufs.dcomp.farms.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.dao.SearchEngineDao;
import br.ufs.dcomp.farms.model.dto.SearchEngineCreatedDto;
import br.ufs.dcomp.farms.model.entity.SearchEngine;

@Component
public class SearchEngineService {

	@Autowired
	private SearchEngineDao searchEngineDao;

	public List<SearchEngineCreatedDto> getByDsKeyProject(String dsKey) {
		List<SearchEngineCreatedDto> searchEngineCreatedDto = new ArrayList<SearchEngineCreatedDto>();
		List<SearchEngine> searchEngines = searchEngineDao.getByDsKeyProject(dsKey);
		if (searchEngines != null) {
			for(SearchEngine searchEngine : searchEngines) {
				searchEngineCreatedDto.add(new SearchEngineCreatedDto(searchEngine));
			}
		}
		return searchEngineCreatedDto;
	}
}