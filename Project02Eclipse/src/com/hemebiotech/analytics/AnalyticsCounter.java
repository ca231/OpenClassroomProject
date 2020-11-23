package com.hemebiotech.analytics;

public class AnalyticsCounter {

	/**
	 * <b> Programme d'identification de la fr�quence des symptoms</b>
	 * <p>
	 * Le programme se d�compose comme suit :
	 * <ul>
	 * <li>Lecture du fichier Symptoms.txt</li>
	 * <li>Stockage dans une map Ligne Symptoms et nombre du nombre de fois
	 * rencontr�</li>
	 * <li>Production d'un fichier results.out avec les lignes tri�es et nombre
	 * d'occurrences dans le fichier symptoms.txt</li>
	 * </ul>
	 * 
	 * @param args :
	 *             <ul>
	 *             <li>args[0] 1er argument avec le pathname du fichier
	 *             symptoms</li>
	 *             <li>args[1] 2�me argument avec le pathname du fichier results.out
	 *             </li>
	 *             </ul>
	 * @throws Exception : S'il y a erreur dans les pathname fournis pour les fichiers entr�e
	 *           et sortie
	 * @version 1.1
	 */
	public static void main(String args[]) throws Exception {
		
		String iFilepath = "symptoms.txt";
		String oFilepath = "results.out";

		if (args.length == 0) {
			System.out.println("Veuilez fournir 2 arguments lors de l'ex�cution du programme \n");
			System.out.println("           Args1 = Pathname du fichier en entr�e");
			System.out.println("           Args2 = Pathname du fichier en Sortie");
		}
		iFilepath = args[0];
		oFilepath = args[1];

		ReadSymptomDataFromFile InputEnrs = new ReadSymptomDataFromFile(iFilepath);

		ChargementMap tabSymptoms = new ChargementMap(InputEnrs.GetSymptoms());

		WriteSymptomsDatatoFile OutputEnrs = new WriteSymptomsDatatoFile(oFilepath, tabSymptoms.GetMap());

		System.out.println(OutputEnrs.WriteResultFile());

	}
}