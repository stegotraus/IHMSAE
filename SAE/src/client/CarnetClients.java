package client;

/**
 * Un objet de la classe CarnetClients correspond à un carnet de clients.
 * Chaque carnet de clients a un nom ("Carnet Clients 2022" par exemple) et permet de gérer un ensemble de clients.
 * Un carnet de clients ne peut pas contenir plus de CarnetClients.MAX_CLIENTS clients.
 *
 * @version 05/04/22
 * @author Bourgain Wilbal Nicolas
 */
public class CarnetClients
{
	/**
	 * Le nombre maximal de clients pouvant être dans un carnet (valué à 10).
	 */
	private final int MAX_CLIENTS = 25;

	/**
	 * Les clients se trouvant dans le carnet.
	 */
	private Client[] clients;

	/**
	 * Le nombre de clients dans le carnet.
	 */
	private int nbClients;

	/**
	 * Le nom du carnet de clients.
	 */
	private String nom;
	
	/**
	 * Constructeur permettant de construire un nouveau carnet de clients.
	 * 
	 * @param nom - Le nom du carnet de clients.
	 */
	public CarnetClients(String nom)
	{
		this.nom = nom;
		this.nbClients = 0;
		this.clients = new Client[MAX_CLIENTS];
	}
	
	/**
	 * Méthode testant si le carnet est vide.
	 * 
	 * @return true si et seulement si le carnet de clients est vide.
	 */
	public boolean estVide() { return nbClients == 0; }
	
	/**
	 * Méthode testant si le carnet est plein.
	 * 
	 * @return true si et seulement si le carnet de clients est plein.
	 */
	public boolean estPlein() { return nbClients == MAX_CLIENTS; }
	
	/**
	 * Méthode cherchant un client dans le tableau clients correspondant (ayant même référence) au client passé en paramètre.
	 * 
	 * @param client - Un client (supposé non null).
	 * @return L'indice où se trouve ce client dans le tableau clients. Dans le cas où le client n'est pas présent -1 est retourné.
	 */
	private int chercherIndiceClient(Client client)
	{
		if (estVide())
			return -1;
		for (int x = 0; x < nbClients; x++)
		{
			if (this.clients[x].equals(client))
				return x;
		}
		return -1;
	}
	
	/**
	 * Méthode permettant d'ajouter un client dans le carnet.
	 * Dans le cas où le carnet est plein ou bien le client est déjà présent dans le carnet, rien est fait.
	 * Dans le cas contraire le client est inséré dans le carnet.
	 * 
	 * @param client - Un client (supposé non null).
	 */
	public void ajouterClient(Client client)
	{
		if (estPlein())
			return;
		if (chercherIndiceClient(client) != -1)
			return;
		this.clients[nbClients] = client;
		nbClients++;
	}
	
	/**
	 * Méthode permettant de supprimer un client du carnet. Rien est fait dans le cas où le client n'est pas présent dans le carnet.
	 * 
	 * @param client - Un client (supposé non null).
	 */
	public void supprimerClient(Client client)
	{
		int index = chercherIndiceClient(client);
		if (index == -1)
			return;
		this.clients[index] = null;
		for (int x = index; x < nbClients - 1; x++)
		{
			this.clients[x] = this.clients[x + 1];
			this.clients[x + 1] = null;
		}
		nbClients--;
	}
	
	/**
	 * Méthode permettant de chercher un client dans le carnet avec son numéro de référence.
	 * 
	 * @param refClient - La référence du client recherché.
	 * @return Le client dans le carnet ayant refClient comme référence ou null si un tel client n'existe pas.
	 */
	public Client rechercherClientParReference(int refClient)
	{
		if (estVide())
			return null;
		for (int x = 0; x < nbClients; x++)
		{
			if (clients[x].getReference() == refClient)
			{
				return clients[x];
			}
		}
		return null;
	}
	
	/**
	 * Méthode retournant un nouveau tableau contenant les clients du carnet. Le tableau retourné a pour taille getNbClients().
	 * 
	 * @return Un nouveau tableau non null contenant les clients du carnet.
	 */
	public Client[] clientsDansCarnet()
	{
		Client[] clientsTab = new Client[nbClients];

		for (int x = 0; x < nbClients; x++)
		{
			clientsTab[x] = clients[x];
		}
		return clientsTab;
	}
	
	/**
	 * Méthode retournant un nouveau tableau contenant les clients de type particulier du carnet.
	 * 
	 * @return Un nouveau tableau non null contenant les clients de type particulier du carnet.
	 */
	public Client[] clientsParticulierDansCarnet()
	{
		if (estVide())
			return null;
		Client[] clientParticulier = new Client[nbClients];
		for (int x = 0; x < nbClients; x++)
		{
			if (clients[x] instanceof ClientParticulier)
			{
				clientParticulier[x] = clients[x];
			}
		}
		return clientParticulier;
	}
	
	/**
	 * Méthode retournant un nouveau tableau contenant les clients de type entreprise du carnet.
	 * 
	 * @return Un nouveau tableau non null contenant les clients de type entreprise du carnet.
	 */
	public Client[] clientsEntrepriseDansCarnet()
	{
		if (estVide())
			return null;
		Client[] clientEntreprise = new Client[nbClients];
		for (int x = 0; x < nbClients; x++)
		{
			if (clients[x] instanceof ClientEntreprise)
			{
				clientEntreprise[x] = clients[x];
			}
		}
		return clientEntreprise;
	}
	
	/**
	 * Méthode permettant de chercher des clients se trouvant dans le carnet à l'aide d'un mot clé.
	 * Les clients sélectionnés sont ceux dont le nom ou l'adresse contient le mot clé spécifié.
	 * La sélection tient compte de la casse.
	 * La méthode retourne un tableau de clients (toujours non null et pouvant contenir aucun élément si aucun client a étè sélectionné).
	 * 
	 * @param motCle - Le mot clé cherché dans les noms et les adresses.
	 * @return Un tableau contenant les clients trouvés dans le carnet dont l'adresse ou le nom contient le motCle.
	 */
	public Client[] rechercherClientsParMotCle(String motCle)
	{
		Client[] temp = new Client[nbClients];
		for (int x = 0; x < nbClients; x++)
		{
			if (clients[x].getNom().contains(motCle) || clients[x].getAdresse().contains(motCle))
			{
				temp[x] = clients[x];
			}
		}
		for (int x = 0; x < nbClients; x++)
		{
			if (temp[x] != null)
			{
				return temp;
			}
		}
		return new Client[0];
	}
	
	/**
	 * Méthode retournant le nom du carnet de clients.
	 * 
	 * @return Le nom du carnet de clients.
	 */
	public String getNom() { return nom; }
	
	/**
	 * Méthode permettant de modifier le nom du carnet de clients.
	 * 
	 * @param nom - Le nouveau nom du carnet.
	 */
	public void setNom(String nom) { this.nom = nom; }
	
	/**
	 * Méthode retournant le nombre de clients du carnet.
	 * 
	 * @return Le nombre de clients dans le carnet.
	 */
	public int getNbClients() { return nbClients; }
}
