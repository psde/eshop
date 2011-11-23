package eshop.manager;

import java.util.List;

import eshop.pojo.Category;
import eshop.hibernate.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategoryManager {
	public static List<Category> getCategories() {
		Session s = HibernateUtil.getSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			
			Query q = s.createQuery("from Category");
			
			return q.list();
		} catch(RuntimeException ex) {
			if(t != null) t.rollback();
			throw ex; //not a good idea to return an empty List is it?
		} finally {
			s.close();
		}
	}
}
