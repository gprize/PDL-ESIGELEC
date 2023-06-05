package dao;

import java.sql.*;
import model.Horaire;
import model.Eleve;

import java.util.ArrayList;


/**
 * Classe permettant d'acceder a la table des eleves en base donnees et permettre aux etudiants de recuperer et enregistrer des informations
 * @author ngomp+gabriss
 */
public class ElevesDAO extends ConnectionDAO{

	/**
	 * Constructor
	 */
	public ElevesDAO () {
		super();
	}
	
	/**
	 * Cette methode recherche et renvoi un eleve 
	 * @param id identifiant de l'eleve qui veut se connecter
	 * @param mot de passe de l'eleve qui veut se connecter
	 * @return unEleve l'eleve et toutes ses caracteristiques telles qu'enregistrées en base de donnees
	 */
	public static Eleve search(int id, String mot_de_passe) {
		// par defaut on considere qu'on ne trouve pas l'utilisateur recherché donc on initialise à 0
		Connection con = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		Eleve unEleve=null;
		
		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM ELEVES WHERE id_eleve="+id+" AND mot_de_passe='"+mot_de_passe+"'");
			
			rs = ps.executeQuery();

			if(rs.next()) {
				System.out.println("M/Mme "+rs.getString("nom")+" "+rs.getString("prenom")+" est bien dans la BDD des eleves");
				
				unEleve= new Eleve(
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getInt("numtel"),
						id,
						mot_de_passe,
						rs.getInt("id_groupe"),
						rs.getString("filiere")
						);
	
			}else {
				System.out.println("Utilisateur introuvable dans la BDD des Eleves");
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
		return unEleve;
	}
	
	/**
	 * Cette methode recherche et renvoi un eleve en base de donnee
	 * @param id identifiant de l'eleve qui veut se connecter
	 * @return unEleve l'eleve et toutes ses caracteristiques telles qu'enregistrées en base de donnees
	 */
	public static Eleve search(int id) {
		// par defaut on considere qu'on ne trouve pas l'utilisateur recherché donc on initialise à 0
		Connection con = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		Eleve unEleve=null;
		
		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM ELEVES WHERE id_eleve="+id);
			
			rs = ps.executeQuery();

			if(rs.next()) {
				System.out.println("M/Mme "+rs.getString("nom")+" "+rs.getString("prenom")+" est bien dans la BDD des eleves");
				
				unEleve= new Eleve(
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getInt("numtel"),
						id,
						rs.getString("mot_de_passe"),
						rs.getInt("id_groupe"),
						rs.getString("filiere")
						);
	
			}else {
				System.out.println("Utilisateur introuvable dans la BDD des Eleves");
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
		return unEleve;
	}
	
	/**
	 * Cette methode recupere la liste des doraires de cours d'un eleve
	 * @param idGroupeEleve groupe auquel appartient l'eleve
	 * @return lesHoraires la liste des horaires de cours de l'eleve 
	 */
	public static ArrayList<Horaire> getPlanning(int idGroupeEleve) {
		
		ArrayList<Horaire> lesHoraires=new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Horaires WHERE id_groupe="+idGroupeEleve+"ORDER BY date_horaire ASC" );
			
//			ps = con.prepareStatement("SELECT Horaires.*, cours.nom as \"nom cours\", enseignants.nom as \"nom enseignant\", enseignants.prenom as \"prenom enseignant\", salles.nom as \"salle\"\r\n"
//					+ "FROM ( (Horaires inner join Cours on Horaires.Id_cours= Cours.Id_cours) \r\n"
//					+ "     inner join enseignants on enseignants.Id_enseignant= Horaires.Id_enseignant )\r\n"
//					+ "     inner join salles on salles.Id_salle= Horaires.Id_salle\r\n"
//					+ "WHERE id_groupe=" + idGroupeEleve + "ORDER BY date_horaire ASC");
			
			rs = ps.executeQuery();

			if(!rs.next()) {
				System.out.println("cet eleve n'a aucune horaire de cours");
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
						
						//nouvelleHoraire.afficher();
						
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
		//Recuperer toutes les horaires du groupe 1
		ElevesDAO.getPlanning(1);
	}
	
}
