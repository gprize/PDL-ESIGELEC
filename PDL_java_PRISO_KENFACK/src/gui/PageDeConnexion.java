package gui;

import java.awt.EventQueue;
import java.awt.Font;

import dao.*;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.*;



public class PageDeConnexion {
 
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageDeConnexion window = new PageDeConnexion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public PageDeConnexion() {
		initialize();
	}
	
	/**
	 * Mise en oeuvre du bouton "Connexion"
	 * 
	 * Cette methode permet de verifier si l'id et le mot de passe entrés par l'utilisateur existent dans la BDD
	 * Ensuite renvoie la page correspondant au type d'utilisateur
	 * 
	 * @return 1 si l'id et le mdp correspondent à ceux d'un gestionnaire principal existant en Base De Données
	 * @return 2 si l'id et le mdp correspondent à ceux d'un gestionnaire administratif existant en BDD
	 * @return 3 si l'id et le mdp correspondent à ceux d'un enseignant existant en BDD
	 * @return 4 si l'id et le mdp correspondent à ceux d'un eleve existant en BDD
	 * @return -1 si il n'ya aucune correspondance en BDD
	 * 
	 */
	public int verifierInfosConnexion(int id, String mdp) {
		
		int result =-1;
		
		//Tentative de connexion en tant que gestionnaire principal
		if(id/100000==1) {
			
			
			//Si cet id et ce mdp correspondent à ceux d'un gest principal existant dans la BDD
			if(GestPrincipDAO.search(id, mdp)!=null) {
				result =1;
				try {	
					//TODO Appeler une fenetre Gestionnaire
//					Gestionnaire_P gestionnaire_P= new Gestionnaire_P();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		//Tentative de connexion en tant que gestionnaire administratif
		if(id/100000==2) {
			
			//Si cet id et ce mdp correspondent à ceux d'un gestionnaire admin existant dans la BDD
			if(GestAdministratifDAO.search(id, mdp)!=null) {
				result =2;
				try {
					//TODO Appeler une fenetre Gestionnaire administratif
//					Gestionaire_administratif gestionaire_administratif= new Gestionaire_administratif();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		//Tentative de connexion en tant qu'enseignant
		if(id/100000==3) {
			
			//Si cet id et ce mdp correspondent à ceux d'un enseignant existant dans la BDD
			if(EnseignantsDAO.search(id, mdp)!=null) {
				result =3;
				try {
					//TODO 
//					Accueil_enseignant page_enseignant= new Accueil_enseignant();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		//Tentative de connexion en tant qu'eleve
		if(id/100000>3 && id/100000<10) {
			
			Eleve unEleve=ElevesDAO.search(id, mdp);
			
			//Si cet id et ce mdp correspondent à ceux d'un eleve existant dans la BDD 
			if(unEleve!=null) {
				result =4;
				try {
					Etudiant_Accueil page_etudiant= new Etudiant_Accueil(unEleve);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		if (result==-1)
		{
			try {
				JOptionPane.showMessageDialog(new JFrame(), "Identifiant et mot de passe incorrectes", "Dialog",
						JOptionPane.ERROR_MESSAGE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 920, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(152, 115, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 155, 96, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("connexion");
		btnNewButton.setFont(new Font("Times new roman", Font.BOLD, 16));
		btnNewButton.setSize(new Dimension(100, 0));
		btnNewButton.setPreferredSize(new Dimension(120, 23));
		btnNewButton.setForeground(new Color(46, 139, 87));
		btnNewButton.setBackground(new Color(144, 238, 144));
		btnNewButton.setBounds(152, 202, 120, 19);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			// S'execute lorsqu'on clique sur le bouton connexion
			public void actionPerformed(ActionEvent arg0) {
				
				//id recupere l'id donné dans la zone de texte
				int id= Integer.parseInt(textField.getText());
				//mdp recupere le mot de passe donné dans la zone de texte
				String mdp= textField_1.getText();
				
				//On verifie les infos de connexion en executant verifierInfosConnexion(id,mdp)
				int con= verifierInfosConnexion(id,mdp);
				
				//ensuite on cache la fenetre de connexion si la connexion a réussi
				if(con!=-1)
					frame.dispose();
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("identifiant");
		lblNewLabel.setBounds(62, 118, 80, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("mot de passe");
		lblNewLabel_1.setBounds(62, 158, 80, 13);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
	}
}
