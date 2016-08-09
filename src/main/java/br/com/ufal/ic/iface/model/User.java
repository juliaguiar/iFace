package br.com.ufal.ic.iface.model;

import java.util.ArrayList;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;

	private String email;
	private String password;
	private String name;
	ArrayList<User> friends = new ArrayList();

	public User() {
	}

	public User(String email, String password, String name, ArrayList<User> friends) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.friends = friends;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static User authenticate(String email, String password) {

		// User userLog = new User(email, password, "Júlia", null);

		// busca no banco de dados e retorna em "userLog"

		// return userLog;
		return null;
	}

	public void edit(String name, String email, String password) {
		this.setName(name);
		this.setEmail(email);
		this.setPassword(password);
	}

	public void show() {

	}

	public void remove() {

	}

}
