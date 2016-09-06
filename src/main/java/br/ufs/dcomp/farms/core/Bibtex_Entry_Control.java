package br.ufs.dcomp.farms.core;

import java.io.File;
import java.io.FileFilter;
import java.util.TreeMap;

import br.ufs.dcomp.farms.model.entity.Bibtex_String;


public class Bibtex_Entry_Control {
	
	/*This method provide one way to extract the informations from bibtex entries and return one object containing the data of bibtex entry. */ 
	
	public static File[] Bibtex_files_reader(String directory){
		FileFilter filter = new FileFilter() {  
		    public boolean accept(File file) {  
		        return file.getName().endsWith(".bib");  
		    }  
		};  
		File dir = new File(directory);  
		File[] files = dir.listFiles(filter);
		return files;
	}
	public static TreeMap<String,Bibtex_String> Bibtex_Map_Control(Bibtex_String new_Bibtexobject,TreeMap<String,Bibtex_String> bibtex_String_Map){
		try{
	 if (bibtex_String_Map.containsKey(new_Bibtexobject.getTitle())){
			Bibtex_String redundant_object = bibtex_String_Map.remove(new_Bibtexobject.getTitle());
			redundant_object.setRedundant_entries(new_Bibtexobject);
			bibtex_String_Map.put(redundant_object.getTitle(), redundant_object);
		}else
		{
			bibtex_String_Map.put(new_Bibtexobject.getTitle(), new_Bibtexobject);
		}

 }catch (java.lang.NullPointerException error ){
	

 }
		return bibtex_String_Map;
	}   
	
}

	