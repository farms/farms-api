package br.ufs.dcomp.farms.model.enums;

public enum RoleEnum {

	COORDINATOR(0, "Coordinator"),
	MEMBER(1, "Member");
	
	private Integer code;
	private String description;
	
	private RoleEnum(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static RoleEnum fromCode(Integer code) {
		for (RoleEnum e : RoleEnum.values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}
	
	public static RoleEnum fromDescription(String description) {
		if (description == null) {
			return null;
		}
		for (RoleEnum e : RoleEnum.values()) {
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
