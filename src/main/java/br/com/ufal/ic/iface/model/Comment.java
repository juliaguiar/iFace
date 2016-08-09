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
	
	private Date date;
	
	public Comment() {
		
	}
	
	public Comment(User author, Date date) {
		this.author = author;
		this.date = date;
	}

}
