package eshop.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import eshop.pojo.Product;

public class Products extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map session;
	private List<Product> products;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;	
	}
	
	public Map getSession() {
		return session;
	}
	
	public String execute() throws Exception {
		return SUCCESS;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}