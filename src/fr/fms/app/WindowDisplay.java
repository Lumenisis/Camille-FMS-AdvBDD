package fr.fms.app;

import javax.swing.*;

import fr.fms.dao.SingletonConnection;
import fr.fms.entities.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author CamCam - 2023
 * @since 1.0
 * Authentification de l'utilisateur et affichage des articles
 */

@SuppressWarnings("serial")
public class WindowDisplay extends JFrame {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		WindowDisplay launch = new WindowDisplay();
	}

	JPanel panel = new JPanel(null);
	JLabel connect;
	JLabel name;
	JLabel password;
	JTextField tname;
	JPasswordField tpassword;
	JButton button;
	JLabel list;
	Font fauth = new Font(Font.SANS_SERIF, Font.BOLD, 28);
	Font font = new Font(Font.SANS_SERIF, Font.BOLD, 18);
	Font fb = new Font(Font.SANS_SERIF, Font.BOLD, 14);

	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection conn = null;

	public WindowDisplay() {
		connect = new JLabel("MariaDB Authentication");
		connect.setBounds(250, 10, 400, 70);
		connect.setFont(fauth);
		connect.setBackground(Color.black);
		connect.setForeground(Color.green);
		panel.add(connect);

		name = new JLabel("Login");
		name.setBounds(50, 100, 90, 40);
		name.setFont(font);
		name.setBackground(Color.black);
		name.setForeground(Color.white);
		panel.add(name);
		
		password = new JLabel("Password");
		password.setBounds(50, 200, 90, 40);
		password.setFont(font);
		password.setBackground(Color.black);
		password.setForeground(Color.white);
		panel.add(password);
		
		tname = new JTextField();
		tname.setBounds(150, 100, 170, 40);
		tname.setFont(font);
		tname.setForeground(Color.black);
		panel.add(tname);
		
		tpassword = new JPasswordField();
		tpassword.setBounds(150, 200, 170, 40);
		tpassword.setFont(font);
		tpassword.setForeground(Color.black);
		panel.add(tpassword);
		
		button = new JButton("Connect");
		button.setBounds(190, 260, 100, 40);
		button.setFont(fb);
		button.setBackground(Color.black);
		button.setForeground(Color.green);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				if (!tname.getText().isEmpty() || !tpassword.getText().isEmpty()) {
					conn = SingletonConnection.getConnection();
					try {
						ps = conn.prepareStatement("SELECT IdUser FROM T_Users WHERE login = ? AND password = ?");
						User obj = null;
						ps.setString(1, ((User) obj).getLogin());
						ps.setString(2, ((User) obj).getPassword());
						rs = ps.executeQuery();
						if (rs.next()) {
							JOptionPane.showMessageDialog(null, "Connection successfully...");
						} else {
							JOptionPane.showMessageDialog(null, "Connection refused...");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Input error...");
				}
			}
		});
		
		list = new JLabel("SQL results...");
		list.setBounds(540, 10, 300, 200);
		list.setFont(font);
		list.setBackground(Color.black);
		list.setForeground(Color.white);
		panel.add(list);
		list = new JLabel("SQL results...");
		list.setBounds(540, 10, 300, 300);
		list.setFont(font);
		list.setBackground(Color.black);
		list.setForeground(Color.white);
		panel.add(list);
		list = new JLabel("SQL results...");
		list.setBounds(540, 10, 300, 400);
		list.setFont(font);
		list.setBackground(Color.black);
		list.setForeground(Color.white);
		panel.add(list);

		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setSize(800, 400);
		this.setContentPane(panel);
		panel.setBackground(Color.black);
	}
}