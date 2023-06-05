package model;

import java.util.ArrayList;

public class Eleve extends Personne{
	private int groupe;
	private String filiere;
	private int numTel;
	private ArrayList<Horaire> planning;
	private ArrayList<Absence> absences;
	
	public Eleve(String nom, String prenom,int numTel,int id, String motDePasse, int groupe, String filiere){
		super(nom,prenom,id,motDePasse);
		this.numTel=numTel;
		this.groupe=groupe;
		this.filiere=filiere;
	}
	
	/*
	 * Constructeur qui ne prend pas en paramètre l'id car l'id sera affecté automatiquement par la base de données
	 */
	public Eleve(String nom, String prenom,int numTel, String motDePasse, int groupe, String filiere){
		super(nom,prenom,motDePasse);
		this.numTel=numTel;
		this.groupe=groupe;
		this.filiere=filiere;
	}
	
	public void setHoraires(ArrayList<Horaire> planning) {
		this.planning=planning;
	}
	
	public void setAbsences(ArrayList<Absence> absences) {
		this.absences=absences;
	}
	
	public void setNumTel(int numTel) {
		this.numTel=numTel;
	}
	
	public void setGroupe(int groupe) {
		this.groupe=groupe;
	}
	
	public void setFiliere(String filiere) {
		this.filiere=filiere;
	}
	
	public int getNumTel() {
		return numTel;
	}
	
	public int getGroupe() {
		return groupe;
	}
	
	public String getFiliere() {
		return filiere;
	}
	
	public ArrayList<Absence> getAbsences(){
		return absences;
	}
	
	public ArrayList<Horaire> getPlanning(){
		return planning;
	}
	
	/**
	 * @override
	 */
	public void afficher() {
		super.afficher();
		System.out.println("Groupe: "+ groupe+ "\nFiliere: "+ filiere);
	}
}
