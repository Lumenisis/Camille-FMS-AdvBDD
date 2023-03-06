package fr.fms.app;

import fr.fms.dao.ArticleDao;
import fr.fms.dao.UserDao;
import fr.fms.entities.Article;
import fr.fms.entities.User;

public class Shop {

	public static void main(String[] args) {
		ArticleDao<Article> articles = new ArticleDao<>();
		// articles.create(new Article("Disque Mecanique", "WD", 110.0));
		// articles.read(3);
		// articles.update(new Article(1, "Souris", "Logitech", 50.0));
		// articles.delete(new Article(30));
		// articles.readAll();		
		UserDao<User> users = new UserDao<>();
		// users.create(new User("userDEV", "fms2023"));
		// users.read(1);
		// users.update(new User(2, "userTECH", "fms2023"));
		// users.delete(new User(3));
		// users.readAll();
	}
}