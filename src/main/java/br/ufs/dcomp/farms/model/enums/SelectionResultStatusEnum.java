package br.ufs.dcomp.farms.model.enums;

public enum SelectionResultStatusEnum {

	IN_CONFLICT(0, "In conflict"),
	ACCEPTED(1, "Accepted"),
	REJECTED(2, "Rejected");

	private Integer code;
	private String description;
	
	private SelectionResultStatusEnum(Integer code, final String description){
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
	
	public static SelectionResultStatusEnum fromCode(Integer code) {
		for (SelectionResultStatusEnum e : SelectionResultStatusEnum.values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}
	
	public static SelectionResultStatusEnum fromDescription(String description) {
		if (description == null) {
			return null;
		}
		for (SelectionResultStatusEnum e : SelectionResultStatusEnum.values()) {
			if (description.equals(e.toString()) || description.equals(e.name())) {
				return e;
			}
		}
		return null;
	}
}