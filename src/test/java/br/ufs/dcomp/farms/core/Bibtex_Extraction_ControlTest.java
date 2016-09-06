package br.ufs.dcomp.farms.core;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.TreeMap;

import org.jbibtex.ParseException;
import org.jbibtex.TokenMgrException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.ufs.dcomp.farms.model.entity.Bibtex_String;


public class Bibtex_Extraction_ControlTest {
	static Bibtex_String exitObject = new Bibtex_String();
	TreeMap<String,Bibtex_String> Entries = new TreeMap<String,Bibtex_String>();
	static String directory = System.getProperty("user.dir");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		FileWriter arq1 = new FileWriter(directory+"\\Bibtextestextractioncontrol.bib\\");
		PrintWriter WriteArq1 = new PrintWriter(arq1);	
		WriteArq1.printf(
				"@book{Birnios:1999:MVB:555409,author = {ga{\\'u}cho},title = {na{\\\"a}ve},"
				+ "year = {2000},publisher = {{\\`e}l{\\\'e}ve},address = {a{\\c c}{\\~a}o},"
				+ "annote = {Se\\~norita!},booktitle = {Sch{\\\"a}nbrunner},chapter = {2},"
				+ "doi = {9876},edition = {12},editor = {Schlo{\\ss}s},"
				+ "eprint = {hep-ph/9609357},howpublished = {Web Page},institution = {Stra{\\ss}e},"
				+ "journal = {\r{a}},key = {172},month = {July},"
				+ "note = {Mais trabalho e menos divers{\\~a}o fazem de Bart um garoto melhor},number = {10},"
				+ "organization = {UFS},pages = {5-10},school = {Java},series = {FARMS},type = {app},"
				+ "url = {http://computacao.ufs.br/pagina/engenharia-computa-4536.html},volume = {10},}");
		arq1.close();
		File file = new File(directory+"\\Bibtextestextractioncontrol.bib\\");
		exitObject = Bibtex_Extraction_Control.bibtex_Extraction(file);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		File file = new File(directory+"\\Bibtextestextractioncontrol.bib\\");
		file.delete();
	}

	@Test
	public void testBibtex_Type_of_Paper() {
			assertTrue(exitObject.getType_of_paper().equals("book"));
	}

	@Test
	public void testBibtex_ADDRESS_extractor() {
		assertTrue(exitObject.getAddress().equals("acão"));
	}

	@Test
	public void testBibtex_ANNOTE_extractor() {
		assertTrue(exitObject.getAnnote().equals("Señorita!"));
	}

	@Test
	public void testBibtex_AUTHOR_extractor() {
		assertTrue(exitObject.getAuthor().equals("gaúcho"));
	}

	@Test
	public void testBibtex_BOOKTITLE_extractor() {
		assertTrue(exitObject.getBooktitle().equals("Schänbrunner"));
	}

	@Test
	public void testBibtex_CHAPTER_extractor() {
		assertTrue(exitObject.getChapter().equals("2"));
	}

	@Test
	public void testBibtex_CROSSREF_extractor() {
		assertTrue(exitObject.getCrossref().equals(""));
	}

	@Test
	public void testBibtex_DOI_extractor() {
		assertTrue(exitObject.getDoi().equals("9876"));
	}

	@Test
	public void testBibtex_EDITION_extractor() {
		assertTrue(exitObject.getEdition().equals("12"));
	}

	@Test
	public void testBibtex_EDITOR_extractor() {
		assertTrue(exitObject.getEditor().equals("Schloßs"));
	}

	@Test
	public void testBibtex_EPRINT_extractor() {
		assertTrue(exitObject.getEprint().equals("hep-ph/9609357"));
	}

	@Test
	public void testBibtex_HOWPUBLISHED_extractor() {
		assertTrue(exitObject.getHowpublished().equals("Web Page"));
	}

	@Test
	public void testBibtex_INSTITUTION_extractor() {
		assertTrue(exitObject.getInstitution().equals("Straße"));
	}

	@Test
	public void testBibtex_JOURNAL_extractor() {
		assertTrue(exitObject.getJournal().equals("å"));
	}

	@Test
	public void testBibtex_KEY_extractor() {
		assertTrue(exitObject.getKey().equals("172"));
	}

	@Test
	public void testBibtex_MONTH_extractor() {
		assertTrue(exitObject.getMonth().equals("July"));
	}

	@Test
	public void testBibtex_NOTE_extractor() {
		assertTrue(exitObject.getNote().equals("Mais trabalho e menos diversão fazem de Bart um garoto melhor"));
	}

	@Test
	public void testBibtex_NUMBER_extractor() {
		assertTrue(exitObject.getNumber().equals("10"));
	}

	@Test
	public void testBibtex_ORGANIZATION_extractor() {
		assertTrue(exitObject.getOrganization().equals("UFS"));
	}

	@Test
	public void testBibtex_PAGES_extractor() {
		assertTrue(exitObject.getPages().equals("5-10"));
	}

	@Test
	public void testBibtex_PUBLISHER_extractor() {
		assertTrue(exitObject.getPublisher().equals("élève"));
	}

	@Test
	public void testBibtex_SCHOOL_extractor() {
		assertTrue(exitObject.getSchool().equals("Java"));
	}

	@Test
	public void testBibtex_SERIES_extractor() {
		assertTrue(exitObject.getSeries().equals("FARMS"));
	}

	@Test
	public void testBibtex_TITLE_extractor() {
		assertTrue(exitObject.getTitle().equals("naïve"));
	}

	@Test
	public void testBibtex_TYPE_extractor() {
		assertTrue(exitObject.getType().equals("app"));
	}

	@Test
	public void testBibtex_URL_extractor() {
		assertTrue(exitObject.getUrl().equals("http://computacao.ufs.br/pagina/engenharia-computa-4536.html"));
	}

	@Test
	public void testBibtex_VOLUME_extractor() {
		assertTrue(exitObject.getVolume().equals("10"));
	}

	@Test
	public void testBibtex_YEAR_extractor() {
		assertTrue(exitObject.getYear().equals("2000"));
	}

	@Test
	public void testBibtex_Extraction() throws TokenMgrException, FileNotFoundException, ParseException {
		File file = new File(directory+"\\Bibtextestextractioncontrol.bib\\");
		Bibtex_String extractionobject = Bibtex_Extraction_Control.bibtex_Extraction(file);
		assertNotNull(extractionobject);

}
	}
