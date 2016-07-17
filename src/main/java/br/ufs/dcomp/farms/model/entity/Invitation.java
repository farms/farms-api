package br.ufs.dcomp.farms.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "invitation")
@XmlRootElement
@SequenceGenerator(name = "InvitationSequenceGenerator", sequenceName = "sq_invitation")
public class Invitation {

	private Long idInvitation;
	private Date dhInvitation;
	private Date dhConfirmation;
	private Project project;
	private Researcher researcher;
	
	public Invitation() {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "InvitationSequenceGenerator")
	@Column(name = "id_invitation", nullable = false, unique = true)
	public Long getIdInvitation() {
		return idInvitation;
	}

	public void setIdInvitation(Long idInvitation) {
		this.idInvitation = idInvitation;
	}

	@Column(name = "dh_invitation", nullable = false, unique = true)
	public Date getDhInvitation() {
		return dhInvitation;
	}

	public void setDhInvitation(Date dhInvitation) {
		this.dhInvitation = dhInvitation;
	}

	@Column(name = "dh_confirmation", nullable = false, unique = true)
	public Date getDhConfirmation() {
		return dhConfirmation;
	}

	public void setDhConfirmation(Date dhConfirmation) {
		this.dhConfirmation = dhConfirmation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_project", nullable = false)
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_researcher", nullable = false)
	public Researcher getResearcher() {
		return researcher;
	}

	public void setResearcher(Researcher researcher) {
		this.researcher = researcher;
	}
}
