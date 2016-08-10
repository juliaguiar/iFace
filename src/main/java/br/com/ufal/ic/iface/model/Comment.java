package br.com.ufal.ic.iface.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@OneToOne
	private User author;
	
	private String text;
	
	public Comment() {
		
	}
	
	public Comment(User author, String text) {
		this.author = author;
		this.text = text;
	}

	public int getId() {
		return Id;
	}

	public User getAuthor() {
		return author;
	}

	public String getText() {
		return text;
	}
	
}
