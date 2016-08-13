package br.ufs.dcomp.farms.core;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Map;

import org.jbibtex.ParseException;
import org.jbibtex.TokenMgrException;

import br.ufs.dcomp.farms.model.entity.Bibtex_String;


public class Bibtex_Extraction_Control {
	
	public static String Bibtex_Type_of_Paper(org.jbibtex.BibTeXEntry entry) throws ParseException{
		org.jbibtex.LaTeXParser latexParser = new org.jbibtex.LaTeXParser();
		org.jbibtex.LaTeXPrinter latexPrinter = new org.jbibtex.LaTeXPrinter();
		return latexPrinter.print(latexParser.parse(entry.getType().toString()));
	}
	public static String Bibtex_ADDRESS_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
		return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_ADDRESS);
	}
	private static String extractBibtex(Collection<org.jbibtex.BibTeXEntry> entries, org.jbibtex.Key key) {
		String string = "";
		try{
		org.jbibtex.LaTeXParser latexParser = new org.jbibtex.LaTeXParser();
		org.jbibtex.LaTeXPrinter latexPrinter = new org.jbibtex.LaTeXPrinter();
		
		for (org.jbibtex.BibTeXEntry entry : entries) {
			org.jbibtex.Value value = entry.getField(key);
				if(value == null){
					continue;}
				string = value.toUserString();
				string = latexPrinter.print(latexParser.parse(string));

	}
		}catch(org.jbibtex.ParseException exeption){
			string = "Invalid characters were detected" ;
		} 
		return string;
	}
	
	public static String Bibtex_ANNOTE_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
		return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_ANNOTE);
	}
	public static String Bibtex_AUTHOR_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{

		return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_AUTHOR);
	}
	public static String Bibtex_BOOKTITLE_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
		return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_BOOKTITLE);
	}
	public static String Bibtex_CHAPTER_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
			return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_CHAPTER);
	}
	public static String Bibtex_CROSSREF_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
		
		return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_CROSSREF);
	}
	public static String Bibtex_DOI_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
		return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_DOI);
	}
	public static String Bibtex_EDITION_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
		
		return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_EDITION);
	}
	public static String Bibtex_EDITOR_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
		
		return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_EDITOR);
	}
	public static String Bibtex_EPRINT_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
		
		return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_EPRINT);
	}
	public static String Bibtex_HOWPUBLISHED_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
		
		return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_HOWPUBLISHED);
	}
	public static String Bibtex_INSTITUTION_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
				return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_INSTITUTION);
	}
	public static String Bibtex_JOURNAL_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
		return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_JOURNAL);
	}
	public static String Bibtex_KEY_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
			return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_KEY);
	}
	public static String Bibtex_MONTH_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
			return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_MONTH);
	}
	public static String Bibtex_NOTE_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
			return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_NOTE);
	}
	public static String Bibtex_NUMBER_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
			return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_NUMBER);
	}
	public static String Bibtex_ORGANIZATION_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
			return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_ORGANIZATION);
	}
	public static String Bibtex_PAGES_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
			return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_PAGES);
	}
	public static String Bibtex_PUBLISHER_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
			return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_PUBLISHER);
	}
	public static String Bibtex_SCHOOL_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
			return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_SCHOOL);
	}
	public static String Bibtex_SERIES_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
			return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_SERIES);
	}
	public static String Bibtex_TITLE_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
			return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_TITLE);
	}
	public static String Bibtex_TYPE_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
	
		return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_TYPE);
	}
	public static String Bibtex_URL_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
			return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_URL);	
	}
	public static String Bibtex_VOLUME_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
			return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_VOLUME);
	}
	public static String Bibtex_YEAR_extractor (Collection<org.jbibtex.BibTeXEntry> entries) throws ParseException{
			return extractBibtex(entries, org.jbibtex.BibTeXEntry.KEY_YEAR);
	}
		
	public static Bibtex_String bibtex_Extraction(File file) throws TokenMgrException, ParseException, FileNotFoundException{
		Bibtex_String exit_object = new Bibtex_String();
		
		org.jbibtex.BibTeXParser bibtexParser = new org.jbibtex.BibTeXParser();
		Reader reader = new FileReader(file);

		org.jbibtex.CharacterFilterReader filterReader = new org.jbibtex.CharacterFilterReader(reader);
		org.jbibtex.BibTeXDatabase database = bibtexParser.parseFully(filterReader);
		Map<org.jbibtex.Key, org.jbibtex.BibTeXEntry> entryMap = database.getEntries();
		Collection<org.jbibtex.BibTeXEntry> entries = entryMap.values();
		
		for (org.jbibtex.BibTeXEntry entry : entries) {
				exit_object.setAuthor(Bibtex_AUTHOR_extractor(entries));
				exit_object.setAddress(Bibtex_ADDRESS_extractor(entries));
				exit_object.setAnnote(Bibtex_ANNOTE_extractor(entries));
				exit_object.setBooktitle(Bibtex_BOOKTITLE_extractor(entries));
				exit_object.setChapter(Bibtex_CHAPTER_extractor(entries));
				exit_object.setCrossref(Bibtex_CROSSREF_extractor(entries));
				exit_object.setDoi(Bibtex_DOI_extractor(entries));
				exit_object.setEdition(Bibtex_EDITION_extractor(entries));
				exit_object.setEditor(Bibtex_EDITOR_extractor(entries));
				exit_object.setEprint(Bibtex_EPRINT_extractor(entries));
				exit_object.setHowpublished(Bibtex_HOWPUBLISHED_extractor(entries));
				exit_object.setInstitution(Bibtex_INSTITUTION_extractor(entries));
				exit_object.setJournal(Bibtex_JOURNAL_extractor(entries));
				exit_object.setKey(Bibtex_KEY_extractor(entries));
				exit_object.setMonth(Bibtex_MONTH_extractor(entries));	
				exit_object.setNote(Bibtex_NOTE_extractor(entries));
				exit_object.setNumber(Bibtex_NUMBER_extractor(entries));
				exit_object.setOrganization(Bibtex_ORGANIZATION_extractor(entries));
				exit_object.setPages(Bibtex_PAGES_extractor(entries));
				exit_object.setPublisher(Bibtex_PUBLISHER_extractor(entries));
				exit_object.setSchool(Bibtex_SCHOOL_extractor(entries));
				exit_object.setSeries(Bibtex_SERIES_extractor(entries));
				exit_object.setTitle(Bibtex_TITLE_extractor(entries));
				exit_object.setType(Bibtex_TYPE_extractor(entries));
				exit_object.setUrl(Bibtex_URL_extractor(entries));
				exit_object.setVolume(Bibtex_VOLUME_extractor(entries));
				exit_object.setYear(Bibtex_YEAR_extractor(entries));
				exit_object.setType_of_paper(Bibtex_Type_of_Paper(entry));
	}
	
		return exit_object;
		}
}
