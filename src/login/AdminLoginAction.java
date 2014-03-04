package login;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminLoginAction extends ActionSupport implements SessionAware {
	Map session;
	private String adminname="";
	private String adminpassword;

	public String getPassword() {
		return adminpassword;
	}

	public void setPassword(String password) {
		this.adminpassword = password;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	@Override
	public String execute() throws Exception {
		
		if (getAdminname().equals("ali")
				&& getPassword().equals("ali1")) {
			session.put("adminname", getAdminname());
			return SUCCESS;
		} else {
			
			addActionError("You are not a valid user.");
			return ERROR;
		}
	}


	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}
	
	
}
