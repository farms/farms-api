package br.ufs.dcomp.farms.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.entity.SecondaryQuestion;

@Component
@SuppressWarnings("unchecked")
public class SecondaryQuestionDao extends HibernateDao<SecondaryQuestion> {

	public SecondaryQuestionDao() {
		super(SecondaryQuestion.class);
	}

	/**
	 * Returns secondary question from the specified project.
	 *
	 * @param dsKey the identifier of the project.
	 * @return a list with a secondary question of the specified project.
	 */
	public List<SecondaryQuestion> getByDsKeyProject(String dsKey) {
		StringBuilder sbHql = new StringBuilder();
		sbHql.append("from SecondaryQuestion sq");
		sbHql.append(" join fetch sq.project p");
		sbHql.append(" where p.dsKey = :dsKey");
		
		Query query = getSession().createQuery(sbHql.toString());
		query.setParameter("dsKey", dsKey);
		List<SecondaryQuestion> secondaryQuestions = query.list();
		return secondaryQuestions;
	}
}