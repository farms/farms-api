package br.ufs.dcomp.farms.model.dto;

import br.ufs.dcomp.farms.model.entity.Language;

public class LanguageCreatedDto {

	private Long idLanguage;
	private String nmLanguage;
	
	public LanguageCreatedDto(Language language) {
		this.idLanguage = language.getIdLanguage();
		this.nmLanguage = language.getNmLanguage();
	}

	public Long getIdLanguage() {
		return idLanguage;
	}

	public void setIdLanguage(Long idLanguage) {
		this.idLanguage = idLanguage;
	}

	public String getNmLanguage() {
		return nmLanguage;
	}

	public void setNmLanguage(String nmLanguage) {
		this.nmLanguage = nmLanguage;
	}
}