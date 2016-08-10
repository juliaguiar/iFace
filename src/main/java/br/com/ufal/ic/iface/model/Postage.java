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
	
	private String text;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	List<Comment> comments = new ArrayList<Comment>(); 
	
	public Postage() {
		
	}
	
	public Postage(User author, String text, ArrayList<Comment> comments) {
		this.author = author;
		this.text = text;
		this.comments = comments;
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		for(Comment c : comments){
			this.comments.add(c);
		}
	}

	public void show() {
		System.out.println(this.getAuthor().getName());
		System.out.println(this.getText() + "\n\n");
		List<Comment> com = this.getComments();
		System.out.println("COMENTÁRIOS");
		for(Comment c : com) {
			System.out.println(c.getAuthor().getName());
			System.out.println(c.getText());
			System.out.println("");
		}
	}
	
}

