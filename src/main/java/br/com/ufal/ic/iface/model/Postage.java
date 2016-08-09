package br.com.ufal.ic.iface.model;

import java.util.List;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Postage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@OneToOne
	private User author;
	
	private Date date;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	List<Comment> comments = new ArrayList<Comment>(); 
	
	public Postage() {
		
	}
	
	public Postage(User author, Date date, ArrayList<Comment> comments) {
		this.author = author;
		this.date = date;
		this.comments = comments;
	}
	
	public void answer() {
		
	}
}

