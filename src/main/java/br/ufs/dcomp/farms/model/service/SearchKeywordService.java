package br.ufs.dcomp.farms.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.dao.SearchKeywordDao;
import br.ufs.dcomp.farms.model.dto.SearchKeywordCreatedDto;
import br.ufs.dcomp.farms.model.entity.SearchKeyword;

@Component
public class SearchKeywordService {

	@Autowired
	private SearchKeywordDao searchKeywordDao;

	public List<SearchKeywordCreatedDto> getByDsKeyProject(String dsKey) {
		List<SearchKeywordCreatedDto> searchKeywordCreatedDto = new ArrayList<SearchKeywordCreatedDto>();
		List<SearchKeyword> searchKeywords = searchKeywordDao.getByDsKeyProject(dsKey);
		if (searchKeywords != null) {
			for(SearchKeyword searchKeyword : searchKeywords) {
				searchKeywordCreatedDto.add(new SearchKeywordCreatedDto(searchKeyword));
			}
		}
		return searchKeywordCreatedDto;
	}
}