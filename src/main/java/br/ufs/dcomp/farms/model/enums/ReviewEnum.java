package br.ufs.dcomp.farms.model.enums;

public enum ReviewEnum {

	NOT_SYSTEMATIC(0, "Not Systematic"),
	SYSTEMATIC_MAPPING(1, "Systematic Mapping"),
	SYSTEMATIC_REVIEW(2, "Systematic Review");
	
	private Integer code;
	private String description;
	
	private ReviewEnum(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static ReviewEnum fromCode(Integer code) {
		for (ReviewEnum e : ReviewEnum.values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}
	
	public static ReviewEnum fromDescription(String description) {
		if (description == null) {
			return null;
		}
		for (ReviewEnum e : ReviewEnum.values()) {
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
