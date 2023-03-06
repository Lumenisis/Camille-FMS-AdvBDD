package fr.fms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author CamCam - 2023
 * @since 1.0
 * Connexion à la base de données
 */

public class SingletonConnection {

	private static Connection conn = null;

	static {
		String url = "jdbc:mariadb://localhost:3306/Shop";
		String user = "root";
		String password = "fms2023";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection successfully...");
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return conn;
	}
}