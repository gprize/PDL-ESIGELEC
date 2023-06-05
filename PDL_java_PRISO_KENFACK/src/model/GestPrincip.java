package model;

public class GestPrincip extends Personne{
	public GestPrincip(String nom, String prenom,int id, String motDePasse){
		super(nom,prenom,id,motDePasse);
	}
	
	/**
	 * Constructeur qui ne prend pas en paramètre l'id car l'id sera attribué automatiquement par la base de données
	 * @param nom nom du gestionnaire principal
	 * @param prenom prenom du gestionnaire principal
	 * @param motDePasse motDePasse du gestionnaire principal
	 */
	public GestPrincip(String nom, String prenom, String motDePasse){
		super(nom,prenom,motDePasse);
	}
}
