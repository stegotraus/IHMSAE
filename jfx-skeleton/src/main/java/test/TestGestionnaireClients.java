package test;

import client.CarnetClients;
import client.ClientEntreprise;
import client.ClientParticulier;
import client.Genre;
import gestionnaire.GestionnaireClients;

/**
 * Une classe contenant une méthode main permettant de tester un gestionnaire de carnet de clients et donc de tester la classe CarnetClients.
 * @author Jean-François Condotta
 * @version 15/03/22
 */
public class TestGestionnaireClients {
	/**
	 * Méthode permettant de tester un gestionnaire de carnet de clients et donc de tester également un carnet de clients en :
	 *
	 * (1) Créer un carnet de clients avec 4 clients.
	 * (2) Créer un gestionnaire de carnet de clients associé avec le carnet de clients précédemment créé.
	 * (3) Lancer le gestionnaire de carnet de clients.
	 *  
	 * @param args Auncun argument.
	 */
	public static void main(String[] args) {
		CarnetClients carnetClients=new CarnetClients("Carnet Clients 2022");
		carnetClients.ajouterClient(new ClientParticulier("Cure","30 rue des Tulipes, 62000 Lens, France",0,"Hector",Genre.Homme));
		carnetClients.ajouterClient(new ClientEntreprise("Peuplier and Co.","42 boulevard des Marguerites, 62000 Lens, France",10,"Francis Chêne"));
		carnetClients.ajouterClient(new ClientEntreprise("Charme and Co.","22 impasse des Lilas, 62000 Lille, France",500,"René Tilleul"));
		carnetClients.ajouterClient(new ClientParticulier("Tournesol","123 rue des narcisses, 62000 Lens, France",2000,"Jonquille",Genre.Femme));
		
		GestionnaireClients gestionnaireClients=new GestionnaireClients(carnetClients);
		gestionnaireClients.afficherGererMenu();
	}

}
