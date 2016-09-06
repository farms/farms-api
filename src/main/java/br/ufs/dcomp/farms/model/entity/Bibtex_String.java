package br.ufs.dcomp.farms.model.entity;

import java.util.TreeMap;


public class Bibtex_String {
	
//type of paper extracted from bibtex entry.
	
private String type_of_entry;

//General data extracted from bibtex entry.

private String address;
private String annote;
private String author;
private String booktitle;
private String chapter;
private String crossref;
private String doi;
private String edition;
private String editor;
private String eprint;
private String howpublished;
private String institution;
private String journal;
private String key;
private String month;
private String note;
private String number;
private String organization;
private String pages;
private String publisher;
private String school;
private String series;
private String sumary;
private String title;
private String type;
private String url;
private String volume;
private String year;

//When the entry is redundant this field is not NULL and can be representing more than one object duplicated
TreeMap <String,Bibtex_String> redundant_entries;

public Bibtex_String() {
	this.redundant_entries =  new TreeMap<String,Bibtex_String>();
}

public TreeMap<String, Bibtex_String> getRedundant_entries() {
	return redundant_entries;
}
public void setRedundant_entries(Bibtex_String entry) {
	 this.redundant_entries.put(entry.getTitle(),entry);
}

public String getType_of_paper() {
	return type_of_entry;
}
public void setType_of_paper(String type_of_paper) {
	this.type_of_entry = type_of_paper;
}
public String getAddress() {
	return this.address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getAnnote() {
	return this.annote;
}
public void setAnnote(String annote) {
	this.annote = annote;
}
public String getAuthor() {
	return this.author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getBooktitle() {
	return this.booktitle;
}
public void setBooktitle(String booktitle) {
	this.booktitle = booktitle;
}
public String getChapter() {
	return this.chapter;
}
public void setChapter(String chapter) {
	this.chapter = chapter;
}
public String getCrossref() {
	return this.crossref;
}
public void setCrossref(String crossref) {
	this.crossref = crossref;
}
public String getDoi() {
	return this.doi;
}
public void setDoi(String doi) {
	this.doi = doi;
}
public String getEdition() {
	return this.edition;
}
public void setEdition(String edition) {
	this.edition = edition;
}
public String getEditor() {
	return this.editor;
}
public void setEditor(String editor) {
	this.editor = editor;
}
public String getEprint() {
	return this.eprint;
}
public void setEprint(String eprint) {
	this.eprint = eprint;
}
public String getHowpublished() {
	return this.howpublished;
}
public void setHowpublished(String howpublished) {
	this.howpublished = howpublished;
}
public String getInstitution() {
	return this.institution;
}
public void setInstitution(String institution) {
	this.institution = institution;
}
public String getJournal() {
	return this.journal;
}
public void setJournal(String journal) {
	this.journal = journal;
}
public String getKey() {
	return this.key;
}
public void setKey(String key) {
	this.key = key;
}
public String getMonth() {
	return this.month;
}
public void setMonth(String month) {
	this.month = month;
}
public String getNote() {
	return this.note;
}
public void setNote(String note) {
	this.note = note;
}
public String getNumber() {
	return this.number;
}
public void setNumber(String number) {
	this.number = number;
}
public String getOrganization() {
	return this.organization;
}
public void setOrganization(String organization) {
	this.organization = organization;
}
public String getPages() {
	return this.pages;
}
public void setPages(String pages) {
	this.pages = pages;
}
public String getPublisher() {
	return this.publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public String getSchool() {
	return this.school;
}
public void setSchool(String school) {
	this.school = school;
}
public String getSeries() {
	return this.series;
}
public void setSeries(String series) {
	this.series = series;
}
public String getSumary() {
	return sumary;
}

public void setSumary(String sumary) {
	this.sumary = sumary;
}
public String getTitle() {
	return this.title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getType() {
	return this.type;
}
public void setType(String type) {
	this.type = type;
}
public String getUrl() {
	return this.url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getVolume() {
	return this.volume;
}
public void setVolume(String volume) {
	this.volume = volume;
}
public String getYear() {
	return this.year;
}
public void setYear(String year) {
	this.year = year;
}

}
