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
 *      une taille de batterie (un entier),
 *      une taille de roues (un entier),
 *      des matériaux (une chaîne de caractéres),
 *      un éclairage ou non (un booléen),
 *      un poids (un entier),
 *      une largeur (un entier),
 *      une hauteur (un entier),
 *      une profondeur (un entier).
 *
 * @version 05/04/22
 * @author Fontaine Nathan
 */
public class ArticleCat2 extends Article implements Livrable
{
    /**
     * Taille des roues
     */
    private int tailleRoues;

    /**
     * Taille de la batterie
     */
    private int tailleBatterie;

    /**
     * Matériaux utilisés pour le tricycle
     */
    private String materiaux;

    /**
    * Eclairage ou non sur le tricycle
    */
    private boolean eclairage;

    /**
    * Poids du colis
     */
    private int poids;

    /**
     * Largeur du colis
     */
    private int largeur;

    /**
     * Hauteur du colis
     */
    private int hauteur;

    /**
     * Profondeur du colis
     */
    private int profondeur;

    /**
     * Constructeur permettant de créer un nouvel article. Son numéro de référence est généré automatiquement.
     *
     * @param categorie - La catégorie de l'article.
     * @param designation - La désignation de l'article.
     * @param prix - Le prix de l'article (si strictement infèrieur à 0.0 alors 0.0 est mis comme prix).
     * @param quantiteStock - La quantité initiale en stock de l'article (si strictement infèrieure à 0 alors 0 est mis comme quantité).
     * @param tailleRoues - La taille des roues du tricycle.
     * @param materiaux - Les materiaux utilisés.
     * @param eclairage - Si le tricycle a des éclairages ou non.
     * @param poids - Le poids du colis.
     * @param largeur - La largeur du colis.
     * @param hauteur - La hauteur du colis.
     * @param profondeur - La profondeur du colis.
     * @param tailleBatterie - La taille de la batterie du tricycle.
     */
    public ArticleCat2(String categorie, String designation, double prix, int quantiteStock, int tailleRoues, int tailleBatterie, String materiaux, boolean eclairage, int poids, int largeur, int hauteur, int profondeur)
    {
        super(categorie, designation, prix, quantiteStock);
        this.tailleRoues = tailleRoues;
        this.tailleBatterie = tailleBatterie;
        this.materiaux = materiaux;
        this.eclairage = eclairage;
        this.poids = poids;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.profondeur = profondeur;
    }

    public ArticleCat2() { super(); }

    /**
     * Méthode qui permet de saisir les différents paramètres de la classe.
     */
    public void saisirInfos()
    {
        super.saisirInfos();
        this.tailleRoues = Util.saisirEntier(1, 10, "Veulliez entrer une taille de roue : ");
        this.tailleBatterie = Util.saisirEntierPositif("Veulliez entrer la taille de la batterie : ");
        this.materiaux = Util.saisirChaine("Veulliez entrer les materiaux : ");
        this.eclairage = Util.questionBinaire("Veulliez entrer l'éclairage (T/F) : ", "T", "F");
        this.poids = Util.saisirEntier(1, 999, "Veulliez entrer la masse (1 / 999kg) : ");
        this.largeur = Util.saisirEntier(1, 999, "Veulliez entrer la largeur du vélo (1 / 999cm) : ");
        this.hauteur = Util.saisirEntier(1, 999, "Veulliez entrer la hauteur du vélo (1 / 999cm) : ");
        this.profondeur = Util.saisirEntier(1, 999, "Veulliez entrer la profondeur du vélo (1 / 999cm) : ");
    }

    public int getHauteurColis() { return hauteur; }

    public int getLargeurColis() { return largeur; }

    public int getProfondeurColis() { return profondeur; }

    public double getPoidsKgColis() { return poids; }
}
