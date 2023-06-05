package model;

public class AbsenceEtudiant extends Absence{
	private int idEleve;
	
	public AbsenceEtudiant (String motif, int typeAbsence, int idEleve, int idHoraire) {
		super(motif, typeAbsence, idHoraire);
		this.idEleve=idEleve;
	}
	
	public AbsenceEtudiant (String motif, int typeAbsence, int idEleve, int idHoraire, boolean estJustifiee, boolean estHorsQuota) {
		super(motif, typeAbsence, idHoraire, estJustifiee, estHorsQuota); 
		this.idEleve=idEleve;
	}
	
	public int getIdEleve() {
		return idEleve;
	}
	
	public void getIDEleve(int idEleve) {
		this.idEleve= idEleve;
	}
	
	/**
	 * @override
	 */
	public void afficher() {
		super.afficher();
		System.out.println("IdEeleve: "+idEleve);
	}
}
