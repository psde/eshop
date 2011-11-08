package eshop.manager;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import eshop.hibernate.HibernateUtil;
import eshop.pojo.User;

public class UserManager {
	
	public static boolean authenticate(String username, String password) {
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		Query q = s.getNamedQuery("getUserByUsernameAndPassword");
		q.setString("username", username);
		q.setString("password", password);
		
		User user = (User)q.uniqueResult();
		
		t.commit();
		s.close();
		return (user != null);
	}
	
	public static void addUser(String username, String password) {
		Session s = HibernateUtil.getSession();
	}
	
}