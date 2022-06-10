package principal;

import article.Article;
import article.ArticleCat1;
import article.ArticleCat2;
import article.Stock;
import client.CarnetClients;
import client.ClientEntreprise;
import client.ClientParticulier;
import client.Genre;
import commande.Commande;
import commande.EnsembleCommandes;

/**
 * Le programme principal de l'application de gestion de ventes.
 * @author Fontaine Nathan, Bourgain Wilbal Nicolas
 * @version 06/04/22
 *
 */
public class GestionVentes2
{
    /**
     * Le nom de l'entreprise réalisant les ventes d'articles.
     */
    static final public String nomEntreprise="ThreeWheels";
    /**
     * Les prénoms et noms des gérants.
     */
    static final public String nomsGerants="Bourgain Wilbal Nicolas";

    /**
     * Le programme principal de l'application de gestion des ventes.
     * @param args Pas d'arguments.
     */
    public static void main(String[] args)
    {
        Stock stock=new Stock("Stock de tricycle 2022");
        stock.ajouterArticle(new Article("Super Tricycle",15.0,500));
        stock.ajouterArticle(new Article("Tricycle Sympa",50.0,123));
        stock.ajouterArticle(new Article("Tricycle Super Cool",70.0,150));
        stock.ajouterArticle(new Article("Tricycle Génial",40.0,100));
        stock.ajouterArticle(new Article("Tricycle Pas ouf",0,1000));
        stock.ajouterArticle(new Article("Tricycle Desastreux",0.1,100000));
        stock.ajouterArticle(new Article("Tricycle Doré",400.0,10));
        stock.ajouterArticle(new Article("Tricycle Argenté",200.0,20));
        stock.ajouterArticle(new Article("Tricycle Debout",40.0,100));
        stock.ajouterArticle(new Article("Tricycle Couché",40.0,100));


        stock.ajouterArticle(new ArticleCat1("Normal", "Tricycle Sympa",50.0,123, 1, "Carbonne", true));
        stock.ajouterArticle(new ArticleCat1("Normal", "Tricycle Super Cool",70.0,150, 2, "Titanium", true));
        stock.ajouterArticle(new ArticleCat1("Normal", "Tricycle Génial",40.0,100, 3, "Fibre de Carbonne", true));
        stock.ajouterArticle(new ArticleCat1("Normal", "Tricycle Pas ouf",1.0,1000, 4, "Carbonne", true));
        stock.ajouterArticle(new ArticleCat1("Normal", "Tricycle Desastreux",0.1,100000, 5, "Carbonne", true));
        stock.ajouterArticle(new ArticleCat1("Normal", "Tricycle Doré",400.0,10, 6, "Carbonne", false));
        stock.ajouterArticle(new ArticleCat1("Normal", "Tricycle Argenté",200.0,20, 7, "Fibre de Carbonne", false));
        stock.ajouterArticle(new ArticleCat1("Normal", "Tricycle Debout",40.0,100, 8, "Carbonne", false));
        stock.ajouterArticle(new ArticleCat1("Normal", "Tricycle Couché",40.0,100, 9, "Titanium", false));
        stock.ajouterArticle(new ArticleCat1("Normal", "Tricycle normal 1", 1500, 10, 10, "Carbonne", false));

        stock.ajouterArticle(new ArticleCat2("Electrique", "Super Tricycle",15.0,500, 10, 10, "Titanium", true, 10, 1, 1, 1));
        stock.ajouterArticle(new ArticleCat2("Electrique", "Tricycle Sympa",50.0,123,10, 10, "Titanium", true, 20, 2, 2, 2));
        stock.ajouterArticle(new ArticleCat2("Electrique", "Tricycle Super Cool",70.0,150, 10, 10, "Titanium", true, 30, 3, 3, 3));
        stock.ajouterArticle(new ArticleCat2("Electrique", "Tricycle Génial",40.0,100, 10, 10, "Titanium", true, 40, 4, 4, 4));
        stock.ajouterArticle(new ArticleCat2("Electrique", "Tricycle Pas ouf",1.0,1000, 1, 10, "Titanium", true, 50, 5, 5, 5));
        stock.ajouterArticle(new ArticleCat2("Electrique", "Tricycle Desastreux",0.1,100000, 1, 10, "Titanium", false, 60, 6, 6, 6));
        stock.ajouterArticle(new ArticleCat2("Electrique", "Tricycle Doré",400.0,10, 10, 10, "Titanium", false, 70, 7, 7, 7));
        stock.ajouterArticle(new ArticleCat2("Electrique", "Tricycle Argenté",200.0,20, 10, 10, "Titanium", false, 80, 8, 8, 8));
        stock.ajouterArticle(new ArticleCat2("Electrique", "Tricycle Debout",40.0,100, 5, 10, "Titanium", false, 90, 9, 9, 9));
        stock.ajouterArticle(new ArticleCat2("Electrique", "Tricycle Couché",40.0,100, 5, 10, "Titanium", false, 100, 2, 2, 2));

        CarnetClients carnetClients=new CarnetClients("Carnet Clients 2022");

        carnetClients.ajouterClient(new ClientParticulier("Bourgain Wilbal","17 rue de la failette",0,"Nicolas", Genre.HOMME));
        carnetClients.ajouterClient(new ClientParticulier("Fontainer","30 rue des Tulipes, 62300 Lens, France",10,"Nathan", Genre.HOMME));
        carnetClients.ajouterClient(new ClientParticulier("Dubusse","30 rue des Tulipes, 62300 Lens, France",20,"Lucas", Genre.HOMME));
        carnetClients.ajouterClient(new ClientParticulier("Caron","30 rue des Tulipes, 62300 Lens, France",30,"Jean", Genre.HOMME));
        carnetClients.ajouterClient(new ClientParticulier("Zywwoo","30 rue des Tulipes, 62300 Lens, France",40,"Jacki", Genre.HOMME));
        carnetClients.ajouterClient(new ClientParticulier("Jean-Charle","30 rue des Tulipes, 62300 Lens, France",50,"Michelle", Genre.FEMME));
        carnetClients.ajouterClient(new ClientParticulier("Jaqueline","30 rue des Tulipes, 62300 Lens, France",60,"Jacques", Genre.FEMME));
        carnetClients.ajouterClient(new ClientParticulier("Apex","30 rue des Tulipes, 62300 Lens, France",70,"Bernadette", Genre.FEMME));
        carnetClients.ajouterClient(new ClientParticulier("Magique","30 rue des Tulipes, 62300 Lens, France",80,"Jacki", Genre.FEMME));
        carnetClients.ajouterClient(new ClientParticulier("Duphreet","30 rue des Tulipes, 62300 Lens, France",90,"Hector", Genre.FEMME));

        carnetClients.ajouterClient(new ClientEntreprise("Peuplier and Co.","42 boulevard des Marguerites, 62300 Lens, France",100,"Francis Chêne"));
        carnetClients.ajouterClient(new ClientEntreprise("Charme and Co.","22 impasse des Lilas, 62300 Lille, France",110,"Jean Condotta"));
        carnetClients.ajouterClient(new ClientEntreprise("Zywoo and Co.","Stade de france, France",120,"Christophe Dubusse"));
        carnetClients.ajouterClient(new ClientEntreprise("Apex and Co.","1 rue des Tours, 62300 Lille, France",130,"Joseph Mie"));
        carnetClients.ajouterClient(new ClientEntreprise("Charme and Co.","2 impasse des Gitans, 62300 Lille, France",140,"Emmanuel Macron"));
        carnetClients.ajouterClient(new ClientEntreprise("Zeraotr.","3 rue des Bougres, 62300 Lille, France",150,"Charles Leclerc"));
        carnetClients.ajouterClient(new ClientEntreprise("Seerdoceh.","4 rue des Français, 62300 Lille, France",160,"Roger Decroix"));
        carnetClients.ajouterClient(new ClientEntreprise("Cororbizear.","5 impasse de la libert sansé, 62300 Lille, France",170,"Isabelle Balkany"));
        carnetClients.ajouterClient(new ClientEntreprise("Mangue poilue.","6 rue de la miséricorde, 62300 Lens, France",180,"Patrick Balkany"));
        carnetClients.ajouterClient(new ClientEntreprise("Super et toi.","7 impasse des Dieux, 62200 Boulogne sur mer, France",190,"Francois Legrand"));

        EnsembleCommandes ensembleCommandes = new EnsembleCommandes();

        Commande cmd1 = new Commande(carnetClients.clientsDansCarnet()[0]);
        cmd1.commander(stock.rechercherArticleParReference(0), 10);
        cmd1.commander(stock.rechercherArticleParReference(1), 1);
        cmd1.commander(stock.rechercherArticleParReference(2), 2);

        Commande cmd2 = new Commande(carnetClients.clientsDansCarnet()[1]);
        cmd1.commander(stock.rechercherArticleParReference(3), 30);
        cmd1.commander(stock.rechercherArticleParReference(4), 10);
        cmd1.commander(stock.rechercherArticleParReference(5), 20);

        Commande cmd3 = new Commande(carnetClients.clientsDansCarnet()[2]);
        cmd1.commander(stock.rechercherArticleParReference(6), 30);
        cmd1.commander(stock.rechercherArticleParReference(7), 10);
        cmd1.commander(stock.rechercherArticleParReference(8), 20);

        ensembleCommandes.ajouterCommande(cmd1);
        ensembleCommandes.ajouterCommande(cmd2);
        ensembleCommandes.ajouterCommande(cmd3);

        System.out.println(ensembleCommandes.toString());

        GestionnairePrincipal gestionnairePrincipal = new GestionnairePrincipal("Gestion des ventes - "+nomEntreprise+"\n"+nomsGerants,ensembleCommandes,carnetClients,stock);
        gestionnairePrincipal.afficherGererMenu();

    }
}
