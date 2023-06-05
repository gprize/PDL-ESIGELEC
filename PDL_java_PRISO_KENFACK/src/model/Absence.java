package model;

/**
 * 
 * @author ngomp+gabriss
 *
 */
public abstract class Absence {
	
	private String motif;
	private int typeAbsence;
	private boolean estJustifiee;
	private int idHoraire;
	private boolean estHorsQuota;
	
	/**
	 * Contructor 
	 * @param motif motif de l'absence
	 * @param typeAbsence 
	 * @param idHoraire 
	 */
	public Absence(String motif, int typeAbsence, int idHoraire) {
		this.motif=motif;
		this.typeAbsence=typeAbsence;
		this.idHoraire=idHoraire;
		estJustifiee=false;
		estHorsQuota=false;
	}
	
	/**
	 * Contructor 
	 * @param motif
	 * @param typeAbsence
	 * @param idHoraire
	 * @param estJustifiee
	 * @param estHorsQuota
	 */
	public Absence(String motif, int typeAbsence, int idHoraire, boolean estJustifiee, boolean estHorsQuota) {
		this.motif=motif;
		this.typeAbsence=typeAbsence;
		this.idHoraire=idHoraire;
		this.estJustifiee=estJustifiee;
		this.estHorsQuota=estJustifiee;
	}
	
	public String getMotif() {
		return motif;
	}
	
	public int getTypeAbsence() {
		return typeAbsence;
	}
	
	public int getIDHoraire() {
		return idHoraire;
	}
	
	public boolean getEsValidee() {
		return estJustifiee;
	}
	
	public boolean getEstHorsQuota() {
		return estHorsQuota;
	}
	
	public void setMotif(String motif) {
		this.motif=motif;
	}
	
	public void setTypeAbsence(int typeAbsence) {
		this.typeAbsence=typeAbsence;
	}
	
	public void setIDHoraire(int idHoraire) {
		this.idHoraire=idHoraire;
	}
	
	public void setEstHorsQuota(boolean estHorsQuota) {
		this.estHorsQuota=estHorsQuota;
	}
	
	public void setEstValidee(boolean estValidee) {
		this.estJustifiee=estValidee;
	}
	
	/**
	 * Permet d'afficher toutes les infos sur une absence
	 */
	public void afficher() {
		System.out.println("Motif: "+motif);
		System.out.println("EstJustifiee: "+estJustifiee);
		System.out.println("EstJHosQuota? : "+estHorsQuota);
		System.out.println("Type d'Absence: "+typeAbsence);
		System.out.println("Id de l'Horaire: "+idHoraire);
	}
}
