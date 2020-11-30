package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteSymptomsDatatoFile {

	private String filepath;
	private List<String> outputEnr;

	
	public WriteSymptomsDatatoFile(String filepath, List<String> outputEnr) {
		this.filepath = filepath;
		this.outputEnr = outputEnr;
		/**
		 * @param filepath : Pathname du fichier �crit en sortie de programme
		 * @param outputEnr : Liste des symptomes avec le nombre d'occurences rencontr�s - C'est la r�sultante du traitement ChargementMap.
		 */
	}
	/**
	 * <b> Programme d'�criture du fichier r�sultat de l'analyse des symptoms</b>
	 * <p> Le programme se d�compose comme suit :
	 * <ul>
	 * <li>filepath : 1er param�tre correspond au pathname du fichier de sortie </li>
	 * <li>outputEnr: 2�me param�tre corespond � la liste des sygmptomes retourn�s par le chargement dans la Map des Symptomes. D�j� formatt� en </li>
	 * <li>[nom du symptome]=[nb occurences]</li>
	 * </ul>
	 * @return Fournit une chaine de caract�res mentionnant le nombre d'enregistrements �crit dans le fichier de sortie
	 */

	public String WriteResultFile() {

		if (filepath != null) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
				for (String elem : outputEnr) {				
					writer.write(elem);
					writer.newLine();
					}		
				writer.close();
				

			} catch (IOException e) {
				e.printStackTrace();
				return("KO");
			}
		}
		 return("Traitement OK- Nombre de Symptomes r�f�renc�s =  " + String.valueOf(outputEnr.size()));
	}
}




