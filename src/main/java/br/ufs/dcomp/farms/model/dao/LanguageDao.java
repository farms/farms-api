package br.ufs.dcomp.farms.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.entity.Language;

@Component
@SuppressWarnings("unchecked")
public class LanguageDao extends HibernateDao<Language> {

	public LanguageDao() {
		super(Language.class);
	}

	/**
	 * Returns all languages from the specified project.
	 *
	 * @param dsKey the identifier of the project.
	 * @return a list of all the languages of the specified project.
	 */
	public List<Language> getByDsKeyProject(String dsKey) {
		StringBuilder sbHql = new StringBuilder();
		sbHql.append("from Language l");
		sbHql.append(" join fetch l.studyLanguage sl");
		sbHql.append(" join fetch sl.project p");
		sbHql.append(" where p.dsKey = :dsKey");
		
		Query query = getSession().createQuery(sbHql.toString());
		query.setParameter("dsKey", dsKey);
		List<Language> languages = query.list();
		return languages;
	}
}
