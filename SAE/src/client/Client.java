package client;

import util.Util;

import java.util.Arrays;

/**
 * Un objet de la classe Client correspond à un client. 
 * Chaque client a :
 * 		une référence (un entier) permettant de l'identifier, 
 * 		un nom (une chaîne de caractères), 
 * 		une adresse (une chaîne de caractères) 
 * 		et un nombre de points de fidélité (un entier).
 *
 * @version 05/04/22
 * @author Bourgain Wilbal Nicolas
 */
public abstract class Client
{
	/**
	 * Le nombre de clients créés (à initialiser avec 0).
	 */
	private static int nbClients = 0;

	/**
	 * La référence du client. Le premier client aura la référence 0, le deuxième la référence 1, le troisième la référence 2 ...
	 */
	private int reference;

	/**
	 * Le nombre de points de fidélité.
	 */
	private int pointsFidelite;

	/**
	 * Le nom du client.
	 */
	private String nom;

	/**
	 * L'adresse du client.
	 */
	private String adresse;
	
	/**
	 * Constructeur permettant d'initialiser un nouveau client avec son nom, son adresse et ses points de fidélité. 
	 * Son numéro de référence est généré automatiquement.
	 * 
	 * @param nom - Le nom du client.
	 * @param adresse - L'adresse du client.
	 * @param pointsFidelite - Les points de fidélité initiaux du client.
	 */
	protected Client(String nom, String adresse, int pointsFidelite)
	{
		this.nom = nom;
		this.adresse = adresse;
		this.pointsFidelite = pointsFidelite;
		this.reference = nbClients;
		nbClients++;
	}
	
	/**
	 * Constructeur permettant d'initialiser un nouveau client en effectuant la saisie au clavier de son nom, 
	 * son adresse et ses points de fidélité (en utilisant la méthode saisirInfos()).
	 * Son numéro de référence est généré automatiquement.
	 */
	protected Client()
	{
		saisirInfos();
		this.reference = nbClients;
		nbClients++;
	}
	
	/**
	 * Méthode permettant de saisir le nom et l'adresse du client.
	 */
	public void saisirInfos()
	{
		this.nom = Util.saisirChaine("Veullier entrez le nom du client : ");
		this.adresse = Util.saisirChaine("Veullier entrez l'adresse du client : ");
	}
	
	/**
	 * Méthode retournant le nombre de points de fidélité du client.
	 * 
	 * @return Le nombre de points de fidélité.
	 */
	public int getPointsFidelite() { return pointsFidelite; }
	
	/**
	 * Méthode retournant le numéro de référence du client.
	 * 
	 * @return Le numéro de référence.
	 */
	public int getReference() { return reference; }
	
	/**
	 * Méthode retournant le nom du client.
	 * 
	 * @return Le nom du client.
	 */
	public String getNom() { return nom; }
	
	/**
	 * Méthode retournant l'adresse du client.
	 * 
	 * @return L'adresse du client.
	 */
	public String getAdresse() { return adresse; }
	
	/**
	 * Les points de fidélité donnent droit à une ristourne sur le montant total d'une commande.
	 * Cette ristourne est calculé de la manière suivante : 
	 * 		Un client ayant entre 100 et 499 points de fidelité a droit à une ristourne de 5% sur le montant total. 
	 * 		Un client ayant entre 500 et 999 points de fidelité a droit à une ristourne de 10% sur le montant total. 
	 * 		Un client ayant 1000 points ou plus de fidelité a droit à une ristourne de 15% sur le montant total.
	 * 
	 * @return L'entier correspondant à la ristourne à laquelle a droit le client.
	 */
	public int getRistourne() 
	{
		if (pointsFidelite >= 100 && pointsFidelite < 500)
		{
			return 5;
		}
		if (pointsFidelite >= 500 && pointsFidelite < 1000)
		{
			return 10;
		}
		return 15;
	}
	
	/**
	 * Méthode retournant l'adresse du client.
	 * 
	 * @param nom - Le nouveau nom du client (doit être non null).
	 */
	public void setNom(String nom) { this.nom = nom; }
	
	/**
	 * Méthode permettant de modifier l'adresse du client.
	 * 
	 * @param adresse - La nouvelle adresse du client (doit être non null).
	 */
	public void setAdresse(String adresse) { this.adresse = adresse; }
	
	/**
	 * Méthode permettant de modifier le nombre de points de fidélité du client.
	 * 
	 * @param pointsFidelite - Le nouveau nombre de points de fidélité (supposé supérieur ou égal à 0).
	 */
	public void setPointsFidelite(int pointsFidelite) {	this.pointsFidelite = pointsFidelite; }
	
	/**
	 * Méthode permettant de tester si deux clients sont les mêmes : deux clients sont les mêmes si et seulement ils ont la même référence.
	 * 
	 * @param obj - Un objet supposé être instance de la classe Article et non null.
	 */
	public boolean equals(Object obj)
	{
		if (obj == null)
			return false;
		if (!(obj instanceof Client))
			return false;
		return ((Client)obj).getReference() == this.getReference();
	}
	
	/**
	 * Méthode permettant de trier un tableau de clients selon l'ordre alphabétique des noms des clients.
	 * 
	 * @param client - Le tableau de clients à trier.
	 */
	public static void trierTabClients(Client[] client)
	{
		for (int x = 0; x < client.length; x++)
		{
			if (client[x] != null)
			{
				for (int y = 0; y < client.length; y++)
				{
					if (client[y] != null)
					{
						if (client[x].getNom().compareTo(client[y].getNom()) < 0 || client[x].getAdresse().compareTo(client[y].getAdresse()) < 0)
						{
							Client temp = client[x];
							client[x] = client[y];
							client[y] = temp;
						}
					}
				}
			}
		}
	}
	
	/**
	 * Méthode permettant de trier un tableau de clients selon l'ordre alphabétique des noms des clients.
	 * 
	 * @param client - Le tableau de clients à trier.
	 */
	public static void afficherTabClients(Client[] client)
	{
		System.out.println("--------------------------------------------------");
		for (int x = 0; x < client.length; x++)
		{
			if (client[x] != null)
				System.out.println(client[x].toString()+"\n\n--------------------------------------------------");
		}
	}

	/**
	 * Méthode (redéfinition de toString()) retournant une représentation textuelle d'un client.
	 */
	public String toString()
	{
		return 	"\nClient" +
				"\nRéférence :          " + reference+
				"\nPoints de fidélité : " +pointsFidelite+
				"\nNom :                " +nom+
				"\nAdresse :            "+adresse;
	}
}
