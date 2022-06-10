package commande;

import article.Article;
import client.Client;
import java.util.ArrayList;

/**
 * Un objet de la classe Commande correspond à une commande d'articles.
 * Chaque commande a un numéro de référence et contient un ensemble de lignes de commande.
 * Deux lignes de commande d'une commande ne peuvent pas être associées à un même produit.
 * Une ligne de commande d'une commande ne peut pas être associée à la quantité 0.
 * Une commande ne peut pas contenir plus de Commande.
 * MAX_LIGNES lignes de commande.
 * Une commande peut être clôturée.
 * Lors de la clôture, les points de fidélite du client concerné sont mis à jour.
 * Une fois clôturée, une commande ne peut plus être éditée/modifiée.
 *
 * @version 05/06/22
 * @author Dubusse Lucas
 */
public class Commande
{
    /**
     * Le nombre maximal de lignes de commande pouvant être dans une commande (valué à 10).
     */
    public static final int MAX_LIGNES = 10;

    /**
     * Le nombre de commande créés (sert également pour attribuer un numéro de référence). Il sera initialisé à 0.
     */
    private static int nbCommandes = 0;

    /**
     * Numéro de référence de la commande.
     */
    private int reference;

    /**
     * Les lignes de commande se trouvant dans la commande.
     */
    private ArrayList<LigneCommande> lignesCommande;

    /**
     * Le client pour qui est effectué la commande.
     */
    private Client client;

    /**
     * Booléen indiquant si la commande est clôturée.
     */
    private boolean cloturee;

    /**
     * Constructeur permettant de construire un nouvelle commande ne contenant aucune ligne de commande et associée au client passé en paramètre.
     * La commande créée est non clôturée.
     *
     * @param client - Le client associé à la commande.
     */
    public Commande(Client client)
    {
        this.client = client;
        lignesCommande = new ArrayList<LigneCommande>();
        cloturee=false;
        reference = nbCommandes;
        nbCommandes++;
    }

    /**
     * Méthode retournant si la commande est clôturée ou non.
     *
     * @return true sis et seulement si la commande est clôturée.
     */
    public boolean estPleine() { return (lignesCommande.size() == MAX_LIGNES); }

    /**
     * Méthode testant si la commande est vide (il n'y a aucune ligne dans la commande).
     *
     * @return true si et seulement si la commande est vide.
     */
    public boolean estVide() { return (lignesCommande.size()==0); }

    /**
     * Méthode retournant si la commande est clôturée ou non.
     *
     * @return true sis et seulement si la commande est clôturée.
     */
    public boolean estCloturee() { return cloturee; }

    /**
     * Méthode cherchant une ligne de commande dans la commande concernant un certaine référence d'article.
     * Dans le cas où il n'y a aucune ligne de commande correspondant à l'article, null est retourné.
     *
     * @param refArticle - Un entier supposé être une référence d'article.
     * @return La ligne de commande de la commande dont l'article a pour référence refArticle. Dans le cas où il n'y a pas une telle ligne de commande, null est retourné.
     */
    private LigneCommande chercherLigneCommande(int refArticle)
    {
        for (int i = 0; i < lignesCommande.size();i++)
        {
            if (lignesCommande.get(i).getArticle().getReference() == refArticle)
            {
                return lignesCommande.get(i);
            }
        }
        return null;
    }

    /**
     * Méthode permettant de supprimer une ligne de commande de la commande.
     * La ligne de commande à supprimer sera celle correspondant à la référence d'un article passé en paramétre.
     * Dans le cas où la commande est clôturée ou lorsqu'il n'existe pas de ligne de commande avec un article ayant la référence passée en paramétre
     * rien n'est fait et false est retourné. Dans le cas contraire, la ligne de commande est supprimée de la commande.
     * D'autre part, la quantité en stock de l'article correspondant à la ligne de commande supprimée devra étre augmentée de la quantité associée
     * à la ligne de commande. En cas de suppression effective d'une ligne de commande, true est retourné.
     *
     * @param refArticle - Un entier supposé être une référence d'article.
     * @return true si et seulement une suppression effective de la ligne de commande a étè réalisée.
     */
    public boolean supprimerLigneCommande(int refArticle)
    {
        if (estCloturee())
            return false;
        for (int x = 0; x < lignesCommande.size(); x++)
        {
            if (lignesCommande.get(x).getArticle().getReference() == refArticle)
            {
                lignesCommande.get(x).getArticle().ajouterQuantiteStock(lignesCommande.get(x).getQuantite());
                lignesCommande.remove(x);
                return true;
            }
        }
        return false;
    }

    /**
     * Méthode permettant de commander une quantité d'un certain article.
     * Si le nombre de lignes de commande maximum est atteint ou si la commande
     * est cloturee ou si la quantité donnée en paramètre vaut 0 ou si la quantité
     * en stock de l'article n'est pas suffisante alors rien est fait est false est retournée.
     * Dans le cas contraire, deux cas se présentent : (1) Il existe déjà une ligne de commande avec un article ayant même référence.
     * Dans ce cas là, on ajoute la quantité demandée à cette ligne de commande. (2) Il n'existe pas une ligne de commande avec un article ayant même référence.
     * Dans ce cas là, une nouvelle ligne de commande est créée et ajoutée à la commande.
     * Pour ces deux cas, true sera retourné et d'autre part il faut s'assurer que toute qauntité commandée soit enlevée du stock de l'article.
     *
     * @param article - L'article à commander.
     * @param quantite - La qauntité à commander.
     * @return true si et seulement si la quantité à commander a étè bien commandée (et qu'elle est différente de 0).
     */
    public boolean commander(Article article, int quantite)
    {
        if (estPleine() || estCloturee() || quantite == 0 || (article.getQuantiteStock() - quantite < 0 ))
            return false;
        LigneCommande tmp = chercherLigneCommande(article.getReference());
        if (tmp != null)
        {
            tmp.ajouterQuantite(quantite);
        }
        else
        {
            lignesCommande.add(new LigneCommande(article, quantite));
        }
        article.enleverQuantiteStock(quantite);
        return true;
    }

    /**
     * Méthode retournant le nombre de lignes de commande de la commande.
     *
     * @return Le nombre de lignes de commande de la commande.
     */
    public int getNbLignesCommande() { return lignesCommande.size(); }

    /**
     * Méthode retournant le montant total de la commande en supposant une livraison.
     *
     * @return Le montant total de la commande en supposant une livraison.
     */
    public double getMontantAvecLivraison()
    {
        double sum = 0;
        for (int i = 0;i < lignesCommande.size(); i++)
        {
            sum += lignesCommande.get(i).getMontantAvecLivraison();
        }
        return sum;
    }

    /**
     * Méthode retournant le montant total de la commande sans livraison.
     *
     * @return Le montant total de la commande en supposant sans livraison.
     */
    public double getMontant()
    {
        double sum = 0;
        for (int x = 0; x < lignesCommande.size(); x++)
        {
            sum = sum + lignesCommande.get(x).getMontant();
        }
        return sum;
    }

    /**
     * Méthode permettant la clôture de la commande. Si la commande est déjà clôturée rien est fait.
     * Dans le cas contraire, la commande est clôturée et des points de fidélité sont ajoutés au client
     * en fonction du montant avec ou sans livraison de la commande.
     * 1 point de fidélité est ajouté par tranche de 10 euros d'achat.
     *
     * @param livraison - Booléen indique si le client a opté pour une livraison à son domicile ou non.
     */
    public void cloturer(boolean livraison)
    {
        if (!estCloturee())
        {
            cloturee = true;
            if (livraison)
            {
                client.setPointsFidelite((int) (client.getPointsFidelite() + getMontantAvecLivraison() / 10));
            }
            else
            {
                client.setPointsFidelite((int) (client.getPointsFidelite() + getMontant() / 10));
            }
        }
    }

    /**
     * Méthode retournant l'article correspondant à une des lignes de commande de la commande.
     *
     * @param numLigneCommande - Un numéro de ligne de commande compris entre 0 et getNbLignesCommande()-1.
     * @return L'article correspondant à la numLigneCommande iéme ligne de commande de la commande. Si numLigneCommande n'est pas comprise entre 0 et getNbLignesCommande()-1 alors null est retournée.
     */
    public Article getArticle(int numLigneCommande)
    {
        if (numLigneCommande >= 0 && numLigneCommande < lignesCommande.size())
            return lignesCommande.get(numLigneCommande).getArticle();
        return null;
    }

    /**
     * Méthode retournant la quantité commandée correspondant à une des lignes de commande de la commande.
     *
     * @param numLigneCommande - Un numéro de ligne de commande compris entre 0 et getNbLignesCommande()-1.
     * @return La quantité correspondant à la numLigneCommande iéme ligne de commande de la commande. Si numLigneCommande n'est pas comprise entre 0 et getNbLignesCommande()-1 alors 0 est retournée.
     */
    public int getQuantite(int numLigneCommande)
    {
        if (numLigneCommande >= 0 && numLigneCommande < lignesCommande.size())
            return lignesCommande.get(numLigneCommande).getQuantite();
        return 0;
    }

    /**
     * Méthode retournant la référence de la commande.
     *
     * @return Le montant total de la commande en supposant une livraison.
     */
    public int getReference()
    {
        return reference;
    }

    /**
     * Méthode retournant une représentation textuelle d'une commande.
     * Cette représentation contient notamment :
     *          le numéro de la commande,
     *          si la commande est clôturée ou pas,
     *          les informations sur le client,
     *          sur les lignes de commande et les montants avec ou sans livraison.
     *
     * @return Une représentation textuelle d'une commande.
     */
    public String toString()
    {
        String clot = " (non clôturée)";
        if (cloturee)
            clot = " (clôturée)";
        String lignes = "";
        for (int i = 0;i < lignesCommande.size();i++){
            lignes += lignesCommande.get(i) + "\n";
        }
        return "Commande n°" + reference+ clot+
                client.toString()+
                "\nArticles commandés\n"+
                "\n"+lignes+
                "\nMontant"+
                "\nMontant sans livraison : "+getMontant()+
                "\nMontant avec livraison : "+getMontantAvecLivraison();
    }
}