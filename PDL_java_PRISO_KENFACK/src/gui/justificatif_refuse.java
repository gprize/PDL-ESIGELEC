package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class justificatif_refuse {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 justificatif_refuse window = new  justificatif_refuse();
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
	public  justificatif_refuse() {
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
		lblNewLabel.setBounds(0, 0, 89, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gestion A");
		lblNewLabel_1.setBounds(363, 6, 73, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 436, 25);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setBounds(0, 26, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("vvvvvvv");
		lblNewLabel_2.setBounds(10, 127, 63, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblAaaaaaa = new JLabel("aaaaaaa");
		lblAaaaaaa.setBounds(10, 92, 63, 25);
		frame.getContentPane().add(lblAaaaaaa);
		
		JLabel lblNewLabel_2_1 = new JLabel("vvvvvvv");
		lblNewLabel_2_1.setBounds(10, 162, 63, 25);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("date");
		lblNewLabel_2_2.setBounds(125, 92, 63, 25);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("date");
		lblNewLabel_2_3.setBounds(125, 127, 63, 25);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("date");
		lblNewLabel_2_4.setBounds(125, 162, 63, 25);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("cours");
		lblNewLabel_2_5.setBounds(198, 92, 63, 25);
		frame.getContentPane().add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_5_1 = new JLabel("cours");
		lblNewLabel_2_5_1.setBounds(198, 127, 63, 25);
		frame.getContentPane().add(lblNewLabel_2_5_1);
		
		JLabel lblNewLabel_2_5_2 = new JLabel("cours");
		lblNewLabel_2_5_2.setBounds(198, 162, 63, 25);
		frame.getContentPane().add(lblNewLabel_2_5_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Refusé");
		chckbxNewCheckBox.setBounds(337, 94, 93, 21);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxRefus = new JCheckBox("Refusé");
		chckbxRefus.setBounds(337, 129, 93, 21);
		frame.getContentPane().add(chckbxRefus);
		
		JCheckBox chckbxRefus_1 = new JCheckBox("Refusé");
		chckbxRefus_1.setBounds(337, 164, 93, 21);
		frame.getContentPane().add(chckbxRefus_1);
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.setBackground(Color.LIGHT_GRAY);
		btnActualiser.setBounds(0, 57, 85, 21);
		frame.getContentPane().add(btnActualiser);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBackground(Color.LIGHT_GRAY);
		btnValider.setBounds(337, 232, 85, 21);
		frame.getContentPane().add(btnValider);
	}
}
