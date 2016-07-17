package br.ufs.dcomp.farms.model.enums;

public enum ExtractionStatusEnum {

	ASSIGNED(0, "Assigned"),
	EXTRACTED(1, "Extracted"),
	IN_CONFLICT(2, "In conflict"),
	FINAL(3, "Final");
	     
	private Integer code;
	private String description;
	
	private ExtractionStatusEnum(Integer code, final String description){
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
	
	public static ExtractionStatusEnum fromCode(Integer code) {
		for (ExtractionStatusEnum e : ExtractionStatusEnum.values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}
	
	public static ExtractionStatusEnum fromDescription(String description) {
		if (description == null) {
			return null;
		}
		for (ExtractionStatusEnum e : ExtractionStatusEnum.values()) {
			if (description.equals(e.toString()) || description.equals(e.name())) {
				return e;
			}
		}
		return null;
	}
}