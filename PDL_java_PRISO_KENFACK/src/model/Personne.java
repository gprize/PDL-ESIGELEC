package model;

/**
 * Classe décrivant un utilisateur
 * @author ngomp+gabriss
 * @version 1.0
 */
public abstract class Personne {
	protected String nom;
	protected String prenom;
	protected int id;
	protected String motDePasse;
	
	
	public Personne(String nom,String prenom,int id,String motDePasse) {
		this.nom=nom;
		this.prenom=prenom;
		this.id=id;
		this.motDePasse=motDePasse;
	}
	
	/*
	 * Constructeur qui ne prend pas en paramètre l'id car l'id sera affecté automatiquement par la base de données
	 */
	public Personne(String nom,String prenom,String motDePasse) {
		this.nom=nom;
		this.prenom=prenom;
		this.motDePasse=motDePasse;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public int getId() {
		return id;
	}
	
	public String getMotDePasse() {
		return motDePasse;
	}
	
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom=prenom;
	}
	
	public void setId(int id ) {
		this.id=id;
	}
	
	public void setMotDePasse(String motDePasse) {
		this.motDePasse=motDePasse;
	}
	
	public void afficher() {
		System.out.println("Nom: "+nom +"\nPrenom: "+prenom +"\nID: "+ id+"\nMot de passe: "+ motDePasse);
	}
}
