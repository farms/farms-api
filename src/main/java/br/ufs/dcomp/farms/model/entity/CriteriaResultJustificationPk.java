package br.ufs.dcomp.farms.model.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CriteriaResultJustificationPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SelectionResult selectionResult;
	private SelectionCriteria selectionCriteria;
	
	public CriteriaResultJustificationPk() {
		super();
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_selection_result", nullable = false)
	public SelectionResult getSelectionResult() {
		return selectionResult;
	}

	public void setSelectionResult(SelectionResult selectionResult) {
		this.selectionResult = selectionResult;
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
		result = prime * result + ((selectionCriteria == null) ? 0 : selectionCriteria.hashCode());
		result = prime * result + ((selectionResult == null) ? 0 : selectionResult.hashCode());
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
		CriteriaResultJustificationPk other = (CriteriaResultJustificationPk) obj;
		if (selectionCriteria == null) {
			if (other.selectionCriteria != null)
				return false;
		} else if (!selectionCriteria.equals(other.selectionCriteria))
			return false;
		if (selectionResult == null) {
			if (other.selectionResult != null)
				return false;
		} else if (!selectionResult.equals(other.selectionResult))
			return false;
		return true;
	}
}