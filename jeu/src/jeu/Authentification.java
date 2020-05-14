package jeu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Authentification extends JFrame{

	private JFrame frame;
	private JTextField pseudoField;
	private JPasswordField motdepasseField;
	
	Connection cnx = null; //Etablir la connexion de la classe avec la base de données
	PreparedStatement prepared = null; //exécuter la requête
	ResultSet resultat = null; //résultat de la requête
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification window = new Authentification();
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
	public Authentification() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		cnx = ConnexionMysql.ConnexionDB(); //Etablir la connexion avec la base de données une fois la fenêtre ouverte
		
		
		pseudoField = new JTextField();
		pseudoField.setBounds(465, 264, 253, 32);
		frame.getContentPane().add(pseudoField);
		pseudoField.setColumns(10);
		
		motdepasseField = new JPasswordField();
		motdepasseField.setBounds(465, 310, 253, 32);
		frame.getContentPane().add(motdepasseField);
		
		JLabel lblNewLabel = new JLabel("Pseudo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(394, 268, 61, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMotDePasse.setBounds(355, 314, 100, 20);
		frame.getContentPane().add(lblMotDePasse);
		
		JButton btnNewButton = new JButton("S'authentifier");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pseudo=pseudoField.getText().toString();
				String motdepasse=motdepasseField.getText().toString();
				
				//la requête
				String sql = "select pseudo , motdepasse from joueur";
				
				//préparer l'exécution de la requête et l'exécuter
				try {
					prepared = cnx.prepareStatement(sql);
					resultat = prepared.executeQuery();
					int i=0;
					
					if(pseudo.equals("") || motdepasse.equals("")) JOptionPane.showMessageDialog(null, "Remplissez les champs vides !");
					else {
					while(resultat.next()) {
						String pseudo1=resultat.getString("pseudo");
						String motdepasse1=resultat.getString("motdepasse");
						
						if(pseudo1.equals(pseudo) && motdepasse1.equals(motdepasse)) {
							JOptionPane.showMessageDialog(null, "Connexion résussie");
							i=1;
						}
						
					}
					if (i==0) JOptionPane.showMessageDialog(null, "Connexion échouée, informations incorrectes");
					}
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(571, 353, 147, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
