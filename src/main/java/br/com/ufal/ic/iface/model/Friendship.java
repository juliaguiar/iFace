package br.com.ufal.ic.iface.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;

@Entity
public class Friendship {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@OneToOne
	private User user1;
	@OneToOne
	private User user2;
	
	private String status;
	private String message;
	
	public Friendship() {
	}

	public Friendship(User user1, User user2, String status, String message) {
		this.user1 = user1;
		this.user2 = user2;
		this.status = status;
		this.message = message;
	}
	
	public User getUser1() {
		return this.user1;
	}
	
	public User getUser2() {
		return this.user2;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message, String name) {
		this.message = this.message + " " + name + " : " + message + ";";
	}

	public static void show(User userLog) {

	}

}
