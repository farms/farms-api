package br.ufs.dcomp.farms.model.dto;

import br.ufs.dcomp.farms.model.entity.SearchEngine;

public class SearchEngineCreatedDto {

	private Long idSearchEngine;
	private String nmSearchEngine;
	
	public SearchEngineCreatedDto(SearchEngine searchEngine) {
		this.idSearchEngine = searchEngine.getIdSearchEngine();
		this.nmSearchEngine = searchEngine.getNmSearchEngine();
	}
	
	public Long getIdSearchEngine() {
		return idSearchEngine;
	}
	public void setIdSearchEngine(Long idSearchEngine) {
		this.idSearchEngine = idSearchEngine;
	}
	public String getNmSearchEngine() {
		return nmSearchEngine;
	}
	public void setNmSearchEngine(String nmSearchEngine) {
		this.nmSearchEngine = nmSearchEngine;
	}
}