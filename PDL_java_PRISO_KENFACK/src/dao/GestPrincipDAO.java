package dao;

import java.sql.*;
import model.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * @author ngomp+gabriss
 *
 */
public class GestPrincipDAO extends ConnectionDAO{
	
	/**
	 * Constructor
	 */
	public GestPrincipDAO() {
		super();
	}
	
	/**
	 * Cette classe recherche et ren=tourne un gestionnaire principal
	 * @param id id du gestionnaire qui veut se connecter
	 * @param mot_de_passe mot de passe du gestionnaire qui veut se connecter
	 * @return
	 */
	public static GestPrincip search(int id, String mot_de_passe) {
		// par defaut on considere qu'on ne trouve pas l'utilisateur recherché donc on initialise à 0
		GestPrincip unGestPrincip =null; 
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM GESTIONNAIRES_PRINCIPAUX WHERE id_gestprincip="+id+" AND mot_de_passe='"+mot_de_passe+"'");
			
			rs = ps.executeQuery();

			if(rs.next()) {
				System.out.println("M/Mme "+rs.getString("nom")+" "+rs.getString("prenom")+" est bien dans la BDD des Gestionnaires Principaux");
				
				unGestPrincip= new GestPrincip(rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("mot_de_passe"));
			}else {
				System.out.println("Utilisateur introuvable dans la BDD des Gestionnaires Principaux");
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
		return unGestPrincip;
	}
	
	/**
	 * Cette methode cree et ajoute un nouvel etudiant en base de données
	 * @param unEleve
	 * @return 1 si l'etudiant est a bien été ajouté
	 * @return 0 sinon
	 */
	public static int addEtudiant(Eleve unEleve) {
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
			ps = con.prepareStatement("INSERT INTO ELEVES(nom, prenom, numtel, filiere, id_groupe, mot_de_passe) VALUES(?,?,?,?,?,?)");
			ps.setString(1, unEleve.getNom());
			ps.setString(2, unEleve.getPrenom());
			ps.setInt(3, unEleve.getNumTel());
			ps.setString(4, unEleve.getFiliere());
			ps.setInt(5, unEleve.getGroupe());
			ps.setString(6, unEleve.getMotDePasse());
			
			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant de fournisseur existe déjà. Ajout impossible !");
			else
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
	 * Cette methode cree et ajoute un nouvel enseignant en base de données
	 * @param unEnseignant
	 * @return 1 si l'enseignant a été ajouté
	 * @return 0 sinon
	 */
	public static int addEnseignants(Enseignants unEnseignant) {
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
			ps = con.prepareStatement("INSERT INTO Enseignants(nom, prenom, numtel, mot_de_passe)"
					+ " VALUES(?, ?, ?, ?)");
			ps.setString(1, unEnseignant.getNom());
			ps.setString(2, unEnseignant.getPrenom());
			ps.setLong(3, unEnseignant.getNumTel());
			ps.setString(4, unEnseignant.getMotDePasse());
			
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
	 * Cette methode supprime un etudiant dans la base de donnees
	 * @param idEtudiant
	 * @return 1 si l'etudiant a bien été supprimé
	 * @return 0 sinon
	 */
	public static int deleteEtudiant(int idEtudiant) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, le ? represente la valeur de l'ID
			// a communiquer dans la suppression.
			// le getter permet de recuperer la valeur de l'ID du fournisseur
			ps = con.prepareStatement("DELETE FROM eleves WHERE id_eleve = ?");
			ps.setInt(1, idEtudiant);

			// Execution de la requete
			returnValue = ps.executeUpdate();
			
			if(returnValue==1) {
				
			}else {
				JOptionPane.showMessageDialog(new JFrame(), "Cet étudiant (id) n'existe pas", "Dialog",
						JOptionPane.ERROR_MESSAGE);
			}

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
	 * cette methode ne sert qu'a tester les autres methodes
	 */
	public static void main(String[] args) {
		
		//Test de l'ajout d'un enseignant
		//Enseignants e = new Enseignants("Ngo Sop","Ariane",754642811,"xoxo");
		//GestPrincipDAO.addEnseignants(e);
		
		//Test de l'ajout d'un etudiant
		//Eleve e = new Eleve("Tafendong","Corentin",676767676,"xoxo",1,"APPRENTISSAGE");
		//GestPrincipDAO.addEtudiant(e);
		
		//Test de la suppression d'un etudiant
		//GestPrincipDAO.deleteEtudiant(400024);
		
	}
}
