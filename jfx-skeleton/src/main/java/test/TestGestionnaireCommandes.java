package test;

import article.Article;
import article.Stock;
import client.CarnetClients;
import client.ClientEntreprise;
import client.ClientParticulier;
import client.Genre;
import commande.EnsembleCommandes;
import gestionnaire.GestionnaireCommandes;

/**
 * Une classe contenant une méthode main permettant de tester un gestionnaire de commandes et donc de tester également la classe Commandes.
 * @author Jean-François Condotta
 * @version 17/03/22
 */
public class TestGestionnaireCommandes {
	/**
	 * Méthode permettant de tester un gestionnaire de commandes et donc de tester également la classe Commandes. Cette méthode permet de :
	 *
	 * (1) Créer un stock avec 4 articles.
	 * (2) Créer un carnet de clients avec 4 clients.
	 * (3) Créer un ensemble de commandes vide.
	 * (3) Créer et lancer le gestionnaire de commandes associé à l'ensemble de commandes, au stock et au carnet de clients crés.
	 *  
	 * @param args Auncun argument.
	 */
	public static void main(String[] args) {
		Stock stock=new Stock("Stock 2022");
		stock.ajouterArticle(new Article("Super Article",15.0,5));
		stock.ajouterArticle(new Article("Article Sympa",10.0,123));
		stock.ajouterArticle(new Article("Article Super Cool",4.0,1));
		stock.ajouterArticle(new Article("Article Génial",4.0,10));
		CarnetClients carnetClients=new CarnetClients("Carnet Clients 2022");
		carnetClients.ajouterClient(new ClientParticulier("Cure","30 rue des Tulipes, 62300 Lens, France",0,"Hector",Genre.Homme));
		carnetClients.ajouterClient(new ClientEntreprise("Peuplier and Co.","42 boulevard des Marguerites, 62300 Lens, France",10,"Francis Chêne"));
		carnetClients.ajouterClient(new ClientEntreprise("Charme and Co.","22 impasse des Lilas, 62300 Lille, France",500,"René Tilleul"));
		carnetClients.ajouterClient(new ClientParticulier("Tournesol","123 rue des narcisses, 62300 Lens, France",2000,"Jonquille",Genre.Femme));
		EnsembleCommandes ensembleCommandes=new EnsembleCommandes();
		GestionnaireCommandes gestionnaireCommandes=new GestionnaireCommandes(ensembleCommandes,carnetClients,stock);
		gestionnaireCommandes.afficherGererMenu();
	}

}
