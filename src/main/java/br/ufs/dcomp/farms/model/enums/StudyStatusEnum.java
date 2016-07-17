package br.ufs.dcomp.farms.model.enums;

public enum StudyStatusEnum {

	SETTING(0, "Unclassified"),
	ON_GOING (1, "Duplicated"),
	LOW(2, "Included"),
	FINISHED(3, "Excluded");
	     
	private Integer code;
	private String description;
	
	private StudyStatusEnum(Integer code, final String description){
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
	
	public static StudyStatusEnum fromCode(Integer code) {
		for (StudyStatusEnum e : StudyStatusEnum.values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}
	
	public static StudyStatusEnum fromDescription(String description) {
		if (description == null) {
			return null;
		}
		for (StudyStatusEnum e : StudyStatusEnum.values()) {
			if (description.equals(e.toString()) || description.equals(e.name())) {
				return e;
			}
		}
		return null;
	}
}