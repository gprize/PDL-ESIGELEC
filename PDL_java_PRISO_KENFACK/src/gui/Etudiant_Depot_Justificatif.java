package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import dao.ElevesDAO;
import dao.JustificatifsDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Etudiant_Depot_Justificatif {

	private JFrame frame;
	private int idEleve;
	private int idHoraire;
	private JTextArea textArea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Etudiant_Depot_Justificatif window = new Etudiant_Depot_Justificatif(0,0);
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
	public Etudiant_Depot_Justificatif(int idEleve, int idHoraire) {
		this.idEleve=idEleve;
		this.idHoraire=idHoraire;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 940, 420);
		//On commente cette ligne pour que lorsque l'on ferme la fenetre courante, les precedentes restent ouvertes
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SAISISSEZ VOTRE JUSTIFICATIF");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(183, 47, 522, 45);
		frame.getContentPane().add(lblNewLabel);
		
//		JButton btnNewButtonRetour = new JButton("Retour");
//		btnNewButtonRetour.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Etudiant_Accueil pagePrecedente = new Etudiant_Accueil(ElevesDAO.search(idEleve));
//				frame.dispose();
//			}
//		});
		
		JButton btnNewButton = new JButton("VALIDER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String justificatif=textArea.getText();
				JustificatifsDAO.addJustificatif(idEleve, idHoraire, justificatif );
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setBounds(781, 349, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setBounds(142, 103, 633, 216);
		frame.getContentPane().add(textArea);
		
		frame.setVisible(true);
	}
}
