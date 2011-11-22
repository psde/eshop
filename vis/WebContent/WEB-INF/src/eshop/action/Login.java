package eshop.action;

import com.opensymphony.xwork2.ActionSupport;
import eshop.manager.UserManager;

public class Login extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5588374487038737901L;

	/*
	 * We need to declare private variables and their getters and setters
	 * which correspond to the inputs in our form.
	 */
	
	private String username;
	private String password;
	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	
	public String execute() throws Exception {
		return SUCCESS;
	}

	public void validate() {
		if(getUsername().length() == 0) {
			addFieldError("username", "Username is required.");
		}
		if(getPassword().length() == 0) {
			addFieldError("password", "Password is required bro.");
		}
		
		if(!UserManager.authenticate(getUsername(), getPassword())) {
			addFieldError("username", "Username/Password combination did not match!");
		}
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}