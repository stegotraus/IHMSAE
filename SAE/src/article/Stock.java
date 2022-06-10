package article;

/**
 * Un objet de la classe Stock correspond à un stock d'articles.
 * Chaque stock a un nom ("Stock 2022" par exemple) et permet de gérer le stock d'un ensemble d'articles.
 * Un stock ne peut pas contenir plus de Stock.MAX_ARTICLES articles.
 *
 * @version 05/04/22
 * @author Fontaine Nathan, Bourgain Wilbal Nicolas
 */
public class Stock 
{
	/**
	 * Le nombre maximal d'articles pouvant être dans un stock (valué à 10).
	 */
	public static final int MAX_ARTICLES = 10;

	/**
	 * Les articles se trouvant dans le stock. Il sera initialisé avec un tableau pouvant contenir MAX_ARTICLES articles.
	 */
    private Article[] articles;

	/**
	 * Le nombre d'articles dans le stock. Les articles sont toujours placés en début du tableau articles.
	 */
    private int nbArticles;

	/**
	 * Le nom du stock.
	 */
    private String nom;

    /**
     * Constructeur permettant de construire un nouveau stock.
     * 
     * @param nom - Le nom du stock.
     */
    public Stock(String nom)
    {
        this.articles = new Article[MAX_ARTICLES];
        this.nbArticles = 0;
        this.nom = nom;
    }

    /**
     * Méthode testant si le stock est plein (si on ne peut pas ajouter de nouveaux articles).
     * 
     * @return true si et seulement si le stock est plein.
     */
    public boolean estPlein() { return nbArticles == MAX_ARTICLES; }

    /**
     * Méthode testant si le stock est vide (il n'y a aucun article dans le stock, i.e. nbArticles vaut 0).
     * 
     * @return true si et seulement si le stock est vide.
     */
    public boolean estVide() { return nbArticles == 0; }

    /**
     * Méthode cherchant un article dans le tableau articles correspondant (ayant même référence) à l'article passé en paramètre.
     * 
     * @param article - Un article (supposé non null).
     * @return L'indice où se trouve cet article dans le tableau articles. Dans le cas où l'article n'est pas présent -1 est retourné.
     */
    public int chercherIndiceArticle(Article article)
    {
    	if (estVide())
    		return -1;
    	for (int x = 0; x < nbArticles; x++)
    	{
    		if (article.getReference() == articles[x].getReference())
    		{
    			return x;
    		}
    	}
    	return -1;
    }

    /**
     * Méthode permettant d'ajouter un article dans le stock.
     * Dans le cas où le stock est plein ou bien l'article est déjà présent dans le stock, rien est fait.
     * Dans le cas contraire l'article est inséré dans le stock.
     * 
     * @param article - Un article (supposé non null).
     */
    public void ajouterArticle(Article article)
    {
    	if (estPlein())
    		return;
    	if (chercherIndiceArticle(article) != -1)
    		return;
    	articles[nbArticles] = article;
    	nbArticles++;
    }

    /**
     * Méthode permettant de supprimer un article du stock. Rien est fait dans le cas où l'article n'est pas présent dans le stock.
     * 
     * @param article - Un article (supposé non null).
     */
    public void supprimerArticle(Article article)
    {
    	int index = chercherIndiceArticle(article);
    	if (index == -1)
    		return;
    	this.articles[index] = null;
    	for (int x = index; x < nbArticles - 1; x++)
    	{
    		this.articles[x] = this.articles[x + 1];
    		this.articles[x + 1] = null;
    	}
    	nbArticles--;
    }

    /**
     * Méthode permettant de chercher un article dans le stock avec son numéro de référence.
     * 
     * @param refArticle - La référence de l'article recherché.
     * @return L'article dans le stock ayant refArticle comme référence ou null si un tel article n'existe pas.
     */
    public Article rechercherArticleParReference(int refArticle)
    {
    	if (estVide())
			return null;
    	for (int x = 0; x < nbArticles; x++)
		{
			if (articles[x].getReference() == refArticle)
			{
				return articles[x];
			}
		}
		return null;
    }

    /**
     * Méthode retournant un nouveau tableau contenant les articles du stock. Le tableau retourné a pour taille getNbArticles().
     * 
     * @return Un nouveau tableau non null contenant les articles du stock.
     */
    public Article[] articlesDansStock()
    {
    	Article[] articlesTab = new Article[nbArticles];

		for (int x = 0; x < nbArticles; x++)
		{
			articlesTab[x] = articles[x];
		}
		return articlesTab;
    }

    /**
     * Méthode permettant de chercher les articles du stock d'une certaine catégorie.
     * La méthode retourne un tableau d'articles (toujours non null et pouvant contenir aucun élèment si aucun article a étè sélectionné).
     * 
     * @param categorie - La catégorie pour laquelle nous souhaitons les articles.
     * @return Un tableau contenant les articles trouvés dans le stock avec la catégorie passée en paramètre.
     */
    public Article[] rechercherArticlesCategorie(String categorie)
    {
    	Article[] articleTrouves = new Article[nbArticles];
    	
    	for (int x = 0; x < nbArticles; x++)
    	{
    		if (articles[x].getCategorie().equals(categorie))
    		{
    			articleTrouves[x] = articles[x];
    		}
    	}
    	return articleTrouves;
    }
    
    /**
     * Méthode retournant le nom du stock.
     * 
     * @return Le nom du stock.
     */
    public String getNom() { return nom; }

    /**
     * Méthode permettant de modifier le nom du stock.
     * 
     * @param nom - Le nouveau nom du stock. 
     */
    public void setNom(String nom) { this.nom = nom; }
    
    /**
     * Méthode retournant le nombre d'articles du stock.
     * 
     * @return Le nombre d'articles du stock.
     */
    public int getNbArticles() { return nbArticles; }
}
