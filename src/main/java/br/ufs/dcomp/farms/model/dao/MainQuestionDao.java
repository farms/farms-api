package br.ufs.dcomp.farms.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.farms.model.entity.MainQuestion;

@Component
@SuppressWarnings("unchecked")
public class MainQuestionDao extends HibernateDao<MainQuestion> {

	public MainQuestionDao() {
		super(MainQuestion.class);
	}

	/**
	 * Returns main question from the specified project.
	 *
	 * @param dsKey the identifier of the project.
	 * @return a list with a main question of the specified project.
	 */
	public List<MainQuestion> getByDsKeyProject(String dsKey) {
		StringBuilder sbHql = new StringBuilder();
		sbHql.append("from MainQuestion mq");
		sbHql.append(" join fetch mq.project p");
		sbHql.append(" where p.dsKey = :dsKey");
		
		Query query = getSession().createQuery(sbHql.toString());
		query.setParameter("dsKey", dsKey);
		List<MainQuestion> mainQuestions = query.list();
		return mainQuestions;
	}
}
