package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	
	private String filepath;
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	/**
	 * Lecture du fichier symptoms et construction d'une liste qui sera retournée
	 * @return c'est la liste des enregistrements lus dans le fichier qui est retournée sous forme de liste de symptomes( format string)	
	 */	
	public List<String> GetSymptoms() {
		ArrayList<String> tabEnr = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					tabEnr.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
		return tabEnr;		
	}
}