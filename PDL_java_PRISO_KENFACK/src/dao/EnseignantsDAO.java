package dao;

import java.sql.*;
import java.util.ArrayList;

import model.Horaire;
import model.Enseignants;

/**
 * 
 * @author ngomp+gabriss
 */
public class EnseignantsDAO extends ConnectionDAO{
	
	/**
	 * Contructor
	 */
	public EnseignantsDAO () {
		super();
	}
	
	/**
	 * Cette methode recherche un enseignant dans la base de donnees a partir de son id et son mot de passe
	 * @param id id de l'enseignant qui souhaite se connecter
	 * @param mot_de_passe mot de passe de l'enseignant qui souhaite se connecter
	 * @return
	 */
	public static Enseignants search(int id, String mot_de_passe) {
		// par defaut on considere qu'on ne trouve pas l'utilisateur recherché donc on initialise à 0
		Enseignants unEnseignants =null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM ENSEIGNANTS WHERE id_enseignant="+id+" AND mot_de_passe='"+mot_de_passe+"'");
			
			rs = ps.executeQuery();

			if(rs.next()) {
				System.out.println("M/Mme "+rs.getString("nom")+" "+rs.getString("prenom")+" est bien dans la BDD des Enseignants");
				unEnseignants= new Enseignants(
						rs.getString("nom"),
						rs.getString("prenom"),
						id,
						mot_de_passe
						);
			}else {
				System.out.println("Utilisateur introuvable dans la BDD des Enseignants");
			}
			
		} catch (Exception ee) {
			ee.printStackTrace();
	
		} finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return unEnseignants;
	}
	
	/**
	 * Cette methode recupere la liste des horaires de cours d'un enseignant
	 * @param idEnseignant id de l'enseignant 
	 * @return lesHoraires la liste des horaires de cours de l'enseignant
	 */
	public static ArrayList<Horaire> getPlanning(int idEnseignant) {
		
		ArrayList<Horaire> lesHoraires=new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Horaires WHERE id_enseignant="+idEnseignant+"ORDER BY date_horaire ASC");
			
			rs = ps.executeQuery();

			if(!rs.next()) {
				System.out.println("cet enseignant n'a aucune horaire de cours");
			}else {
				
				do {
					if(rs.getInt("est_annulee")==0) {
						
						String date;
						String dateSplit[]=rs.getString("date_horaire").split(" ");
						date=dateSplit[0];
						
						Horaire nouvelleHoraire= new Horaire(
								rs.getInt("id_Horaire"),
								rs.getInt("heure_de_debut"),
								rs.getInt("minute_de_debut"),
								rs.getInt("heure_de_fin"),
								rs.getInt("minute_de_fin"),
								rs.getInt("id_salle"),
								date,
								rs.getInt("id_cours"),
								rs.getInt("id_enseignant"),
								rs.getInt("id_groupe"),
								rs.getInt("est_annulee"));
						
						nouvelleHoraire.afficher();
						
						lesHoraires.add(nouvelleHoraire);
					}
				}while(rs.next());
			}
		} catch (Exception ee) {
			ee.printStackTrace();
			
		} finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		
		return lesHoraires;
	}
	
	/**
	 * Cette methode est destinee aux test des methodes
	 */
	public static void main(String[] args) {
		//Recuperer toutes les horaires de l'enseignant 3000001
		//EnseignantsDAO.getPlanning(300001);
	}
}
