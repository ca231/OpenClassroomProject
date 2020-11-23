package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ChargementMap {

	private List<String> inputEnrs;

	static TreeMap<String, String> tabSymptoms = new TreeMap<String, String>();
	/**
	 * <b> Programme de  chargement de la map qui permet de calculer le nombre de fois o� un m�me symptome a �t� rencontr�</b>
	 * <p> Ce programme s'appuie sur une TreeMap afin d'avoir une liste tri�e des symptomes.</p>
	 * A chaque lecture d'un symptome, on proc�de comme suit :
	 * <ul>
	 * <li>On v�rifie si le symptome est d�j� pr�sent dans la map</li>S
	 * <li>Si ce n'est pas le cas, on l'ajoute avec un  nombre d'occurence � z�ro</li>
	 * <li>Dans tous les cas, on incr�mente le nombre d'occurences � +1 </li>
	 * <li>On passe � l'occurence suivante
	 * </ul>
	 * 
	 * @param inputEnrs : Liste reprenant tous les enregistrements du fichier symptoms.txt lus
	 * 
	 *@version 1.1
	 */
	public ChargementMap(List<String> inputEnrs)  {
		this.inputEnrs = inputEnrs;
		this.tabSymptoms = tabSymptoms;
	}

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