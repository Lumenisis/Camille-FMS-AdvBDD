package fr.fms.dao;

import java.io.*;

import java.util.*;

/**
 * @author CamCam - 2023
 * @since 1.0
 * Lecture des propiétés pour la connexion à la base de données
 */

public class CreateConfigFile {

	public static Properties readPropertiesFile(String fileName) {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
			fis.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}
}