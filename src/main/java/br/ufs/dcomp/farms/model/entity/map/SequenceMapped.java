package br.ufs.dcomp.farms.model.entity.map;

public class SequenceMapped {

	private String nmSequence;
	private boolean sequenceExists = false;
	
	public SequenceMapped() {
		super();
	}

	public SequenceMapped(String nmSequence) {
		super();
		this.nmSequence = nmSequence;
	}
	
	public String getNmSequence() {
		return nmSequence;
	}

	public void setNmSequence(String nmSequence) {
		this.nmSequence = nmSequence;
	}

	public boolean isSequenceExists() {
		return sequenceExists;
	}

	public void setSequenceExists(boolean sequenceExists) {
		this.sequenceExists = sequenceExists;
	}
}
