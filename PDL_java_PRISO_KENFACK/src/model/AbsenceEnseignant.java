package model;

public class AbsenceEnseignant extends Absence{
	private int idEnseignant;
	
	public AbsenceEnseignant (String motif, int typeAbsence, int idEnseignant, int idHoraire) {
		super(motif, typeAbsence, idHoraire); 
		this.idEnseignant=idEnseignant;
	}
	
	public AbsenceEnseignant (String motif, int typeAbsence, int idEnseignant, int idHoraire, boolean estJustifiee, boolean estHorsQuota) {
		super(motif, typeAbsence, idHoraire, estJustifiee, estHorsQuota); 
		this.idEnseignant=idEnseignant;
	}
	
	public int getIDEnseignants() {
		return idEnseignant;
	}
	
	public void getIDEnseignants(int idEnseignant) {
		this.idEnseignant= idEnseignant;
	}
	
	/**
	 * @override
	 */
	public void afficher() {
		super.afficher();
		System.out.println("IdEnseignant: "+idEnseignant);
	}
}
