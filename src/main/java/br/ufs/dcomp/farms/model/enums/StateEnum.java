package br.ufs.dcomp.farms.model.enums;

public enum StateEnum {

	R("R", "Registered"),
	A("A", "Active"),
	I("I", "Inactive"),
	D("D", "Deleted"),
	L("L", "Locked");
	     
	private String code;
	private String description;
	
	private StateEnum(String code, final String description){
	  this.code = code;
	  this.description = description;
	}

	public String getCode(){
		return this.code;
	}
	
	public void setCode(String code){
		this.code = code;
	}

	public String getDescription(){
	  return this.description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public static StateEnum fromCode(String code) {
		for (StateEnum e : StateEnum.values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}
	
	public static StateEnum fromDescription(String description) {
		if (description == null) {
			return null;
		}
		for (StateEnum e : StateEnum.values()) {
			if (description.equals(e.toString()) || description.equals(e.name())) {
				return e;
			}
		}
		return null;
	}
}