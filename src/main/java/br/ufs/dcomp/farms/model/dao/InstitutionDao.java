package br.ufs.dcomp.farms.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.entity.Institution;

@Component
@SuppressWarnings("unchecked")
public class InstitutionDao extends HibernateDao<Institution> {

	public InstitutionDao() {
		super(Institution.class);
	}
	
	public Institution getById(Long idInstitution) {
		return super.get(idInstitution);
	}
	
	/**
	 * Returns all institutions from the specified project.
	 *
	 * @param dsKey the identifier of the project.
	 * @return a list of all the institutions of the specified project.
	 */
	public List<Institution> getByDsKeyProject(String dsKey) {
		StringBuilder sbHql = new StringBuilder();
		sbHql.append("from Institution i");
		sbHql.append(" join fetch i.project p");
		sbHql.append(" where p.dsKey = :dsKey");
		
		Query query = getSession().createQuery(sbHql.toString());
		query.setParameter("dsKey", dsKey);
		List<Institution> institutions = query.list();
		return institutions;
	}
}
