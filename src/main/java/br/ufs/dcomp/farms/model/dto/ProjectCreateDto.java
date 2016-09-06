package br.ufs.dcomp.farms.model.dto;

public class ProjectCreateDto {

	private String dsKey;
	private String dsTitle;
	private String dsProject;
	private Integer tpReview;
	private String dsSsoResearcher;
	private Long idInstitution;
	
	public ProjectCreateDto() {
		super();
	}

	public ProjectCreateDto(String dsKey, String dsTitle, String dsProject, Integer tpReview,
			String dsSsoResearcher, Long idInstitution) {
		super();
		this.dsKey = dsKey;
		this.dsTitle = dsTitle;
		this.dsProject = dsProject;
		this.tpReview = tpReview;
		this.dsSsoResearcher = dsSsoResearcher;
		this.idInstitution = idInstitution;
	}

	public String getDsKey() {
		return dsKey;
	}

	public void setDsKey(String dsKey) {
		this.dsKey = dsKey;
	}

	public String getDsTitle() {
		return dsTitle;
	}

	public void setDsTitle(String dsTitle) {
		this.dsTitle = dsTitle;
	}
	
	public String getDsProject() {
		return dsProject;
	}

	public void setDsProject(String dsProject) {
		this.dsProject = dsProject;
	}

	public Integer getTpReview() {
		return tpReview;
	}

	public void setTpReview(Integer tpReview) {
		this.tpReview = tpReview;
	}

	public String getDsSsoResearcher() {
		return dsSsoResearcher;
	}

	public void setDsSsoResearcher(String dsSsoResearcher) {
		this.dsSsoResearcher = dsSsoResearcher;
	}

	public Long getIdInstitution() {
		return idInstitution;
	}

	public void setIdInstitution(Long idInstitution) {
		this.idInstitution = idInstitution;
	}
}