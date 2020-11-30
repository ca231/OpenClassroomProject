package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ChargementMap {

	private List<String> inputEnrs;

	static TreeMap<String, String> tabSymptoms = new TreeMap<String, String>();
	/**
	 * @param inputEnrs : Liste reprenant tous les enregistrements du fichier symptoms.txt lus
	 * 
	 *@version 1.1
	 */
	public ChargementMap(List<String> inputEnrs)  {
		this.inputEnrs = inputEnrs;
		this.tabSymptoms = tabSymptoms;
	}
	/**
	 * <b> Programme de  chargement de la map qui permet de calculer le nombre de fois où un même symptome a été rencontré</b>
	 * <p> Ce programme s'appuie sur une TreeMap afin d'avoir une liste triée des symptomes.</p>
	 * <p>A chaque lecture d'un symptome, on procède comme suit : </p>
	 * <ul>
	 * <li>On vérifie si le symptome est déjà présent dans la map</li>
	 * <li>Si ce n'est pas le cas, on l'ajoute avec un  nombre d'occurence à zéro</li>
	 * <li>Dans tous les cas, on incrémente le nombre d'occurences à +1 </li>
	 * <li>On passe à l'occurence suivante
	 * </ul>
	 * @return Liste des symptomes avec leur occurrence formatté sous le format : [nom Symptome]=[nombre occurences du symptome]
	 * 
	 */

	public List<String> GetMap() {

		for (String line : inputEnrs) {
			if (!tabSymptoms.containsKey(line)) {
				tabSymptoms.put(line, "0");
			}
			int nb;
			nb = Integer.parseInt(tabSymptoms.get(line)) + 1;
			tabSymptoms.put(line, String.valueOf(nb));
		}
		
		String enrOutput;
		ArrayList<String> resultat = new ArrayList();
	    for (Map.Entry<String, String> elem : tabSymptoms.entrySet()) {
	    	enrOutput = elem.getKey() + "=" + elem.getValue();
			resultat.add(enrOutput);	
		}
		return resultat;      
    } 
}