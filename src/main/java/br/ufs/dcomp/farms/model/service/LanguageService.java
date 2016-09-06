package br.ufs.dcomp.farms.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.dao.LanguageDao;
import br.ufs.dcomp.farms.model.dto.LanguageCreatedDto;
import br.ufs.dcomp.farms.model.entity.Language;

@Component
public class LanguageService {

	@Autowired
	private LanguageDao languageDao;

	public List<LanguageCreatedDto> getByDsKeyProject(String dsKey) {
		List<LanguageCreatedDto> languageCreatedDtos = new ArrayList<LanguageCreatedDto>();
		List<Language> languages = languageDao.getByDsKeyProject(dsKey);
		if (languages != null) {
			for(Language language : languages) {
				languageCreatedDtos.add(new LanguageCreatedDto(language));
			}
		}
		return languageCreatedDtos;
	}
}