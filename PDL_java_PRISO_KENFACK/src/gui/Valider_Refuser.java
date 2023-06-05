package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class Valider_Refuser {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Valider_Refuser window = new Valider_Refuser();
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
	public Valider_Refuser() {
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
		
		JLabel lblNewLabel = new JLabel("Nom&Prenom");
		lblNewLabel.setBounds(0, 0, 69, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblGestionA = new JLabel("Gestion A");
		lblGestionA.setBounds(367, 0, 69, 24);
		frame.getContentPane().add(lblGestionA);
		
		JButton btnNewButton_1 = new JButton("retour");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(0, 25, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 436, 24);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton_1_1 = new JButton("Refuser");
		btnNewButton_1_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1_1.setBounds(35, 232, 85, 21);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Accepter");
		btnNewButton_1_2.setBackground(new Color(0, 255, 128));
		btnNewButton_1_2.setBounds(287, 232, 85, 21);
		frame.getContentPane().add(btnNewButton_1_2);
		
		textField = new JTextField();
		textField.setBounds(115, 55, 185, 151);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
