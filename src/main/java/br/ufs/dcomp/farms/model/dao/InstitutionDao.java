package br.ufs.dcomp.farms.model.dao;

import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.entity.Institution;

@Component
public class InstitutionDao extends HibernateDao<Institution> {

	public InstitutionDao() {
		super(Institution.class);
	}
	
	public Institution getById(Long idInstitution) {
		return super.get(idInstitution);
	}
}
