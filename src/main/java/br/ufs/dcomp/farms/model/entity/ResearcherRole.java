package br.ufs.dcomp.farms.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "researcher_role")
@XmlRootElement
@SequenceGenerator(name = "ResearcherRoleSequenceGenerator", sequenceName = "sq_project")
public class ResearcherRole {

	private Long idResearcherRole;
	private String nmResearcherRole;
	
	public ResearcherRole() {}

	public ResearcherRole(String nmResearcherRole) {
		this.nmResearcherRole = nmResearcherRole;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ResearcherRoleSequenceGenerator")
	@Column(name = "id_researcher_role", nullable = false, unique = true)
	public Long getIdResearcherRole() {
		return idResearcherRole;
	}
	
	public void setIdResearcherRole(Long idResearcherRole) {
		this.idResearcherRole = idResearcherRole;
	}
	
	@Column(name = "nm_researcher_role", nullable = false)
	public String getNmResearcherRole() {
		return nmResearcherRole;
	}
	
	public void setNmResearcherRole(String nmResearcherRole) {
		this.nmResearcherRole = nmResearcherRole;
	}
}
