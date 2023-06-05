package model;

public class Cours {
	private int idCours;
	private String nom;
	private int masseHoraireAmphi;
	private int masseHoraireTD;
	private int masseHoraireTP;
	private int masseHoraireExam;
	
	public Cours (int idCours, String nom, int masseHoraireAmphi, int masseHoraireTD, int masseHoraireTP,int masseHoraireExam) {
		this.idCours= idCours;
		this.nom= nom;
		this.masseHoraireAmphi= masseHoraireAmphi;
		this.masseHoraireTD= masseHoraireTD;
		this.masseHoraireTP= masseHoraireTP;
		this.masseHoraireExam= masseHoraireExam;
	}
	
	public void setIdCours(int idCours)
	{
		this.idCours= idCours;
	}
	
	public void setNom (String nom)
	{
		this.nom = nom ;
	}
	
	public void setMasseHoraireAmphi (int masseHoraireAmphi)
	{
		this.masseHoraireAmphi= masseHoraireAmphi;
	}
	
	public void setMasseHoraireTD (int masseHoraireTD )
	{
		this.masseHoraireTD= masseHoraireTD;
	}
	
	public void setMasseHoraireTP (int masseHoraireTP)
	{
		this.masseHoraireTP= masseHoraireTP;
	}
	
	public void setMasseHoraireExam (int masseHoraireExam)
	{
		this.masseHoraireExam= masseHoraireExam;
	}
	
	public int getIdCours ()
	{
		return idCours;
	}
	
	public String getNom ()
	{
		return nom ;
	}
	
	public int getMasseHoraireAmphi ()
	{
		return masseHoraireAmphi;
	}
	
	public int getMasseHoraireTD ()
	{
		return masseHoraireTD;
	}
	
	public int getMasseHoraireTP ()
	{
		return masseHoraireTP;
	}
	
	public int getMasseHoraireExam ()
	{
		return masseHoraireExam;
	}
	
	public void afficher ()
	{
		System.out.println("idCours :"+ idCours+" nom :"+ nom+ "masseHoraireAmphi" + masseHoraireAmphi+" masseHoraireTD"+ masseHoraireTD+" masseHoraireTP"+ masseHoraireTP+ " masseHoraireExam"+ masseHoraireExam);
	}
}