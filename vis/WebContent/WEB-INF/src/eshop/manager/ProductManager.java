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
		@SuppressWarnings("unused")
		Transaction t = null;
		try {
			
			t = s.beginTransaction();
			Query q = s.createQuery("from Product");
			List<Product> result = q.list();
			return result;
		} catch (RuntimeException ex) {
			if(t != null) t.rollback();
			throw ex;
		} finally {
			s.close();
		}
	}
	
	public static Product getProduct(Long id) throws RuntimeException {
		Session s = HibernateUtil.getSession();
		@SuppressWarnings("unused")
		Transaction t = null;
		try {
			t = s.beginTransaction();
		
			Query q = s.getNamedQuery("getProduct");
			q.setLong("id", id);
			
			Product p = (Product)q.uniqueResult();
			
			return p;
		} catch(RuntimeException ex) {
			if(t != null) t.rollback();
			System.out.println(ex.getLocalizedMessage());
			throw ex;
		} finally {
			s.close();
		}

	}
	
	public static Product getProduct2(Long id) {
		Session s = HibernateUtil.getSession();
		
		Product p = (Product)s.load(Product.class, id);
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
	
	public static boolean updateProduct(Product p) {
		
		Session s = HibernateUtil.getSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();

			s.merge(p);
			
			t.commit();
			return true;
		} catch(RuntimeException ex) {
			System.out.println("ProductManager.updateProduct: " + ex.getLocalizedMessage());
			if(t != null) t.rollback();
			return false;
		} finally {
			s.flush();

			s.close();
		}
		
	}
	
}
