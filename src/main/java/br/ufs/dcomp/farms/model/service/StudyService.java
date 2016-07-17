package br.ufs.dcomp.farms.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.dao.StudyDao;
import br.ufs.dcomp.farms.model.dto.StudyCreatedDto;
import br.ufs.dcomp.farms.model.entity.Study;

@Component
public class StudyService {

	@Autowired
	private StudyDao studyDao;

	public List<StudyCreatedDto> getByDsSlugProject(String dsSlug) {
		List<StudyCreatedDto> studyCreatedDto = new ArrayList<StudyCreatedDto>();
		List<Study> studies = studyDao.getByDsSlugProject(dsSlug);
		if (studies != null) {
			for(Study study : studies) {
				studyCreatedDto.add(new StudyCreatedDto(study));
			}
		}
		return studyCreatedDto;
	}
}