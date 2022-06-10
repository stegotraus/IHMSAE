package test;

import article.Article;
import article.ArticleCat2;
import commande.LigneCommande;
import util.Util;

/**
 * Une classe contenant une méthode main permettant de tester la classe LigneCommande.
 * @author Jean-François Condotta
 * @version 17/03/22
 */
public class TestLigneCommande {
	/**
	 * Méthode permettant de tester la classe LigneCommande. Cette méthode permet de :
	 * 
	 * (1) Créer et afficher une ligne de commande à partir d'un simple article.
	 * 
	 * (2) Créer et afficher une ligne de commande à partir d'un article de type ArticleCat2 qui sera saisi.
	 * 
	 * 
	 * @param args Auncun argument.
	 */
	public static void main(String[] args) {
		
		Article article=new Article("Super Article",15.0,5);
		LigneCommande ligneCommande;
		int quantite;
		System.out.println("L'article avant la création de la ligne de commande :");
		System.out.println(article);
		System.out.println();
		quantite=Util.saisirEntierPositif("Entrez la quantité commandée : ");
		ligneCommande=new LigneCommande(article,quantite);
		System.out.println("La ligne de commande créée : ");
		System.out.println(ligneCommande);
		System.out.println();
		System.out.println("L'article après la création de la ligne de commande :");
		System.out.println(article);
		System.out.println();
		System.out.println("Saisie d'un article de type ArticleCat2 ...");
		article=new ArticleCat2();
		System.out.println("L'article avant la création de la ligne de commande :");
		System.out.println(article);
		System.out.println();
		quantite=Util.saisirEntierPositif("Entrez la quantité commandée : ");
		ligneCommande=new LigneCommande(article,quantite);
		System.out.println("La ligne de commande créée : ");
		System.out.println(ligneCommande);
		System.out.println();
		System.out.println("L'article après la création de la ligne de commande :");
		System.out.println(article);
	
	}

}
