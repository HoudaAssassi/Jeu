package jeu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
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
		
		JButton btnNewButton = new JButton("Jouer contre un humain");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(442, 235, 248, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnJouerContreUn = new JButton("Jouer contre un non-humain");
		btnJouerContreUn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJouerContreUn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnJouerContreUn.setBounds(442, 269, 248, 23);
		frame.getContentPane().add(btnJouerContreUn);
		
		JButton btnChargerUnJeu = new JButton("Charger un jeu sauvegard\u00E9");
		btnChargerUnJeu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnChargerUnJeu.setBounds(442, 303, 248, 23);
		frame.getContentPane().add(btnChargerUnJeu);
	}

}
