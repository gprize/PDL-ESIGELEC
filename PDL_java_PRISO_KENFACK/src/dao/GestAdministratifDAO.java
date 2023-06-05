package dao;

import java.sql.*;
import model.*;

/**
 * 
 * @author ngomp+gabris
 *
 */
public class GestAdministratifDAO extends ConnectionDAO{
	
	/**
	 * contructor
	 */
	public GestAdministratifDAO() {
		super();
	}
	

	/**
	 * Cette classe recherche et rentourne un admin 
	 * @param id id de l'admin recherché 
	 * @param mot_de_passe mot de passe de l'admin recherché
	 * @return
	 */
	public static GestAdministratif search(int id, String mot_de_passe) {
		// par defaut on considere qu'on ne trouve pas l'utilisateur recherché donc on initialise à 0
		GestAdministratif unGestAdministratif =null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM GESTIONNAIRES_ADMINISTRATIFS WHERE id_gestadmin="+id+" AND mot_de_passe='"+mot_de_passe+"'");
			
			rs = ps.executeQuery();

			if(rs.next()) {
				System.out.println("M/Mme "+rs.getString("nom")+" "+rs.getString("prenom")+" est bien dans la BDD des Gestionnaires Administratifs");
				unGestAdministratif= new GestAdministratif(rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("mot_de_passe"));
			}else {
				System.out.println("Utilisateur introuvable dans la BDD des Gestionnaires Administratifs");
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
		return unGestAdministratif;
	}
	
	/**
	 * Permet à l'admin de creer une nouvelle horaire de cours
	 * @param nouvelleHoraire horaire à ajouter
	 * @return 1 si l'horaire a bien été ajouté
	 * @return 0 sinon
	 */
	public static int addHoraireDeCours(Horaire nouvelleHoraire) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans l'insertion.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement("INSERT INTO Horaires(HEURE_DE_DEBUT,MINUTE_DE_DEBUT,HEURE_DE_FIN,MINUTE_DE_FIN,ID_SALLE,DATE_HORAIRE,ID_COURS,ID_ENSEIGNANT,ID_GROUPE,EST_ANNULEE)"
					+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1,nouvelleHoraire.getHeureDebut());
			ps.setInt(2, nouvelleHoraire.getMinuteDebut());
			ps.setInt(3, nouvelleHoraire.getHeureFin());
			ps.setInt(4, nouvelleHoraire.getHeureFin());
			ps.setInt(5, nouvelleHoraire.getIdSalle());
			ps.setString(6, nouvelleHoraire.getDateHoraire());
			ps.setInt(7, nouvelleHoraire.getIdCours());
			ps.setInt(8, nouvelleHoraire.getIdEnseignant());
			ps.setInt(9, nouvelleHoraire.getIdGroupe());
			ps.setInt(10, nouvelleHoraire.getEstAnnulee());
			
			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			
				e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
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
		return returnValue;
	}
	
	/**
	 * Cette methode cree et ajoute un nouveau groupe dans la base de donnees
	 * @param idGroupe 
	 * @param tailleMax 
	 * @return 1 si le gfroupe a été bien ajouté
	 */
	public static int addGroupeEleves(int idGroupe, int tailleMax) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans l'insertion.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement("INSERT INTO Groupes(id_groupe,taille_max)"
					+ " VALUES(?, ?)");
			ps.setInt(1, idGroupe);
			ps.setInt(2, tailleMax);
			//ps.setString(1, idGroupe);
			//ps.setInt(2, tailleMax);
			//Execution de la requete
			returnValue = ps.executeUpdate();
			
			if(returnValue==1)
				System.out.println("Le groupe a ete bien ajoute");
			else
				System.out.println("Erreur lors de l'ajout du groupe");

		} catch (Exception e) {
			
				e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
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
		return returnValue;
	}
	
	/**
	 * Cette classe recherche et renvoi un enseignant existant dans la base de donnes
	 * @param idEnseignant id de l'enseignant
	 * @return l'enseignant recherché et toutes ses caracteristiques si il existe 
	 * @return null sinon
	 */
	public static Enseignants getEnseignant(int idEnseignant) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Enseignants e=null;
		
		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Enseignants WHERE id_enseignant="+idEnseignant);
			
			rs = ps.executeQuery();

			if(rs.next()) {
				e= new Enseignants(rs.getString("nom"),
						rs.getString("prenom"),
						rs.getInt("numtel"),
						idEnseignant,
						rs.getString("mot_de_passe")
						);
				e.afficher();
			}else {
				System.out.println("Enseignant introuvable dans la BDD");
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
		return e;
	}
	
	/**
	 * Cette classe recherche et renvoi un etudiant existant dans la base de donnes
	 * @param idEleve id de l'etudiant
	 * @return l'etudiant recherché et toutes ses caracteristiques si il existe 
	 * @return null si l'etudiant n'existe pas
	 */
	public static Eleve getEtudiant(int idEleve) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		Eleve e=null;
		
		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Eleves WHERE id_eleve="+idEleve);
			
			rs = ps.executeQuery();

			if(rs.next()) {
				e= new Eleve(rs.getString("nom"),
						rs.getString("prenom"),
						rs.getInt("numtel"),
						idEleve,
						rs.getString("mot_de_passe"),
						rs.getInt("id_groupe"),
						rs.getString("filiere")
						);
				e.afficher();
			}else {
				System.out.println("Etudiant introuvable dans la BDD");
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
		return e;
	}
	
	/**
	 * Cette classe est destinee aux test des methodes
	 */
	public static void main(String[] args) {
		
		//Test de l'ajout d'une horaire
		//Horaire uneHoraire=new Horaire(1,1,1,1,1,"11/12/2023",1,300000,1,1);
		//GestAdministratifDAO.addHoraireDeCours(uneHoraire);
		
		//Test de l'ajout d'un groupe
		//GestAdministratifDAO.addGroupeEleves(7, 31);
		
		//Test de la recherche d'un etudiant
		//GestAdministratifDAO.getEtudiant(400000);
		
		//Test de la recherche d'un enseignant
		//GestAdministratifDAO.getEnseignant(300000);
	}
}
