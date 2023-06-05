package model;

public class Horaire {
private int idHoraire;
private int heureDebut;
private int minuteDebut;
private int heureFin;
private int minuteFin;
private int idSalle;
private String dateHoraire;
private int idCours;
private int idEnseignant;
private int idGroupe;
private int estAnnulee;

public Horaire (int idHoraire,int heureDebut, int minuteDebut, int heureFin, int minuteFin,int idSalle, String dateHoraire, int idCours, int idEnseignant,int idGroupe, int estAnnulee  ) {
	this.idHoraire = idHoraire;
	this.heureDebut= heureDebut;
	this.minuteDebut= minuteDebut;
	this.heureFin=heureFin;
	this.minuteFin= minuteFin;
	this.idSalle=idSalle;
	this.dateHoraire=dateHoraire;
	this.idCours=idCours;
	this.idEnseignant=idEnseignant;
	this.idGroupe=idGroupe;
	this.estAnnulee=estAnnulee;
}

public Horaire (int heureDebut, int minuteDebut, int heureFin, int minuteFin,int idSalle, String dateHoraire, int idCours, int idEnseignant,int idGroupe, int estAnnulee  ) {
	
	this.heureDebut= heureDebut;
	this.minuteDebut= minuteDebut;
	this.heureFin=heureFin;
	this.minuteFin= minuteFin;
	this.idSalle=idSalle;
	this.dateHoraire=dateHoraire;
	this.idCours=idCours;
	this.idEnseignant=idEnseignant;
	this.idGroupe=idGroupe;
	this.estAnnulee=estAnnulee;
}

public void setIdHoraire (int idHoraire)
{
	this.idHoraire = idHoraire;
}
public void setHeureDebut (int heureDebut)
{
	this.heureDebut= heureDebut;
}
public void setMinuteDebut (int minuteDebut)
{
	this.minuteDebut= minuteDebut;
}
public void setHeureFin (int heureFin)
{
	this.heureFin= heureFin;
}
public void setMinuteFin (int minuteFin)
{
	this.minuteFin= minuteFin;
}
public void setIdSalle (int idSalle)
{
	this.idSalle= idSalle;
}
public void setDateHoraire (String dateHoraire)
{
	this.dateHoraire= dateHoraire;
}
public void setIdCours (int idCours)
{
	this.idCours= idCours;
}
public void setIdEnseignant (int idEnseignant)
{
	this.idEnseignant= idEnseignant;
}
public void setIdGroupe (int idGroupe)
{
	this.idGroupe= idGroupe;
}
public void setEstAnnulee (int estAnnulee)
{
	this.estAnnulee= estAnnulee;
}
public int getIdHoraire ()
{
	return idHoraire;
}
public int getHeureDebut ()
{
	return heureDebut;
}
public int getMinuteDebut ()
{
	return minuteDebut;
}
public int getHeureFin ()
{
	return heureFin;
}
public int getMinuteFin ()
{
	return minuteFin;
}
public int getIdSalle ()
{
	return idSalle;
}

public String getDateHoraire ()
{
	return dateHoraire;
}

//public String getDateHoraireFormated ()
//{
//	String dateSplit[]=dateHoraire.split("/");
//	String dateHoraireFormated= dateSplit[0] +"-" +dateSplit[1] +"-" +dateSplit[2];
//	return dateHoraireFormated;
//}

public int getIdCours ()
{
	return idCours;
}
public int getIdEnseignant ()
{
	return idEnseignant;
}
public int getIdGroupe ()
{
	return idGroupe;
}
public int getEstAnnulee ()
{
	return estAnnulee;
}
public void afficher ()
{
	System.out.println("idHoraire: "+ idHoraire+" heureDebut: "+ heureDebut+" minuteDebut: "+ minuteDebut+" heureFin: "+ heureFin+" minuteFin: "+ minuteFin+ " idSalle: "+ idSalle+" dateHoraire: "+ dateHoraire+" idCours: "+ idCours+" idEnseignant: "+ idEnseignant+" idGroupe: "+ idGroupe+"est annulée: "+ estAnnulee);
}
}
