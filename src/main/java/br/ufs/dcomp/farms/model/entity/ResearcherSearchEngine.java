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
@Table(name = "researcher_search_engine")
@XmlRootElement
@SequenceGenerator(name = "ResearcherSearchEngineSequenceGenerator", sequenceName = "sq_researcher_search_engine")
public class ResearcherSearchEngine {

	private Long idResearcherSearchEngine;
	private Project project;
	private SearchEngine searchEngine;
	private Researcher researcher;
	private Date dhAssign;
	
	public ResearcherSearchEngine() {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ResearcherSearchEngineSequenceGenerator")
	@Column(name = "id_researcher_search_engine", nullable = false, unique = true)
	public Long getIdResearcherSearchEngine() {
		return idResearcherSearchEngine;
	}

	public void setIdResearcherSearchEngine(Long idResearcherSearchEngine) {
		this.idResearcherSearchEngine = idResearcherSearchEngine;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_search_engine", nullable = false)
	public SearchEngine getSearchEngine() {
		return searchEngine;
	}

	public void setSearchEngine(SearchEngine searchEngine) {
		this.searchEngine = searchEngine;
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
	
	@Column(name = "dh_assign", nullable = false, unique = true)
	public Date getDhAssign() {
		return dhAssign;
	}

	public void setDhAssign(Date dhAssign) {
		this.dhAssign = dhAssign;
	}
}