package br.ufs.dcomp.farms.model.dto;

import br.ufs.dcomp.farms.model.entity.SearchKeyword;

public class SearchKeywordCreatedDto {

	private Long idSearchKeyword;
	private String dsSearchKeyword;
	
	public SearchKeywordCreatedDto(SearchKeyword searchKeyword) {
		this.idSearchKeyword = searchKeyword.getIdSearchKeyword();
		this.dsSearchKeyword = searchKeyword.getDsSearchKeyword();
	}

	public Long getIdSearchKeyword() {
		return idSearchKeyword;
	}

	public void setIdSearchKeyword(Long idSearchKeyword) {
		this.idSearchKeyword = idSearchKeyword;
	}

	public String getDsSearchKeyword() {
		return dsSearchKeyword;
	}

	public void setDsSearchKeyword(String dsSearchKeyword) {
		this.dsSearchKeyword = dsSearchKeyword;
	}	
}