package jeu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Acceuil extends JFrame {

	private JPanel contentPane;
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
					Acceuil frame = new Acceuil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Acceuil() {
		
		cnx = ConnexionMysql.ConnexionDB(); //Etablir la connexion avec la base de données une fois la fenêtre ouverte
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("S'authentifier");
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBounds(508, 269, 168, 23);
		contentPane.add(button);
		
		JButton btnSinscrire = new JButton("S'inscrire");
		btnSinscrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSinscrire.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSinscrire.setBounds(508, 235, 168, 23);
		contentPane.add(btnSinscrire);
		
		JButton btnMeilleursScores = new JButton("10 meilleurs scores");
		btnMeilleursScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//la requête
				String sql = "select pseudo , score from joueur";
				
				//préparer l'exécution de la requête et l'exécuter
				try {
					prepared = cnx.prepareStatement(sql);
					resultat = prepared.executeQuery();
					
					while(resultat.next()) {
						
						//afficher ici les scores
						
						
						
					}
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnMeilleursScores.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMeilleursScores.setBounds(508, 303, 168, 23);
		contentPane.add(btnMeilleursScores);
	}

}
