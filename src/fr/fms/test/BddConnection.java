package fr.fms.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;

/**
 * @author CamCam - 2023
 * @since 1.0
 * Connexion à la base de données
 */

public class BddConnection {

	CreateConfigFile conf = new CreateConfigFile();
	public static Properties prop = CreateConfigFile.readPropertiesFile("C:\\Users\\GaschetC\\eclipse-workspace\\AdvBDD\\files\\config.properties");
	public static Connection conn;
	public static String driver = prop.getProperty("db.driver.class");
	public static String url = prop.getProperty("db.url");
	public static String login = prop.getProperty("db.login");
	public static String password = prop.getProperty("db.password");

	public static Connection getConnection() {
		try {			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, login, password);
			System.out.println("Connection successfully...");
			return conn;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}