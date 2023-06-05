package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * 
 * @author ngomp+gabriss
 *
 */
public class JustificatifsDAO extends ConnectionDAO{
	
	/**
	 * Constructor
	 */
	public JustificatifsDAO () {
		super();
	}
	
	/**
	 * Ajoute un nouveau justificatif d'absence
	 * @param idEleve
	 * @param idHoraire
	 * @param motif
	 * @return 1 si le justificatif a bien été ajouté
	 * @return 0 sinon
	 */
	public static int addJustificatif(int idEleve, int idHoraire, String motif) {
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
			ps = con.prepareStatement("INSERT INTO JUSTIFICATIFS_DISTANCIELS(MOTIF,EST_VALIDEE,ID_HORAIRE,ID_ELEVE)"
					+ " VALUES(?, ?, ?, ?)");
			
			ps.setString(1, motif);
			ps.setString(2, "EN COURS DE TRAITEMENT");
			ps.setInt(3, idHoraire);
			ps.setInt(4, idEleve);
			
			returnValue = ps.executeUpdate();
			
			if(returnValue==1)
				System.out.println("Le Justificatif a ete bien ajoute");
			else
				System.out.println("Erreur lors de l'ajout du justificatif");

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
	 * Cette methode sert à tester les autres methodes
	 */
	public static void main(String[] args) {
		//Test de l'ajout d'un justificatif
		//addJustificatif(1,"eee",400000);
	}
}