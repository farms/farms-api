package br.ufs.dcomp.farms.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.dao.SelectionCriteriaDao;
import br.ufs.dcomp.farms.model.dao.StudyDao;
import br.ufs.dcomp.farms.model.dto.SelectionCriteriaCreatedDto;
import br.ufs.dcomp.farms.model.dto.StudyCreatedDto;
import br.ufs.dcomp.farms.model.entity.SelectionCriteria;
import br.ufs.dcomp.farms.model.entity.Study;

@Component
public class SelectionCriteriaService {

	@Autowired
	private SelectionCriteriaDao selectionCriteriaDao;

	public List<SelectionCriteriaCreatedDto> getByDsKeyProject(String dsKey) {
		List<SelectionCriteriaCreatedDto> selectionCriteriaCreatedDtos = new ArrayList<SelectionCriteriaCreatedDto>();
		List<SelectionCriteria> selectionCriterias = selectionCriteriaDao.getByDsKeyProject(dsKey);
		if (selectionCriterias != null) {
			for(SelectionCriteria selectionCriteria : selectionCriterias) {
				selectionCriteriaCreatedDtos.add(new SelectionCriteriaCreatedDto(selectionCriteria));
			}
		}
		return selectionCriteriaCreatedDtos;
	}
}