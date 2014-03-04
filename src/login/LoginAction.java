package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.WebSessions;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	public LoginAction(){

	}
	private String loginEmail;
	private String loginPassword;
	private PreparedStatement checkDuplicate;
	private Connection connection;
	private WebSessions ws;
	private static final long serialVersionUID = -5576598856046749040L;


	public String execute() throws ClassNotFoundException, SQLException{
		loginEmail = getLoginEmail();
		loginPassword = getLoginPassword();
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection( "jdbc:mysql://localhost/learnnow", "root", "root");
		checkDuplicate = connection.prepareStatement("select username,password from s_db  where username=? and password=?");
		checkDuplicate.setString( 1, loginEmail);
		checkDuplicate.setString( 2, loginPassword);
		ResultSet results = checkDuplicate.executeQuery();
		if(results.next()){
			ws.put("user", loginEmail);
			return "success";
		}
		else{
			return "failure";
		}

	}
	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getLoginPassword() {
		return loginPassword;
	}


	public void closeConnections()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("");
			e.printStackTrace();
		}
	}
	
	public String logOut(){
		ws.remove("user");
		return "success";
	}


}