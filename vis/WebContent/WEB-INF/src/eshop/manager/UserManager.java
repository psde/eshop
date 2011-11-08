package eshop.manager;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import eshop.hibernate.HibernateUtil;
import eshop.pojo.User;

public class UserManager {
	/*
	 * @TODO: MD5 anyone?
	 */
	
	public static User getUser(String username, String password) {
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		Query q = s.getNamedQuery("getUserByUsernameAndPassword");
		q.setString("username", username);
		q.setString("password", password);
		
		User user = (User)q.uniqueResult();
		s.close();
		return user;
	}
	
	public static boolean authenticate(String username, String password) {
		User user = getUser(username, password);
	
		return (user != null);
	}
	
	public static void addUser(String username, String password) {
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		User user = new User(username, password, false);
		
		s.save(user);
		t.commit();
		s.flush();
		s.close();
	}
	
	public static void deleteUser(String username, String password) {
		deleteUser(getUser(username, password));
	}
	
	public static void deleteUser(User user) {
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		s.delete(user);
		t.commit();
		s.close();
	}
	
}