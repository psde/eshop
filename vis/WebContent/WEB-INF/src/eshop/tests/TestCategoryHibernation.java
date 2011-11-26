package eshop.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.junit.Test;

import eshop.hibernate.HibernateUtil;
import eshop.pojo.Category;

public class TestCategoryHibernation {

	@Test
	public void test() {
		Session s = HibernateUtil.getSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
		
			Category c = new Category();
			c.setName("ASD");
			s.save(c);
			t.commit();
		} catch(RuntimeException ex) {
			t.rollback();
			throw ex;
		} finally {
			s.close();
		}
		s = HibernateUtil.getSession();
		try {
			t = s.beginTransaction();
			List<Category> categories = s.createQuery("from Category").list();
			Category c2 = categories.get(categories.size()-1);
			assertEquals("ASD", c2.getName());
		
			s.delete(c2);
			t.commit();
		} catch(RuntimeException ex) {
			System.out.println(ex.getLocalizedMessage());
			t.rollback();
			throw ex;
		} finally {
			s.close();
		}
	}

}
