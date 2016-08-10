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

	public int getId() {
		return this.Id;
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void edit(String name, String email, String password) {
		this.setName(name);
		this.setEmail(email);
		this.setPassword(password);
	}

}
