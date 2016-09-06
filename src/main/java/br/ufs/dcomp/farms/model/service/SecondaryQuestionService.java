package br.ufs.dcomp.farms.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.dao.SecondaryQuestionDao;
import br.ufs.dcomp.farms.model.dto.SecondaryQuestionCreatedDto;
import br.ufs.dcomp.farms.model.entity.SecondaryQuestion;

@Component
public class SecondaryQuestionService {

	@Autowired
	private SecondaryQuestionDao secondaryQuestionDao;

	public List<SecondaryQuestionCreatedDto> getByDsKeyProject(String dsKey) {
		List<SecondaryQuestionCreatedDto> studyCreatedDtos = new ArrayList<SecondaryQuestionCreatedDto>();
		List<SecondaryQuestion> secondaryQuestions = secondaryQuestionDao.getByDsKeyProject(dsKey);
		if (secondaryQuestions != null) {
			for(SecondaryQuestion secondaryQuestion : secondaryQuestions) {
				studyCreatedDtos.add(new SecondaryQuestionCreatedDto(secondaryQuestion));
			}
		}
		return studyCreatedDtos;
	}
}