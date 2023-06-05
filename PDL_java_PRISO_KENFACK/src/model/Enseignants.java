package model;

import java.util.ArrayList;

public class Enseignants extends Personne{
	
	private long numTel;
	private ArrayList<Horaire> planning;
	private ArrayList<Absence> absences;
	
	public Enseignants(String nom, String prenom,int numTel,int id, String motDePasse){
		super(nom,prenom,id,motDePasse);
		this.numTel=numTel;
	}
	
	/*
	 * Constructeur qui ne prend pas en paramètre l'id car l'id sera affecté automatiquement par la base de données
	 */
	public Enseignants(String nom, String prenom,long numTel, String motDePasse){
		super(nom,prenom,motDePasse);
		this.numTel=numTel;
	}
	
	public long getNumTel() {
		return numTel;
	}
	
	public void setNumTel(long numTel) {
		this.numTel=numTel;
	}
	
	public void setHoraires(ArrayList<Horaire> planning) {
		this.planning=planning;
	}
	
	public void setAbsences(ArrayList<Absence> absences) {
		this.absences=absences;
	}
	
	public ArrayList<Absence> getAbsences(){
		return absences;
	}
	
	public ArrayList<Horaire> getPlanning(){
		return planning;
	}
}
