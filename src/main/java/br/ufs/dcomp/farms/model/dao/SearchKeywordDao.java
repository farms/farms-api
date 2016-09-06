package br.ufs.dcomp.farms.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.entity.SearchKeyword;

@Component
@SuppressWarnings("unchecked")
public class SearchKeywordDao extends HibernateDao<SearchKeyword> {

	public SearchKeywordDao() {
		super(SearchKeyword.class);
	}

	/**
	 * Returns all search keywords from the specified project.
	 *
	 * @param dsKey the identifier of the project.
	 * @return a list of all the search keywords of the specified project.
	 */
	public List<SearchKeyword> getByDsKeyProject(String dsKey) {
		StringBuilder sbHql = new StringBuilder();
		sbHql.append("from SearchKeyword sk");
		sbHql.append(" join fetch sk.project p");
		sbHql.append(" where p.dsKey = :dsKey");
		
		Query query = getSession().createQuery(sbHql.toString());
		query.setParameter("dsKey", dsKey);
		List<SearchKeyword> searchKeyword = query.list();
		return searchKeyword;
	}
}