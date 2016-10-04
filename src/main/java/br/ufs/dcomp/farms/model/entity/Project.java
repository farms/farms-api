package br.ufs.dcomp.farms.model.entity;

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

import br.ufs.dcomp.farms.model.enums.ReviewEnum;

@Entity
@Table(name = "project")
@XmlRootElement
@SequenceGenerator(name = "ProjectSequenceGenerator", sequenceName = "sq_project")
public class Project {
	
	private Long idProject;
	private String dsTitle;
	private String dsKey;
	private String dsProject;
	private ReviewEnum tpReview;
	
	private Set<ProjectMember> projectMembers = new HashSet<ProjectMember>(0);
	private Set<Objective> objectives = new HashSet<Objective>(0);
	private Set<MainQuestion> mainQuestions = new HashSet<MainQuestion>(0);
	private Set<SecondaryQuestion> secondaryQuestions = new HashSet<SecondaryQuestion>(0);
	private Set<SelectionCriteria> selectionCriterias = new HashSet<SelectionCriteria>(0);
	private Set<SearchKeyword> searchKeywords = new HashSet<SearchKeyword>(0);
	private Set<StandardQuery> standardQuerys = new HashSet<StandardQuery>(0);
	private Set<Study> search = new HashSet<Study>(0);
	private Set<Study> studies = new HashSet<Study>(0);
	
	public Project() {}

	public Project(String dsTitle, String dsKey, String dsProject, ReviewEnum tpReview) {
		this.dsTitle = dsTitle;
		this.dsKey = dsKey;
		this.dsProject = dsProject;
		this.tpReview = tpReview;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ProjectSequenceGenerator")
	@Column(name = "id_project", nullable = false, unique = true)
	public Long getIdProject() {
		return idProject;
	}

	public void setIdProject(Long idProject) {
		this.idProject = idProject;
	}

	@Column(name = "ds_key", nullable = false, unique = true)
	public String getDsKey() {
		return dsKey;
	}

	public void setDsKey(String dsKey) {
		this.dsKey = dsKey;
	}
	
	@Column(name = "ds_title", nullable = false)
	public String getDsTitle() {
		return dsTitle;
	}

	public void setDsTitle(String dsTitle) {
		this.dsTitle = dsTitle;
	}

	@Column(name = "ds_project")
	public String getDsProject() {
		return dsProject;
	}

	public void setDsProject(String dsProject) {
		this.dsProject = dsProject;
	}

	@Column(name = "tp_review", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	public ReviewEnum getTpReview() {
		return tpReview;
	}

	public void setTpReview(ReviewEnum tpReview) {
		this.tpReview = tpReview;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	public Set<ProjectMember> getProjectMembers() {
		return projectMembers;
	}

	public void setProjectMembers(Set<ProjectMember> projectMembers) {
		this.projectMembers = projectMembers;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	public Set<Objective> getObjectives() {
		return this.objectives;
	}

	public void setObjectives(Set<Objective> objectives) {
		this.objectives = objectives;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	public Set<MainQuestion> getMainQuestions() {
		return this.mainQuestions;
	}

	public void setMainQuestions(Set<MainQuestion> mainQuestions) {
		this.mainQuestions = mainQuestions;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	public Set<SecondaryQuestion> getSecondaryQuestions() {
		return this.secondaryQuestions;
	}

	public void setSecondaryQuestions(Set<SecondaryQuestion> secondaryQuestions) {
		this.secondaryQuestions = secondaryQuestions;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	public Set<SelectionCriteria> getSelectionCriterias() {
		return this.selectionCriterias;
	}

	public void setSelectionCriterias(Set<SelectionCriteria> selectionCriterias) {
		this.selectionCriterias = selectionCriterias;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	public Set<SearchKeyword> getSearchKeywords() {
		return this.searchKeywords;
	}

	public void setSearchKeywords(Set<SearchKeyword> searchKeywords) {
		this.searchKeywords = searchKeywords;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	public Set<StandardQuery> getStandardQuerys() {
		return this.standardQuerys;
	}

	public void setStandardQuerys(Set<StandardQuery> standardQuerys) {
		this.standardQuerys = standardQuerys;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "search")
	public Set<Study> getSearch() {
		return search;
	}

	public void setSearch(Set<Study> search) {
		this.search = search;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	public Set<Study> getStudies() {
		return this.studies;
	}

	public void setStudies(Set<Study> studies) {
		this.studies = studies;
	}
}