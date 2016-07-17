package br.ufs.dcomp.farms.model.enums;

public enum SelectionStatusEnum {

	ASSIGNED(0, "Assigned"),
	ACCEPTED(1, "Accepted"),
	REJECTED(2, "Rejected");
	     
	private Integer code;
	private String description;
	
	private SelectionStatusEnum(Integer code, final String description){
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
	
	public static SelectionStatusEnum fromCode(Integer code) {
		for (SelectionStatusEnum e : SelectionStatusEnum.values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}
	
	public static SelectionStatusEnum fromDescription(String description) {
		if (description == null) {
			return null;
		}
		for (SelectionStatusEnum e : SelectionStatusEnum.values()) {
			if (description.equals(e.toString()) || description.equals(e.name())) {
				return e;
			}
		}
		return null;
	}
}