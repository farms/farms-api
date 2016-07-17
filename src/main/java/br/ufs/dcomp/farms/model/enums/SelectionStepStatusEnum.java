package br.ufs.dcomp.farms.model.enums;

public enum SelectionStepStatusEnum {

	ASSIGNED(0, "Setting"),
	ACCEPTED(1, "On going"),
	REJECTED(2, "Solving conflicts"),
	FINISHED(3, "Finished");
	     
	private Integer code;
	private String description;
	
	private SelectionStepStatusEnum(Integer code, final String description){
	  this.code = code;
	  this.description = description;
	}

	public Integer getCode(){
		return this.code;
	}
	
	public void setCode(Integer code){
		this.code = code;
	}

	public String getDescription(){
	  return this.description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public static SelectionStepStatusEnum fromCode(Integer code) {
		for (SelectionStepStatusEnum e : SelectionStepStatusEnum.values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}
	
	public static SelectionStepStatusEnum fromDescription(String description) {
		if (description == null) {
			return null;
		}
		for (SelectionStepStatusEnum e : SelectionStepStatusEnum.values()) {
			if (description.equals(e.toString()) || description.equals(e.name())) {
				return e;
			}
		}
		return null;
	}
}