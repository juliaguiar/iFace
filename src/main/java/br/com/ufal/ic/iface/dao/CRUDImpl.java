package br.com.ufal.ic.iface.dao;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.NonUniqueResultException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.ufal.ic.iface.model.Comment;
import br.com.ufal.ic.iface.model.Community;
import br.com.ufal.ic.iface.model.Friendship;
import br.com.ufal.ic.iface.model.Postage;
import br.com.ufal.ic.iface.model.User;

@SuppressWarnings("rawtypes")
public class CRUDImpl<E> {

	final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	final SessionFactory sessionFactory = new Configuration().configure("./META-INF/hibernate.cfg.xml")
			.buildSessionFactory();
	Session session = threadLocal.get();
	
	public void addInstance(E instance) {
		session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			session.save(instance);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("Não foi possível realizar a operação. Tente novamente mais tarde.");
		}
	}
	
	public void addComment(Comment instance) {
		session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			session.save(instance);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("Não foi possível realizar a operação. Tente novamente mais tarde.");
		}
	}
	
	public void addFriendship(Friendship instance) {
		session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			session.save(instance);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("Não foi possível realizar a operação. Tente novamente mais tarde.");
		}
	}
	
	public void addUser(User instance) {
		session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			session.save(instance);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("Não foi possível realizar a operação. Tente novamente mais tarde.");
		}
	}
	
	public void updateInstance(E instance) {

		session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			session.update(instance);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("Não foi possível realizar a operação. Tente novamente mais tarde.");
		}
	}
	
	public void updateCommunity(Community instance) {

		session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			session.merge(instance);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("Não foi possível realizar a operação. Tente novamente mais tarde.");
		}
	}
	
	public void updatePostage(Postage instance) {

		session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			session.merge(instance);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("Não foi possível realizar a operação. Tente novamente mais tarde.");
		}
	}
	
	public void updateFriendship(Friendship instance) {

		session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			session.update(instance);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("Não foi possível realizar a operação. Tente novamente mais tarde.");
		}
	}

	public void updateUser(User instance) {

		session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			session.update(instance);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("Não foi possível realizar a operação. Tente novamente mais tarde.");
		}
	}

	public User getUserById(int id) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from User where id = :id");
		query.setParameter("id", id);

		User u = (User) query.uniqueResult();
		return u;
	}

	public User getUserByEmail(String email) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from User where email = :email");
		query.setParameter("email", email);

		User u = (User) query.uniqueResult();
		return u;
	}
	
	public ArrayList<User> getUserByName(String name) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from User where name = :name");
		query.setParameter("name", name);

		ArrayList<User> u = (ArrayList<User>) query.list();
		return u;
	}
	
	public Friendship getFriendshipByUserForUser(User user1, User user2) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Friendship where (user1 = :user1 and user2 = :user2) or (user1 = :user2 and user2 = :user1)");
		query.setParameter("user1", user1);
		query.setParameter("user2", user2);
		
		Friendship f = (Friendship) query.uniqueResult();
		
		return f;
	}
	
	public ArrayList<Friendship> getFriendshipByUser1AndStatus(User user1, String status) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Friendship where user1 = :user1 and status = :status");
		query.setParameter("user1", user1);
		query.setParameter("status", status);
		
		ArrayList<Friendship> f = (ArrayList<Friendship>) query.list();
		
		return f;
	}
	
	public ArrayList<Friendship> getFriendshipByUser2AndStatus(User user2, String status) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Friendship where user2 = :user2 and status = :status");
		query.setParameter("user2", user2);
		query.setParameter("status", status);
		
		ArrayList<Friendship> f = (ArrayList<Friendship>) query.list();
		
		return f;
	}
	
	public ArrayList<Community> getCommunityByAdmin(User admin) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Community where admin = :admin");
		query.setParameter("admin", admin);
		
		ArrayList<Community> c = (ArrayList<Community>) query.list();
		
		return c;
	}
	
	public List<Community> getCommunity_UserByMembers(User member) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Community members where members.id like (:member)");
		query.setParameter("member", member);
		
		List<Community> c = query.list();
		
		return c;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllInstances() {
		session = sessionFactory.openSession();
		List<User> list = null;

		try {
			session.beginTransaction();
			list = session.createCriteria(User.class).list();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("Não foi possível realizar a operação. Tente novamente mais tarde.");
		}
		return list;
	}

	public static CRUDImpl getInstance() {
		return new CRUDImpl();
	}

}