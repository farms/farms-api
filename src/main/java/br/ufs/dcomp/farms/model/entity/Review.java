package br.ufs.dcomp.farms.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.ufs.dcomp.farms.model.enums.ReviewEnum;

@Entity
@Table(name = "review")
@XmlRootElement
@SequenceGenerator(name = "ReviewSequenceGenerator", sequenceName = "sq_review")
public class Review {

	private Long idReview;
	private Date dhAssign;
	private Date dhReview;
	private ReviewEnum tpStatus;
	private Researcher researcher;
	private Study study;
	
	public Review() {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ReviewSequenceGenerator")
	@Column(name = "id_review", nullable = false, unique = true)
	public Long getIdReview() {
		return idReview;
	}

	public void setIdReview(Long idReview) {
		this.idReview = idReview;
	}

	@Column(name = "dh_assign", nullable = false, unique = true)
	public Date getDhAssign() {
		return dhAssign;
	}

	public void setDhAssign(Date dhAssign) {
		this.dhAssign = dhAssign;
	}

	@Column(name = "dh_review", nullable = false, unique = true)
	public Date getDhReview() {
		return dhReview;
	}

	public void setDhReview(Date dhReview) {
		this.dhReview = dhReview;
	}

	@Column(name = "tp_status", nullable = false)
	@Enumerated(EnumType.ORDINAL)	
	public ReviewEnum getTpStatus() {
		return tpStatus;
	}

	public void setTpStatus(ReviewEnum tpStatus) {
		this.tpStatus = tpStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_researcher", nullable = false)
	public Researcher getResearcher() {
		return researcher;
	}

	public void setResearcher(Researcher researcher) {
		this.researcher = researcher;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_study", nullable = false)
	public Study getStudy() {
		return study;
	}

	public void setStudy(Study study) {
		this.study = study;
	}
}
