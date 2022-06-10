package article;

import util.Util;

/**
 * Un objet de la classe ArticleCat1 correspond à un article/produit provenant de la catégorie
 * "Electrique" vendu par l'entreprise.
 * Chaque article posséde un numéro de référence (un entier) qui permet de l'identifier,
 *      une catégorie (une chaîne de caractéres),
 *      une désignation (une chaîne de caractéres),
 *      un prix à l'unité en euros (un double),
 *      une quantité en stock (un entier),
 *      une taille de roues (un entier),
 *      des matériaux (une chaîne de caractéres),
 *      un éclairage ou non (un booléen).
 *
 * @version 05/04/22
 * @author Fontaine Nathan
 */
public class ArticleCat1 extends Article
{
    /**
     * Taille de la roue
     */
    private int tailleRoues;

    /**
     * Matérieaux utilisés pour la construction du tricycle
     */
    private String materiaux;

    /**
     * Eclairage ou non sur le tricycle
     */
    private boolean eclairage;

    /**
     * Constructeur permettant de créer un nouvel article. Son numéro de référence est généré automatiquement.
     *
     * @param categorie - La catégorie de l'article.
     * @param designation - La désignation de l'article.
     * @param prix - Le prix de l'article (si strictement infèrieur à 0.0 alors 0.0 est mis comme prix).
     * @param quantiteStock - La quantité initiale en stock de l'article (si strictement infèrieure à 0 alors 0 est mis comme quantité).
     * @param tailleRoues - La taille des roues.
     * @param materiaux - Les materiaux utilisés.
     * @param eclairage - Si le tricycle a des éclairages ou non.
     */
    public ArticleCat1(String categorie, String designation, double prix, int quantiteStock, int tailleRoues, String materiaux, boolean eclairage)
    {
        super(categorie, designation, prix, quantiteStock);
        this.tailleRoues = tailleRoues;
        this.materiaux = materiaux;
        this.eclairage = eclairage;
    }

    /**
     * Méthode qui permet de saisir les différents paramètres de la classe.
     */
    public void saisirInfos()
    {
        super.saisirInfos();
        this.tailleRoues = Util.saisirEntier(1, 10, "Veulliez entrer une taille de roue : ");
        this.materiaux = Util.saisirChaine("Veulliez entrer les materiaux : ");
        this.eclairage = Util.questionBinaire("Veulliez entrer l'éclairage (T/F) : ", "T", "F");
    }



}