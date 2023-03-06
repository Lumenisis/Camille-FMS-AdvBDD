package fr.fms.entities;

/**
 * @author CamCam - 2023
 * @since 1.0
 * Entité
 */

public class User {
	private int Id;
	private String Login;
	private String Password;

	public User(int Id, String Login, String Password) {		
		this.Id = Id;
		this.Login = Login;
		this.Password = Password;
	}
	
	public User(String Login, String Password) {		
		this.Login = Login;
		this.Password = Password;
	}
	
	public User(int Id) {		
		this.Id = Id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return Login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		Login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}
}