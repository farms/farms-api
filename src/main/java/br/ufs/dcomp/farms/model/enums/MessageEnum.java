package br.ufs.dcomp.farms.model.enums;

public enum MessageEnum {

	SUCCESS(0, "SUCCESS"),
	ERROR(1, "ERROR"),
	INFORMATION(2, "INFORMATION");
	
	private Integer code;
	private String description;
	
	private MessageEnum(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static MessageEnum fromCode(Integer code) {
		for (MessageEnum e : MessageEnum.values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}
	
	public static MessageEnum fromDescription(String description) {
		if (description == null) {
			return null;
		}
		for (MessageEnum e : MessageEnum.values()) {
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
