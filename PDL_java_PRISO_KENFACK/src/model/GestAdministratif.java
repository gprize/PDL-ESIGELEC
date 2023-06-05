package model;

public class GestAdministratif extends Personne{
	public GestAdministratif(String nom, String prenom,int id, String motDePasse){
		super(nom,prenom,id,motDePasse);
	}
	
	/**
	 * Cionstructeur qui ne prend pas en parametre l'id car l'id sera attribué automatiquement par la base de données
	 * @param nom nom du gestionnaire
	 * @param prenom prenom du gestionnaire
	 * @param motDePasse motDePasse du gestionnaire
	 */
	public GestAdministratif(String nom, String prenom, String motDePasse){
		super(nom,prenom,motDePasse);
	}
}
