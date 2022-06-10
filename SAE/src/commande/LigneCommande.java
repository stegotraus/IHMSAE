package commande;

import article.Article;
import article.Livrable;
/**
 * @version 05/04/22
 * @author Fontaine Nathan, Bourgain Wilbal Nicolas
 */
public class LigneCommande
{
    /**
     * L'article correspondant à la ligne de commande.
     */
    private Article article;

    /**
     * La quantité commandée de l'article de la ligne de commande.
     */
    private int quantite;

    /**
     * Constructeur permettant de créer une ligne de commande pour un article donné avec une quantité commandée.
     * Dans le cas où la quantité commandée est supérieure à la quantité en stock de l'article commandé,
     * la quantité affectée sera la quantité en stock de l'article commandé.
     * La quantité commandée sera retirée de la quantité en stock de l'article correspondant.
     *
     * @param article - L'article commandé (une référence non null).
     * @param quantite - La quantité commandée (un entier supérieur ou égal à 0).
     */
    public LigneCommande(Article article, int quantite)
    {
        this.article = article;
        this.quantite = quantite;
    }

    /**
     * Méthode permettant d'ajouter à la quantité commandé de l'article une quantité supplémentaire à commander.
     * Dans le cas où la quantité supplémentaire à commander est supérieure à la quantité en stock de l'article commandé,
     * la quantité à ajouter sera la quantité en stock de l'article commandé.
     * La quantité supplémentaire commandée sera retirée de la quantité en stock de l'article correspondant.
     *
     * @param quantite - La quantité supplémentaire à commander (cette quantité est supposée supérieure ou égale à 0).
     */
    public void ajouterQuantite(int quantite)
    {
        this.quantite+=quantite;
    }

    /**
     * Méthode retournant l'article de la ligne de commande.
     *
     * @return L'article de la ligne de commande.
     */
    public Article getArticle() { return article; }

    /**
     * Méthode retournant la quantité commandée.
     *
     * @return La quantité commandée.
     */
    public int getQuantite() { return quantite; }

    /**
     * Méthode retournant le montant correspondant à la ligne de commande sans livraison (la quantité commandée * le prix de l'article).
     *
     * @return Le montant correspondant à la ligne de commande.
     */
    public double getMontant()
    {
        return article.getPrix()*quantite;
    }
    /**
     * Méthode retournant le montant correspondant à la ligne de commande incluant le coùt de livraison correspondant à la ligne de commande.
     * Si l'article n'est pas un livrable le coùt de livraison est 0.0. Dans le cas contraire,
     * la méthode coutLivraison() de Livrable sera utilisée pour calculer le coùt de livraison.
     *
     * @return Le montant correspondant à la ligne de commande avec le coùt de livraison.
     */
    public double getMontantAvecLivraison()
    {
        if (article instanceof Livrable)
        {
            return getMontant() + ((Livrable) article).coutLivraison();
        }
        return getMontant();
    }

    /**
     * Méthode retournant une représentation textuelle de la ligne de commande.
     * Cette représentation contient la référence de l'article, la désignation de l'article, la quantité commandée,
     * le prix unitaire de l'article, le montant sans livraison et le montant avec livraison.
     * @return Une représentation textuelle de la ligne de commande.
     */
    @Override
    public String toString()
    {
        return quantite+" x "+article.getDesignation()+" ("+article.getPrix()+")";
    }
}