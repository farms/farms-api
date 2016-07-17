package br.ufs.dcomp.farms.model.enums;

public enum CriteriaEnum {

	EXCLUSION(0, "Exclusion"),
	INCLUSION(1, "Inclusion");
	
	private Integer code;
	private String description;
	
	private CriteriaEnum(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static CriteriaEnum fromCode(Integer code) {
		for (CriteriaEnum e : CriteriaEnum.values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}
	
	public static CriteriaEnum fromDescription(String description) {
		if (description == null) {
			return null;
		}
		for (CriteriaEnum e : CriteriaEnum.values()) {
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
