package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.Article;

/**
 * @author CamCam - 2023
 * @param <T>
 * @since 1.0
 * Implémentation de la couche métier de l'application
 */

public class ArticleDao<T> implements Dao<T> {

	/**
	 * Création d'un nouvel article
	 * @param obj
	 */
	@Override
	public void create(T obj) {
		String sqlInsert = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES (?,?,?)";
		try {
			PreparedStatement ps = SingletonConnection.getConnection().prepareStatement(sqlInsert);
			ps.setString(1, ((Article) obj).getDescription());
			ps.setString(2, ((Article) obj).getBrand());
			ps.setDouble(3, ((Article) obj).getPrice());
			if (ps.executeUpdate() == 1)
				System.out.println("INSERT OK");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Affichage d'un article
	 * @param id
	 */
	@Override
	public T read(int id) {
		String sqlRead = "SELECT * FROM T_Articles WHERE IdArticle = ?";
		try {
			PreparedStatement ps = SingletonConnection.getConnection().prepareStatement(sqlRead);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int rsIdUser = rs.getInt(1);
				String rsDescription = rs.getString(2);
				String rsBrand = rs.getString(3);
				Double rsPrice = rs.getDouble(4);
				System.out.println(rsIdUser + " - " + rsDescription + " - " + rsBrand + " - " + rsPrice);
			}
			if (ps.executeUpdate() == 1)
				System.out.println("SELECT OK");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Mise à jour d'un article
	 * @param obj
	 */
	@Override
	public boolean update(T obj) {
		String sqlUpdate = "UPDATE T_Articles SET Description = ?, Brand = ?, UnitaryPrice = ? WHERE IdArticle = ?;";
		try {
			PreparedStatement ps = SingletonConnection.getConnection().prepareStatement(sqlUpdate);
			ps.setString(1, ((Article) obj).getDescription());
			ps.setString(2, ((Article) obj).getBrand());
			ps.setDouble(3, ((Article) obj).getPrice());
			ps.setInt(4, ((Article) obj).getId());
			System.out.println("UPDATE OK");
			return ps.executeUpdate() > 0;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Suppression d'un article
	 * @param obj
	 */
	@Override
	public boolean delete(T obj) {
		String sqlDelete = "DELETE FROM T_Articles WHERE IdArticle = ?";
		try {
			PreparedStatement ps = SingletonConnection.getConnection().prepareStatement(sqlDelete);
			ps.setInt(1, ((Article) obj).getId());
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
		ArrayList<Article> articles = new ArrayList<Article>();
		String sqlSelect = "SELECT * FROM T_Articles";
		try(PreparedStatement ps = SingletonConnection.getConnection().prepareStatement(sqlSelect)) {
			try(ResultSet resultSet = ps.executeQuery(sqlSelect)) {
				while(resultSet.next()) {
					int rsIdUser = resultSet.getInt(1);
					String rsDescription = resultSet.getString(2);
					String rsBrand = resultSet.getString(3);
					Double rsPrice = resultSet.getDouble(4);
					articles.add((new Article(rsIdUser, rsDescription, rsBrand, rsPrice)));
				}
			}
			for(Article a : articles)
				System.out.println(a.getId() + " - " + a.getDescription() + " - " + a.getBrand() + " - " + a.getPrice());
			if (ps.executeUpdate() == 1)
				System.out.println("SELECT OK");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}