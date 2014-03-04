package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{

	public RegisterAction(){

	}
	private static final long serialVersionUID = 6950931326715700608L;
	private String registerEmail;
	private String registerPassword; 
	private String registerName;
	public String user;
	private Connection connection;
	private PreparedStatement addUser;


	public void setRegisterEmail(String registerEmail) {
		this.registerEmail = registerEmail;
	}

	public String getRegisterEmail() {
		return registerEmail;
	}

	public void setRegisterPassword(String registerPassword) {
		this.registerPassword = registerPassword;
	}

	public String getRegisterPassword() {
		return registerPassword;
	}

	public String execute() throws ClassNotFoundException, SQLException{
		registerEmail = getRegisterEmail();
		registerPassword = getRegisterPassword();
		registerName = getRegisterName();
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection( "jdbc:mysql://localhost/learnnow", "root", "root");
		addUser = connection.prepareStatement("INSERT INTO s_db(name, username, password) "+" VALUES(?,?,?)");
		addUser.setString(1, registerName);
		addUser.setString(2, registerEmail);
		addUser.setString(3, registerPassword);
		addUser.executeUpdate();
		return "success";

	}
	public String getRegisterName() {
		return registerName;
	}

	public void setRegisterName(String registerName) {
		this.registerName = registerName;
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


}