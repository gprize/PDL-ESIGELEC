package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * @author ngomp+gabriss
 *
 */
public class SallesDAO extends ConnectionDAO{
	
	/**
	 * Constructor
	 */
	public SallesDAO () {
		super();
	}
	
	/**
	 * 
	 * @param idSalle
	 * @return
	 */
	public static String search(int idSalle) {
		// par defaut on considere qu'on ne trouve pas l'utilisateur recherché donc on initialise à 0
		Connection con = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		String nomSalle=null;
		
		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Salles WHERE id_salle="+idSalle);
			
			rs = ps.executeQuery();

			if(rs.next()) {			
				nomSalle= rs.getString("nom");
	
			}else {
				System.out.println("Salle introuvable dans la Table des Salles");
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
		return nomSalle;
	}
}
