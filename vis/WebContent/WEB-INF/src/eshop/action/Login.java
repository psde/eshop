package eshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import eshop.manager.UserManager;

/*
 * Our Action class which is responsible for authenticating a user and
 * putting objects in users HTTP session (like username and whether is_admin).
 */
public class Login extends ActionSupport implements SessionAware {
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
	 * Field to store session context.
	 */
	private Map<String, Object> session;
	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	
	public String execute() throws Exception {
		/*
		 * We assume the form has been validated so why dont we set a few session fields.
		 */
		getSession().put("user", getUsername());
		getSession().put("loggedIn", true);
		getSession().put("isAdmin", UserManager.getUser(getUsername(), getPassword()).isAdmin());
		return SUCCESS;
	}

	/*
	 * We could also validate directly in the execute() method but
	 * we might as well use the validation interceptor provided by Struts2.
	 * An addFieldError call will make the app behave as if execute() returned INPUT.
	 */
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

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}
	
	public Map getSession() {
		return session;
	}
	
}