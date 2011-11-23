package eshop.manager;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import eshop.pojo.Product;
import eshop.hibernate.HibernateUtil;

public class ProductManager {
	
	public static List<Product> getAllProducts() {
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		Query q = s.createQuery("from Product");
		
		s.close();
		
		return q.list();
	}
	
	public static Product getProduct(Long id) {
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		Query q = s.getNamedQuery("getProduct");
		q.setLong("id", id);
		
		Product p = (Product)q.uniqueResult();
		
		s.close();
		
		return p;
	}
	
	public static boolean addProduct(Product p) {
		Session s = HibernateUtil.getSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			s.save(p);
			t.commit();
			return true;
		} catch(RuntimeException ex) {
			if(t != null) t.rollback();
			return false;
		} finally {
			s.close();
		}
	}
	
}
