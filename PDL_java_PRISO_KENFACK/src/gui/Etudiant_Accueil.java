package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import java.util.ArrayList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.Eleve;
import model.Horaire;

import dao.ElevesDAO;
import dao.CoursDAO;
import dao.SallesDAO;


public class Etudiant_Accueil {

	private JFrame frame;
	
	private JPanel panel_3;
	private JPanel panel_3_1;
	private JPanel panel_3_2;
	private JPanel panel_3_3;
	private JPanel panel_3_4;
	
	private Eleve cetEleve;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Etudiant_Accueil window = new Etudiant_Accueil(null);
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
	public Etudiant_Accueil(Eleve cetEleve) {
		this.cetEleve= cetEleve;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 960, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ArrayList<Horaire> lesHoraires= ElevesDAO.getPlanning(cetEleve.getGroupe());
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 277, 36);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNomprenom = new JLabel(cetEleve.getNom()+" "+cetEleve.getPrenom());
		lblNomprenom.setBounds(26, 10, 178, 22);
		lblNomprenom.setFont(new Font("Cambria Math", Font.BOLD, 18));
		panel.add(lblNomprenom);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 0, 0));
		panel_1.setBounds(229, 36, 717, 36);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lundi");
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lblNewLabel.setBounds(45, 11, 70, 20);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mardi");
		lblNewLabel_1.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lblNewLabel_1.setBounds(185, 11, 70, 20);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mercredi");
		lblNewLabel_2.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lblNewLabel_2.setBounds(175+140, 11, 90, 20);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Jeudi");
		lblNewLabel_3.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lblNewLabel_3.setBounds(190+280, 11, 70, 20);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Vendredi");
		lblNewLabel_4.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lblNewLabel_4.setBounds(190+400, 11, 90, 20);
		panel_1.add(lblNewLabel_4);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(SystemColor.activeCaption);
		panel_1_1.setBounds(0, 36, 229, 347);
		frame.getContentPane().add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JButton btnNewButton = new JButton("ABSENCES");
		btnNewButton.setForeground(new Color(240, 255, 240));
		btnNewButton.setBackground(new Color(165, 42, 42));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(26, 8, 179, 49);
		panel_1_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DEPOSER JUSTIFICATIF");
		btnNewButton_1.setForeground(new Color(240, 255, 240));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBackground(new Color(165, 42, 42));
		btnNewButton_1.setBounds(26, 74, 179, 49);
		panel_1_1.add(btnNewButton_1);
		
		JButton btnPrevenirFutureAbsences = new JButton("PREVENIR ABSENCE");
		btnPrevenirFutureAbsences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Etudiant_PrevAbs pageSuivante= new Etudiant_PrevAbs(cetEleve); 
				frame.dispose();
			}
		});
		btnPrevenirFutureAbsences.setForeground(new Color(240, 255, 240));
		btnPrevenirFutureAbsences.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPrevenirFutureAbsences.setBackground(new Color(165, 42, 42));
		btnPrevenirFutureAbsences.setBounds(26, 139, 179, 49);
		panel_1_1.add(btnPrevenirFutureAbsences);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(169, 169, 169));
		panel_2.setBounds(229, 74, 707, 309);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 5, 0, 0));
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setForeground(new Color(192, 192, 192));
		panel_3.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(192, 192, 192));
		panel_3_1.setForeground(new Color(255, 255, 255));
		panel_3_1.setBorder(new LineBorder(null, 2));
		panel_2.add(panel_3_1);
		panel_3_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_3_2 = new JPanel();
		panel_3_2.setBackground(new Color(192, 192, 192));
		panel_3_2.setForeground(new Color(255, 255, 255));
		panel_3_2.setBorder(new LineBorder(null, 2));
		panel_2.add(panel_3_2);
		panel_3_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_3_3 = new JPanel();
		panel_3_3.setBackground(new Color(192, 192, 192));
		panel_3_3.setForeground(new Color(255, 255, 255));
		panel_3_3.setBorder(new LineBorder(null, 2));
		panel_2.add(panel_3_3);
		panel_3_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_3_4 = new JPanel();
		panel_3_4.setBackground(new Color(192, 192, 192));
		panel_3_4.setForeground(new Color(255, 255, 255));
		panel_3_4.setBorder(new LineBorder(null, 2));
		panel_2.add(panel_3_4);
		panel_3_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(230, 230, 0));
		panel_4.setBounds(277, 0, 139, 36);
		frame.getContentPane().add(panel_4);
		
		JLabel lblNewLabel_6_1 = new JLabel("AGENDA");
		lblNewLabel_6_1.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lblNewLabel_6_1.setBounds(30, 10, 109, 22);
		panel_4.add(lblNewLabel_6_1);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(Color.LIGHT_GRAY);
		panel_4_1.setBounds(416, 0, 530, 36);
		frame.getContentPane().add(panel_4_1);
		panel_4_1.setLayout(null);
		
		JLabel lblProfilEtudiant_1_1 = new JLabel("Etudiant");
		lblProfilEtudiant_1_1.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lblProfilEtudiant_1_1.setBounds(400, 10, 81, 22);
		panel_4_1.add(lblProfilEtudiant_1_1);
		
		for(int i=0;i<lesHoraires.size();i++) {
			
			String heure= lesHoraires.get(i).getHeureDebut()+"h"+lesHoraires.get(i).getMinuteDebut()
					+" "+lesHoraires.get(i).getHeureFin()+"h"+lesHoraires.get(i).getMinuteFin();
			String nomCours= CoursDAO.search( lesHoraires.get(i).getIdCours() );
			String nomSalle= SallesDAO.search( lesHoraires.get(i).getIdSalle() );
			
			JLabel lblNewLabel_HeureCours = new JLabel(heure);
			
			JButton BtnNewButton_NomCours = new JButton(nomCours);
			
			JLabel lblNewLabel_NomSalle = new JLabel(nomSalle);
			
			String dateString = lesHoraires.get(i).getDateHoraire(); 
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate date = LocalDate.parse(dateString, formatter);
	        int dayOfWeek = date.getDayOfWeek().getValue();
			
			switch(dayOfWeek) {
			case 1: 
				panel_3.add(lblNewLabel_HeureCours);
				panel_3.add( BtnNewButton_NomCours);
				panel_3.add(lblNewLabel_NomSalle);
				break;
				
			case 2: 
				panel_3_1.add(lblNewLabel_HeureCours);
				panel_3_1.add( BtnNewButton_NomCours);
				panel_3_1.add(lblNewLabel_NomSalle);
				break;
				
			case 3: 
				panel_3_2.add(lblNewLabel_HeureCours);
				panel_3_2.add( BtnNewButton_NomCours);
				panel_3_2.add(lblNewLabel_NomSalle);
				break;
				
			case 4: 
				panel_3_3.add(lblNewLabel_HeureCours);
				panel_3_3.add( BtnNewButton_NomCours);
				panel_3_3.add(lblNewLabel_NomSalle);
				break;
				
			case 5: 
				panel_3_4.add(lblNewLabel_HeureCours);
				panel_3_4.add( BtnNewButton_NomCours);
				panel_3_4.add(lblNewLabel_NomSalle);
				break;
				
			default:
				break;
			}

		}
		
		frame.setVisible(true);
	}
}
