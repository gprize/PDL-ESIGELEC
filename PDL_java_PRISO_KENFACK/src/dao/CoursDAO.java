package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe permettant de gerer l'acces à la table des cours en base de donnees
 * @author ngomp+gabriss
 */
public class CoursDAO extends ConnectionDAO{
	
	/**
	 * Constructor
	 */
	public CoursDAO () {
		super();
	}
	
	/**
	 * Cette methode recherche un cours et renvoi son nom
	 * @return nomCours le nom du cours
	 * @return null si le cours n'existe pas dans la base de données
	 */
	public static String search(int idCours) {
		// par defaut on considere qu'on ne trouve pas l'utilisateur recherché donc on initialise à 0
		Connection con = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		String nomCours=null;
		
		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM COurs WHERE id_cours="+idCours);
			
			rs = ps.executeQuery();

			if(rs.next()) {			
				nomCours= rs.getString("nom");
	
			}else {
				System.out.println("Cours introuvable dans la Table des Cours");
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
		return nomCours;
	}
}
