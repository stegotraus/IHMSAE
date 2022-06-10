package test;

import article.Article;
import article.Stock;
import gestionnaire.GestionnaireStock;

/**
 * Une classe contenant une méthode main permettant de tester un gestionnaire de stock et donc de tester également la classe Stock.
 * @author Jean-François Condotta
 * @version 16/03/22
 */
public class TestGestionnaireStock {
	/**
	 * Méthode permettant de tester un gestionnaire de stock et donc de tester également la classe Stock. Cette méthode permet de :
	 *
	 * (1) Créer un stock avec 4 articles.
	 * (2) Créer un gestionnaire de stock associé avec le stock précédemment créé.
	 * (3) Lancer le gestionnaire de stock.
	 *  
	 * @param args Auncun argument.
	 */
	public static void main(String[] args) {
		Stock stock=new Stock("Stock 2022");
		stock.ajouterArticle(new Article("Super Article",15.0,5));
		stock.ajouterArticle(new Article("Article Sympa",10.0,123));
		stock.ajouterArticle(new Article("Article Super Cool",4.0,1));
		stock.ajouterArticle(new Article("Article Génial",4.0,10));
		
		GestionnaireStock gestionnaireStock=new GestionnaireStock(stock);
		gestionnaireStock.afficherGererMenu();
	}

}
