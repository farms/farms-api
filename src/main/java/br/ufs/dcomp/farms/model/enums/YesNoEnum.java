package br.ufs.dcomp.farms.model.enums;

public enum YesNoEnum {

	N(0, "No"),
	Y(1, "Yes");
	
	private Integer code;
	private String description;
	
	private YesNoEnum(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static YesNoEnum fromCode(Integer code) {
		for (YesNoEnum e : YesNoEnum.values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}
	
	public static YesNoEnum fromDescription(String description) {
		if (description == null) {
			return null;
		}
		for (YesNoEnum e : YesNoEnum.values()) {
			if (description.equals(e.toString()) || description.equals(e.name())) {
				return e;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return this.description;
	}
	
}
