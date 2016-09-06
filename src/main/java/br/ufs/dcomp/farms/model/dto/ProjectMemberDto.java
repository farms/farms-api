package br.ufs.dcomp.farms.model.dto;

import br.ufs.dcomp.farms.model.entity.ProjectMember;

public class ProjectMemberDto {

	private Long idProjectMember;
	private String nmResearcher;
	private String dsSSO;
	private String dsEmail;
	private Integer tpConfirmed;
	private Integer tpRole;
	private String nmInstitution;
	
	public ProjectMemberDto() {}
	
	public ProjectMemberDto(ProjectMember projectMember) {
		super();
		this.idProjectMember = projectMember.getIdProjectMember();
		this.nmResearcher = projectMember.getResearcher().getNmResearcher();
		this.dsSSO = projectMember.getResearcher().getDsSSO();
		this.dsEmail = projectMember.getResearcher().getDsEmail();
		this.tpConfirmed = projectMember.getResearcher().getTpConfirmed().getCode();
		this.tpRole = projectMember.getTpRole().getCode();
		this.nmInstitution = projectMember.getInstitution().getNmInstitution();
	}

	public Long getIdProjectMember() {
		return idProjectMember;
	}

	public void setIdProjectMember(Long idProjectMember) {
		this.idProjectMember = idProjectMember;
	}

	public String getNmResearcher() {
		return nmResearcher;
	}

	public void setNmResearcher(String nmResearcher) {
		this.nmResearcher = nmResearcher;
	}

	public String getDsSSO() {
		return dsSSO;
	}

	public void setDsSSO(String dsSSO) {
		this.dsSSO = dsSSO;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public Integer getTpConfirmed() {
		return tpConfirmed;
	}

	public void setTpConfirmed(Integer tpConfirmed) {
		this.tpConfirmed = tpConfirmed;
	}

	public Integer getTpRole() {
		return tpRole;
	}

	public void setTpRole(Integer tpRole) {
		this.tpRole = tpRole;
	}

	public String getNmInstitution() {
		return nmInstitution;
	}

	public void setNmInstitution(String nmInstitution) {
		this.nmInstitution = nmInstitution;
	}
}