package br.ufs.dcomp.farms.model.enums;

public enum SearchEnum {

	AUTOMATIC(0, "Automatic"),
	MANUAL(1, "Manual");
	
	private Integer code;
	private String description;
	
	private SearchEnum(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static SearchEnum fromCode(Integer code) {
		for (SearchEnum e : SearchEnum.values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}
	
	public static SearchEnum fromDescription(String description) {
		if (description == null) {
			return null;
		}
		for (SearchEnum e : SearchEnum.values()) {
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
