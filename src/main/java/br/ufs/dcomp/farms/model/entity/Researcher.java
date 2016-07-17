package br.ufs.dcomp.farms.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.ufs.dcomp.farms.model.enums.StateEnum;

@Entity
@Table(name = "researcher")
@XmlRootElement
@JsonIgnoreProperties({"projectMembers"})
@SequenceGenerator(name = "ResearcherSequenceGenerator", sequenceName = "sq_researcher")
public class Researcher implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idResearcher;
	private String nmResearcher;
	private String dsSSO;
	private String dsEmail;
	private String dsPassword;
	private StateEnum tpState;
	
	private Set<ProjectMember> projectMembers = new HashSet<ProjectMember>(0);
	
	public Researcher() {}
	
	public Researcher(String nmResearcher, String dsEmail, StateEnum tpState) {
		super();
		this.nmResearcher = nmResearcher;
		this.dsEmail = dsEmail;
		this.tpState = tpState;
	}
	
	public Researcher(String nmResearcher, String dsSSO, String dsEmail, String dsPassword, StateEnum tpState) {
		super();
		this.nmResearcher = nmResearcher;
		this.dsSSO = dsSSO;
		this.dsEmail = dsEmail;
		this.dsPassword = dsPassword;
		this.tpState = tpState;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ResearcherSequenceGenerator")
	@Column(name = "id_researcher", nullable = false, unique = true)
	public Long getIdResearcher() {
		return idResearcher;
	}

	public void setIdResearcher(Long idResearcher) {
		this.idResearcher = idResearcher;
	}

	@Column(name = "nm_researcher", nullable = false)
	public String getNmResearcher() {
		return nmResearcher;
	}

	public void setNmResearcher(String nmResearcher) {
		this.nmResearcher = nmResearcher;
	}

	@Column(name = "ds_sso", nullable = false)
	public String getDsSSO() {
		return dsSSO;
	}

	public void setDsSSO(String dsSSO) {
		this.dsSSO = dsSSO;
	}
	
	@Column(name = "ds_email", nullable = false)
	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	@Column(name = "ds_password", nullable = false)
	public String getDsPassword() {
		return dsPassword;
	}

	public void setDsPassword(String dsPassword) {
		this.dsPassword = dsPassword;
	}
	
	@Column(name = "tp_state", nullable = false)
	@Enumerated(EnumType.STRING)
	public StateEnum getTpState() {
		return tpState;
	}

	public void setTpState(StateEnum tpState) {
		this.tpState = tpState;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "researcher")
	public Set<ProjectMember> getProjectMembers() {
		return projectMembers;
	}

	public void setProjectMembers(Set<ProjectMember> projectMembers) {
		this.projectMembers = projectMembers;
	}
}
