package jeu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Inscription extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
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
					Inscription frame = new Inscription();
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
	public Inscription() {
		
		cnx = ConnexionMysql.ConnexionDB(); //Etablir la connexion avec la base de données une fois la fenêtre ouverte
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(465, 264, 253, 32);
		contentPane.add(textField);
		
		JLabel label = new JLabel("Pseudo");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(394, 268, 61, 20);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Mot de passe");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(355, 311, 100, 20);
		contentPane.add(label_1);
		
		JButton btnSinscrire = new JButton("S'inscrire");
		btnSinscrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql = "insert into joueur (pseudo, motdepasse) values ( ? , ? )";
				
				try {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1, textField.getText().toString());
					prepared.setString(2, passwordField.getText().toString());
					
					if(!textField.getText().equals("") && !passwordField.getText().equals(""))
					{
					prepared.execute();
					JOptionPane.showMessageDialog(null, "Vous êtes bien inscrit");
					}
					else {
						JOptionPane.showMessageDialog(null, "Remplissez les champs vides");
					}
					
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				
				
				
				
			}
		});
		btnSinscrire.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSinscrire.setBounds(571, 350, 147, 23);
		contentPane.add(btnSinscrire);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(465, 307, 253, 32);
		contentPane.add(passwordField);
	}

}
