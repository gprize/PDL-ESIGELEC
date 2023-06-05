package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormSpecs;

public class Etudiant_EtatDemandeDeDistanciel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Etudiant_EtatDemandeDeDistanciel window = new Etudiant_EtatDemandeDeDistanciel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param estValidee vaut 0 si le justificatif 
	 */
	public Etudiant_EtatDemandeDeDistanciel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.setBounds(100, 100, 920, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 906, 36);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNomprenom = new JLabel("NOM+PRENOM");
		lblNomprenom.setBounds(26, 10, 178, 22);
		lblNomprenom.setFont(new Font("Cambria Math", Font.BOLD, 18));
		panel.add(lblNomprenom);
		
		JLabel lblEtudiant = new JLabel("Etudiant");
		lblEtudiant.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lblEtudiant.setBounds(798, 10, 93, 22);
		panel.add(lblEtudiant);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 47, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(377, 91, 110, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate.setBounds(112, 156, 110, 36);
		frame.getContentPane().add(lblDate);
		
		JLabel lblPlageHoraire = new JLabel("Plage Horaire:");
		lblPlageHoraire.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPlageHoraire.setBounds(112, 216, 157, 36);
		frame.getContentPane().add(lblPlageHoraire);
		
		JLabel lblProfesseur = new JLabel("Professeur: ");
		lblProfesseur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblProfesseur.setBounds(112, 271, 110, 36);
		frame.getContentPane().add(lblProfesseur);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(380, 156, 110, 36);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("New label");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4_1.setBounds(380, 216, 110, 36);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("New label");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4_2.setBounds(380, 271, 110, 36);
		frame.getContentPane().add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("Demande de distanciel:");
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4_3.setBounds(112, 331, 224, 36);
		frame.getContentPane().add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("New label");
		lblNewLabel_4_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4_4.setBounds(380, 331, 110, 36);
		frame.getContentPane().add(lblNewLabel_4_4);
		
		JLabel lblCours = new JLabel("Cours :");
		lblCours.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCours.setBounds(244, 91, 110, 36);
		frame.getContentPane().add(lblCours);
		
	}
}
