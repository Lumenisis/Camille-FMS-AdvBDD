package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.User;

/**
 * @author CamCam - 2023
 * @param <T>
 * @since 1.0
 * Implémentation de la couche métier de l'application
 */

public class UserDao<T> implements Dao<T> {
	
	/**
	 * Création d'un nouvel utilisateur
	 * @param obj
	 */
	@Override
	public void create(T obj) {
		String sqlInsert = "INSERT INTO T_Users (Login, Password) VALUES (?,?)";
		try {
			PreparedStatement ps = SingletonConnection.getConnection().prepareStatement(sqlInsert);
			ps.setString(1, ((User) obj).getLogin());
			ps.setString(2, ((User) obj).getPassword());
			if (ps.executeUpdate() == 1)
				System.out.println("INSERT OK");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Affichage d'un utilisateur
	 * @param id
	 */
	@Override
	public T read(int id) {
		String sqlRead = "SELECT * FROM T_Users WHERE IdUser = ?";
		try {
			PreparedStatement ps = SingletonConnection.getConnection().prepareStatement(sqlRead);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int rsIdUser = rs.getInt(1);
				String rsLogin = rs.getString(2);
				String rsPassword = rs.getString(3);
				System.out.println(rsIdUser + " - " + rsLogin + " - " + rsPassword);
			}
			if (ps.executeUpdate() == 1)
				System.out.println("SELECT OK");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Mise à jour d'un utilisateur
	 * @param obj
	 */
	@Override
	public boolean update(T obj) {
		String sqlUpdate = "UPDATE T_Users SET Login = ?, Password = ? WHERE IdUser = ?;";
		try {
			PreparedStatement ps = SingletonConnection.getConnection().prepareStatement(sqlUpdate);
			ps.setString(1, ((User) obj).getLogin());
			ps.setString(2, ((User) obj).getPassword());
			ps.setInt(3, ((User) obj).getId());
			System.out.println("UPDATE OK");
			return ps.executeUpdate() > 0;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Suppression d'un utilisateur
	 * @param obj
	 */
	@Override
	public boolean delete(T obj) {
		String sqlDelete = "DELETE FROM T_Users WHERE IdUser = ?";
		try {
			PreparedStatement ps = SingletonConnection.getConnection().prepareStatement(sqlDelete);
			ps.setInt(1, ((User) obj).getId());
			System.out.println("DELETE OK");
			return ps.executeUpdate() > 0;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Affichage de la table
	 * @return ArrayList<T>
	 */
	@Override
	public ArrayList<T> readAll() {
		ArrayList<User> users = new ArrayList<User>();
		String sqlSelect = "SELECT * FROM T_Users";
		try(PreparedStatement ps = SingletonConnection.getConnection().prepareStatement(sqlSelect)) {
			try(ResultSet resultSet = ps.executeQuery(sqlSelect)) {
				while(resultSet.next()) {
					int rsIdUser = resultSet.getInt(1);
					String rsLogin = resultSet.getString(2);
					String rsPassword = resultSet.getString(3);
					users.add((new User(rsIdUser, rsLogin, rsPassword)));
				}
			}
			for(User u : users)
				System.out.println(u.getId() + " - " + u.getLogin() + " - " + u.getPassword());
			if (ps.executeUpdate() == 1)
				System.out.println("SELECT OK");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}