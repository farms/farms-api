package br.ufs.dcomp.farms.model.enums;

public enum ExtractionStepStatusEnum {

	SETTING(0, "Setting"),
	ON_GOING (1, "On going"),
	REVIEWING_EXTRACTION(2, "Reviewing extraction"),
	FINISHED(3, "Finished");
	     
	private Integer code;
	private String description;
	
	private ExtractionStepStatusEnum(Integer code, final String description){
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
	
	public static ExtractionStepStatusEnum fromCode(Integer code) {
		for (ExtractionStepStatusEnum e : ExtractionStepStatusEnum.values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}
	
	public static ExtractionStepStatusEnum fromDescription(String description) {
		if (description == null) {
			return null;
		}
		for (ExtractionStepStatusEnum e : ExtractionStepStatusEnum.values()) {
			if (description.equals(e.toString()) || description.equals(e.name())) {
				return e;
			}
		}
		return null;
	}
}