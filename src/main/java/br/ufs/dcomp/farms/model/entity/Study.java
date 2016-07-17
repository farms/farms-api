package br.ufs.dcomp.farms.model.entity;

import java.io.Serializable;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.ufs.dcomp.farms.model.enums.ReadingRateEnum;
import br.ufs.dcomp.farms.model.enums.StudyStatusEnum;
import br.ufs.dcomp.farms.model.enums.VenueEnum;

@Entity
@Table(name = "study")
@XmlRootElement
@JsonIgnoreProperties({"project", "search"})
@SequenceGenerator(name = "StudySequenceGenerator", sequenceName = "sq_study")
public class Study implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idStudy;
	private String cdCiteKey;
	private String dsTitle;
	private String nmAuthor;
	private String dsAbstract;
	private String dsKeyword;
	private Integer nrYear;
	private String dsVolume;
	private String dsUrl;
	private String cdIssnIsbn;
	private String cdDoi;
	private String dsType;
	private String dsPage;
	private String dsComment;
	private String dsJournal;
	private VenueEnum tpVenue;
	private ReadingRateEnum tpReadingRate;
	private StudyStatusEnum tpStatus;
	private Project project;
	private Search search;
	
	public Study() {}
	
	public Study(String cdCiteKey, String dsTitle, String nmAuthor, String dsAbstract, String dsKeyword, Integer nrYear,
			String dsVolume, String dsUrl, String cdIssnIsbn, String cdDoi, String dsType, String dsPage,
			String dsComment, String dsJournal, VenueEnum tpVenue, ReadingRateEnum tpReadingRate,
			StudyStatusEnum tpStatus, Search search) {
		super();
		this.cdCiteKey = cdCiteKey;
		this.dsTitle = dsTitle;
		this.nmAuthor = nmAuthor;
		this.dsAbstract = dsAbstract;
		this.dsKeyword = dsKeyword;
		this.nrYear = nrYear;
		this.dsVolume = dsVolume;
		this.dsUrl = dsUrl;
		this.cdIssnIsbn = cdIssnIsbn;
		this.cdDoi = cdDoi;
		this.dsType = dsType;
		this.dsPage = dsPage;
		this.dsComment = dsComment;
		this.dsJournal = dsJournal;
		this.tpVenue = tpVenue;
		this.tpReadingRate = tpReadingRate;
		this.tpStatus = tpStatus;
		this.search = search;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "StudySequenceGenerator")
	@Column(name = "id_study", nullable = false, unique = true)
	public Long getIdStudy() {
		return idStudy;
	}

	public void setIdStudy(Long idStudy) {
		this.idStudy = idStudy;
	}
	
	@Column(name = "cd_cite_key")
	public String getCdCiteKey() {
		return cdCiteKey;
	}

	public void setCdCiteKey(String cdCiteKey) {
		this.cdCiteKey = cdCiteKey;
	}
	
	@Column(name = "ds_title")
	public String getDsTitle() {
		return dsTitle;
	}

	public void setDsTitle(String dsTitle) {
		this.dsTitle = dsTitle;
	}

	@Column(name = "nm_author")
	public String getNmAuthor() {
		return nmAuthor;
	}

	public void setNmAuthor(String nmAuthor) {
		this.nmAuthor = nmAuthor;
	}

	@Column(name = "ds_abstract")
	public String getDsAbstract() {
		return dsAbstract;
	}

	public void setDsAbstract(String dsAbstract) {
		this.dsAbstract = dsAbstract;
	}

	@Column(name = "ds_keyword")
	public String getDsKeyword() {
		return dsKeyword;
	}

	public void setDsKeyword(String dsKeyword) {
		this.dsKeyword = dsKeyword;
	}
	
	@Column(name = "nr_year")
	public Integer getNrYear() {
		return nrYear;
	}

	public void setNrYear(Integer nrYear) {
		this.nrYear = nrYear;
	}

	@Column(name = "ds_volume")
	public String getDsVolume() {
		return dsVolume;
	}

	public void setDsVolume(String dsVolume) {
		this.dsVolume = dsVolume;
	}

	@Column(name = "ds_url")
	public String getDsUrl() {
		return dsUrl;
	}

	public void setDsUrl(String dsUrl) {
		this.dsUrl = dsUrl;
	}

	@Column(name = "cd_issn_isbn")
	public String getCdIssnIsbn() {
		return cdIssnIsbn;
	}

	public void setCdIssnIsbn(String cdIssnIsbn) {
		this.cdIssnIsbn = cdIssnIsbn;
	}

	@Column(name = "cd_doi")
	public String getCdDoi() {
		return cdDoi;
	}

	public void setCdDoi(String cdDoi) {
		this.cdDoi = cdDoi;
	}

	@Column(name = "ds_type")
	public String getDsType() {
		return dsType;
	}

	public void setDsType(String dsType) {
		this.dsType = dsType;
	}

	@Column(name = "ds_page")
	public String getDsPage() {
		return dsPage;
	}

	public void setDsPage(String dsPage) {
		this.dsPage = dsPage;
	}

	@Column(name = "ds_comment")
	public String getDsComment() {
		return dsComment;
	}

	public void setDsComment(String dsComment) {
		this.dsComment = dsComment;
	}

	@Column(name = "ds_journal")
	public String getDsJournal() {
		return dsJournal;
	}

	public void setDsJournal(String dsJournal) {
		this.dsJournal = dsJournal;
	}
	
	@Column(name = "tp_venue")
	@Enumerated(EnumType.ORDINAL)
	public VenueEnum getTpVenue() {
		return tpVenue;
	}

	public void setTpVenue(VenueEnum tpVenue) {
		this.tpVenue = tpVenue;
	}

	@Column(name = "tp_reading_rate")
	@Enumerated(EnumType.ORDINAL)
	public ReadingRateEnum getTpReadingRate() {
		return tpReadingRate;
	}

	public void setTpReadingRate(ReadingRateEnum tpReadingRate) {
		this.tpReadingRate = tpReadingRate;
	}

	@Column(name = "tp_status")
	@Enumerated(EnumType.ORDINAL)
	public StudyStatusEnum getTpStatus() {
		return tpStatus;
	}

	public void setTpStatus(StudyStatusEnum tpStatus) {
		this.tpStatus = tpStatus;
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
	@JoinColumn(name = "id_search", nullable = false)
	public Search getSearch() {
		return this.search;
	}

	public void setSearch(Search search) {
		this.search = search;
	}
}
