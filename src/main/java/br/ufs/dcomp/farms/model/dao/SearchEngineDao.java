package br.ufs.dcomp.farms.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.entity.SearchEngine;

@Component
@SuppressWarnings("unchecked")
public class SearchEngineDao extends HibernateDao<SearchEngine> {

	public SearchEngineDao() {
		super(SearchEngine.class);
	}

	/**
	 * Returns all search engines from the specified project.
	 *
	 * @param dsKey the identifier of the project.
	 * @return a list of all the search engines of the specified project.
	 */
	public List<SearchEngine> getByDsKeyProject(String dsKey) {
		StringBuilder sbHql = new StringBuilder();
		sbHql.append("from SearchEngine se");
		sbHql.append(" join fetch se.baseUseCriteria bc");
		sbHql.append(" join fetch bc.project p");
		sbHql.append(" where p.dsKey = :dsKey");
		
		Query query = getSession().createQuery(sbHql.toString());
		query.setParameter("dsKey", dsKey);
		List<SearchEngine> searchEngines = query.list();
		return searchEngines;
	}
}