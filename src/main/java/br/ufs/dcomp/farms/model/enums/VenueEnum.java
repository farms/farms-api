package br.ufs.dcomp.farms.model.enums;

public enum VenueEnum {

	JOURNAL(0, "Journal"),
	CONFERENCE_PROCEEDINGS(1, "Conference Proceedings"),
	TECHINICAL_REPORT(2, "Technical Report"),
	THESIS(3, "Thesis"),
	BOOK(4, "Book");
	
	private Integer code;
	private String description;
	
	private VenueEnum(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static VenueEnum fromCode(Integer code) {
		for (VenueEnum e : VenueEnum.values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}
	
	public static VenueEnum fromDescription(String description) {
		if (description == null) {
			return null;
		}
		for (VenueEnum e : VenueEnum.values()) {
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
