package br.ufs.dcomp.farms.model.enums;

public enum ReadingRateEnum {

	VERY_HIGH(0, "Very high"),
	HIGH(1, "High"),
	LOW(2, "Low"),
	VERY_LOW(3, "Very low");
	     
	private Integer code;
	private String description;
	
	private ReadingRateEnum(Integer code, final String description){
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
	
	public static ReadingRateEnum fromCode(Integer code) {
		for (ReadingRateEnum e : ReadingRateEnum.values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}
	
	public static ReadingRateEnum fromDescription(String description) {
		if (description == null) {
			return null;
		}
		for (ReadingRateEnum e : ReadingRateEnum.values()) {
			if (description.equals(e.toString()) || description.equals(e.name())) {
				return e;
			}
		}
		return null;
	}
}