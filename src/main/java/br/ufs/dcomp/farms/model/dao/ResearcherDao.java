package br.ufs.dcomp.farms.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.entity.Researcher;

@SuppressWarnings("unchecked")
@Component
public class ResearcherDao extends HibernateDao<Researcher> {

	public ResearcherDao() {
		super(Researcher.class);
	}

	/**
	 * Inserts a researcher.
	 * @param researcher
	 */
	public void save(Researcher researcher) {
		super.save(researcher);
	}

	/**
	 * Deletes a researcher at id.
	 * @param id
	 * @return
	 */
	public boolean delete(Long idResearcher) {
		Researcher researcher = get(idResearcher);
		super.delete(researcher);
		return true;
	}
	
	/**
	 * Gets a researcher at id.
	 * @param id
	 * @return
	 */
	public Researcher get(Long idResearcher) {
		return super.get(idResearcher);
	}

	/**
	 * Returns all researchers.
	 *
	 * @return a list of all the researchers.
	 */
	public List<Researcher> getAll() {
		Query query = getSession().createQuery("from Researcher");
		return query.list();
	}
	
	/**
	 * Search a researcher by the name.
	 * @param nmResearcher
	 * @return
	 */
	public List<Researcher> getByNmResearcher(String nmResearcher) {
		Query query = getSession().createQuery("from Researcher where lower(nmResearcher) like lower(?)");
		query.setString(0, "%" + nmResearcher + "%");
		return query.list();
	}
	
	/**
	 * Search a researcher by sso (username).
	 * @param dsSSO
	 * @return
	 */
	public Researcher getByDsSSO(String dsSSO) {
		Query query = getSession().createQuery("from Researcher r where lower(r.dsSSO) = lower(?)");
		query.setString(0, dsSSO);
		List<Researcher> results = query.list();
		return (results != null && !results.isEmpty()) ? (Researcher) results.get(0) : null;
	}
	
	/**
	 * Search a researcher by e-mail.
	 * @param dsEmail
	 * @return
	 */
	public Researcher getByDsEmail(String dsEmail) {
		Query query = getSession().createQuery("from Researcher r where lower(r.dsEmail) = lower(?)");
		query.setString(0, dsEmail);
		List<Researcher> results = query.list();
		return (results != null && !results.isEmpty()) ? (Researcher) results.get(0) : null;
	}
	
	/**
	 * Returns all researchers from the specified project.
	 *
	 * @param dsSlug the identifier of the project.
	 * @return a list of all the researchers of the specified project.
	 */
	public List<Researcher> getByDsSlugProject(String dsSlug) {
		StringBuilder sbHql = new StringBuilder();
		sbHql.append("from Researcher r");
		sbHql.append(" join fetch r.projectMember pm");
		sbHql.append(" where pm.project.dsSlug = :dsSlug");
		
		Query query = getSession().createQuery(sbHql.toString());
		query.setParameter("dsSlug", dsSlug);
		List<Researcher> researchers = query.list();
		return researchers;
	}

	public Researcher getByUuid(String cdUuid) {
		Query query = getSession().createQuery("from Researcher r where lower(r.cdUuid) = lower(?)");
		query.setString(0, cdUuid);
		List<Researcher> results = query.list();
		return (results != null && !results.isEmpty()) ? (Researcher) results.get(0) : null;
	}
}