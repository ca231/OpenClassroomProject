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
		 * @param filepath : Pathname du fichier écrit en sortie de programme
		 * @param outputEnr : Liste des symptomes avec le nombre d'occurences rencontrés - C'est la résultante du traitement ChargementMap.
		 */
	}
	/**
	 * <b> Programme d'écriture du fichier résultat de l'analyse des symptoms</b>
	 * <p> Le programme se décompose comme suit :
	 * <ul>
	 * <li>filepath : 1er paramètre correspond au pathname du fichier de sortie </li>
	 * <li>outputEnr: 2ème paramètre corespond à la liste des sygmptomes retournés par le chargement dans la Map des Symptomes. Déjà formatté en </li>
	 * <li>[nom du symptome]=[nb occurences]</li>
	 * </ul>
	 * @return Fournit une chaine de caractères mentionnant le nombre d'enregistrements écrit dans le fichier de sortie
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
		 return("Traitement OK- Nombre de Symptomes référencés =  " + String.valueOf(outputEnr.size()));
	}
}




