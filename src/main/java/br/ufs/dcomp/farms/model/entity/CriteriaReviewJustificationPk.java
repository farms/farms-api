package br.ufs.dcomp.farms.model.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CriteriaReviewJustificationPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Review review;
	private SelectionCriteria selectionCriteria;
	
	public CriteriaReviewJustificationPk() {
		super();
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_review", nullable = false)
	public Review getReview() {
		return review;
	}
	
	public void setReview(Review review) {
		this.review = review;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_selection_criteria", nullable = false)
	public SelectionCriteria getSelectionCriteria() {
		return selectionCriteria;
	}
	
	public void setSelectionCriteria(SelectionCriteria selectionCriteria) {
		this.selectionCriteria = selectionCriteria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((review == null) ? 0 : review.hashCode());
		result = prime * result + ((selectionCriteria == null) ? 0 : selectionCriteria.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CriteriaReviewJustificationPk other = (CriteriaReviewJustificationPk) obj;
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
			return false;
		if (selectionCriteria == null) {
			if (other.selectionCriteria != null)
				return false;
		} else if (!selectionCriteria.equals(other.selectionCriteria))
			return false;
		return true;
	}
}
