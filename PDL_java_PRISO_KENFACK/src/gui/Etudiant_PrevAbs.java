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

import model.Eleve;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Etudiant_PrevAbs {

	private JFrame frame;
	private Eleve cetEleve;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { 
					
					Etudiant_PrevAbs window = new Etudiant_PrevAbs(null);
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
	public Etudiant_PrevAbs(Eleve cetEleve) {
		this.cetEleve= cetEleve;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
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
				Etudiant_Accueil pagePrecedente = new Etudiant_Accueil(cetEleve);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(10, 47, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Absence");
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1.setBounds(324, 111, 256, 66);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Distanciel");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Etudiant_PrevAbs_Dist pageSuivante= new Etudiant_PrevAbs_Dist(cetEleve);
				frame.dispose();
			}
		});
		btnNewButton_1_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1_1.setBounds(324, 207, 256, 66);
		frame.getContentPane().add(btnNewButton_1_1);
		
		frame.setVisible(true);
	}
}
