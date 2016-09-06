package br.ufs.dcomp.farms.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.dao.MainQuestionDao;
import br.ufs.dcomp.farms.model.dto.MainQuestionCreatedDto;
import br.ufs.dcomp.farms.model.entity.MainQuestion;

@Component
public class MainQuestionService {

	@Autowired
	private MainQuestionDao mainQuestionDao;

	public List<MainQuestionCreatedDto> getByDsKeyProject(String dsKey) {
		List<MainQuestionCreatedDto> mainQuestionCreatedDto = new ArrayList<MainQuestionCreatedDto>();
		List<MainQuestion> mainQuestions = mainQuestionDao.getByDsKeyProject(dsKey);
		if (mainQuestions != null) {
			for(MainQuestion mainQuestion : mainQuestions) {
				mainQuestionCreatedDto.add(new MainQuestionCreatedDto(mainQuestion));
			}
		}
		return mainQuestionCreatedDto;
	}
}