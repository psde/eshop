package eshop.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import eshop.manager.CategoryManager;
import eshop.manager.ProductManager;
import eshop.pojo.Category;
import eshop.pojo.Product;

public class Products extends ActionSupport implements SessionAware, Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map session;
	private List<Product> products;
	private List<Category> categories;
	
	private Product product; /* for detail view */

	
	/*
	 * CRUD entry point: List products
	 */
	
	public String listProducts() {
		Object isLoggedIn = session.get("loggedIn");
		if(isLoggedIn != null && ((Boolean)isLoggedIn).booleanValue()) {
			products = ProductManager.getAllProducts();
			return SUCCESS;
		} else {
			return "login";
		}
	}
	
	/*
	 * CRUD entry point: detail view of a product
	 */
	public String productDetails() {
		product = ProductManager.getProduct(product.getId());
		return SUCCESS;
	}
	
	public void prepare() throws Exception {
		categories = CategoryManager.getCategories();
	}
	
	public String insertOrUpdateProduct() {	
		if(product != null && product.getId() != null)
			product = ProductManager.getProduct(product.getId());
		return INPUT;
	}
	
	public String doSave() {
		if (product.getId() == null) {
			ProductManager.addProduct(product);
			
		} else {
			ProductManager.updateProduct(product);
		}	
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;	
	}
	
	public Map getSession() {
		return session;
	}
	
//	public String execute() throws Exception {
//		return SUCCESS;
//	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
