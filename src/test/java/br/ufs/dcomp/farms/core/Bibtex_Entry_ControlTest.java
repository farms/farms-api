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


public class Bibtex_Entry_ControlTest {
	static String directory;
	static File[] files;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		directory = System.getProperty("user.dir");
		FileWriter arq1 = new FileWriter(directory+"\\Bibtextest1.bib\\");
		FileWriter arq2 = new FileWriter(directory+"\\Bibtextest2.bib\\");
		FileWriter arq3 = new FileWriter(directory+"\\Bibtextest3.bib\\");
		PrintWriter WriteArq1 = new PrintWriter(arq1);
		PrintWriter WriteArq2 = new PrintWriter(arq2);	
		WriteArq1.printf(
				"@book{Birnios:1999:MVB:555409,author = {ga{\\'u}cho},title = {na{\\\"a}ve},"
				+ "year = {2000},publisher = {{\\`e}l{\\\'e}ve},address = {a{\\c c}{\\~a}o},"
				+ "annote = {�Se\\~norita!},booktitle = {Sch{\\\"o}nbrunner},chapter = {2},"
				+ "doi = {9876},edition = {12},editor = {Schlo{\\ss}s},"
				+ "eprint = {hep-ph/9609357},howpublished = {Web Page},institution = {Stra{\\ss}e },"
				+ "journal = {{\\^a}{\\~a}{\\=a}{\\.a}{\\v a}{\\u a}\\c{c}},key = {172},month = {July},"
				+ "note = {Mais trabalho e menos divers{\\~a}o fazem de Bart um garoto melhor},number = {10},"
				+ "organization = {UFS},pages = {5-10},school = {Java},series = {FARMS},type = {app},"
				+ "url = {http://computacao.ufs.br/pagina/engenharia-computa-4536.html},volume = {10},}");
		arq1.close();
		WriteArq2.printf(
				"@book{Birnios:1999:MVB:555409,author = {ga{\\'u}cho},title = {na{\\\"a}ve},"
				+ "year = {2000},publisher = {{\\`e}l{\\\'e}ve},address = {a{\\c c}{\\~a}o},"
				+ "annote = {�Se\\~norita!},booktitle = {Sch{\\\"o}nbrunner},chapter = {2},"
				+ "doi = {9876},edition = {12},editor = {Schlo{\\ss}s},"
				+ "eprint = {hep-ph/9609357},howpublished = {Web Page},institution = {Stra{\\ss}e },"
				+ "journal = {{\\^a}{\\~a}{\\=a}{\\.a}{\\v a}{\\u a}\\c{c}},key = {172},month = {July},"
				+ "note = {Mais trabalho e menos divers{\\~a}o fazem de Bart um garoto melhor},number = {10},"
				+ "organization = {UFS},pages = {5-10},school = {Java},series = {FARMS},type = {app},"
				+ "url = {http://computacao.ufs.br/pagina/engenharia-computa-4536.html},volume = {10},}");
		arq2.close();
		arq3.close();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		files = Bibtex_Entry_Control.Bibtex_files_reader(directory);
		for (File file : files) {
            file.delete();
    }
	}

	@Test
	public void testBibtex_files_reader() {
		files=Bibtex_Entry_Control.Bibtex_files_reader(directory);
		assertTrue((!files[0].equals(null))&&(!files[1].equals(null))&&(!files[2].equals(null)));
	}

	@Test
	public void testBibtex_Map_Control() throws TokenMgrException, FileNotFoundException, ParseException {
		TreeMap<String,Bibtex_String> Entries = new TreeMap<String,Bibtex_String>();
		Bibtex_String saida = new Bibtex_String();
		files=Bibtex_Entry_Control.Bibtex_files_reader(directory);
		int i=0;
		while(true){	
			try{
				saida = Bibtex_Extraction_Control.bibtex_Extraction(files[i]);
				}
			catch(java.lang.ArrayIndexOutOfBoundsException exception){
				break;}
			catch(java.lang.NullPointerException error){
				continue;
			}
			Entries = Bibtex_Entry_Control.Bibtex_Map_Control(saida,Entries);
			i++;
			}
		assertNotNull(Entries);
	}
}
