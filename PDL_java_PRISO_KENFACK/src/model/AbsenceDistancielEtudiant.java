package model;

/**
 * 
 * @author ngomp+gabriss
 *
 */
public class AbsenceDistancielEtudiant extends Absence{
	private int idEleve;
	private String lienFictif;
	
	public AbsenceDistancielEtudiant (String motif, int typeAbsence, int idEleve, int idHoraire, String lienFictif) {
		super(motif, typeAbsence, idHoraire);
		this.idEleve= idEleve;
		this.lienFictif= lienFictif;
	}
	
	public AbsenceDistancielEtudiant (String motif, int typeAbsence, int idEleve, int idHoraire, boolean estJustifiee, boolean estHorsQuota) {
		super(motif, typeAbsence, idHoraire, estJustifiee, estHorsQuota); 
		this.idEleve=idEleve;
	}
	
	public int getIdEleve() {
		return idEleve;
	}
	
	public void setIdEleve(int idEleve) {
		this.idEleve= idEleve;
	}
	
	public String getLienFictif() {
		return lienFictif;
	}
	
	public void setLienFictif(String lienFictif) {
		this.lienFictif= lienFictif;
	}
	
	/**
	 * Permet d'afficher les absences en distanciel d'un eleve
	 * @override
	 */
	public void afficher() {
		super.afficher();
		System.out.println("IdEleve: "+idEleve);
		System.out.println("Lien vers le cours: "+lienFictif);
	}
}
