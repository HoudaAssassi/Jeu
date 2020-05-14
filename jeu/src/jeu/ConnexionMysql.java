package jeu;

import javax.swing.*;
import java.sql.*;

public class ConnexionMysql {
	
	Connection conn = null;
	
	public static Connection ConnexionDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Jeu", "root", "mysql");
			return conn;
			
		}catch(Exception e)
		{
			JOptionPane.showInternalInputDialog(null,e);
			return null;
		}
	}

}
