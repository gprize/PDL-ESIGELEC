package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class Gest_choix_type_Absence {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gest_choix_type_Absence window = new Gest_choix_type_Absence();
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
	public Gest_choix_type_Absence() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("absence classique");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(146, 99, 126, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAbsenceDistanciel = new JButton("absence distanciel");
		btnAbsenceDistanciel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAbsenceDistanciel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAbsenceDistanciel.setBackground(Color.RED);
		btnAbsenceDistanciel.setBounds(146, 163, 126, 36);
		frame.getContentPane().add(btnAbsenceDistanciel);
		
		JLabel lblNewLabel = new JLabel("Nom&Prenom");
		lblNewLabel.setBounds(10, 0, 69, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEtudiant = new JLabel("Gestion A");
		lblEtudiant.setBounds(357, 0, 69, 22);
		frame.getContentPane().add(lblEtudiant);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 436, 22);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton_1 = new JButton("retour");
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setBounds(0, 23, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
	}

}
