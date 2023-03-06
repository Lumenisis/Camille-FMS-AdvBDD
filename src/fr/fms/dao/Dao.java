package fr.fms.dao;

import java.sql.Connection;

import java.util.ArrayList;

/**
 * @author CamCam - 2023
 * @since 1.0
 * Interface qui représente la couche métier de l'application
 */

public interface Dao<T> {
	public Connection conn = BddConnection.getConnection();
	public void create(T obj);
	public T read(int id);
	public boolean update(T obj);
	public boolean delete(T obj);
	public ArrayList<T> readAll();
}