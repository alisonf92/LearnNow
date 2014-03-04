package questions;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;


import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import connection.ConnectionFactory;

public class QuestionAction extends ActionSupport implements RequestAware, SessionAware {
	
	Connection connect = null;
	//ArrayList quesPaper = null;
	PreparedStatement pst = null;
	String[] option = null;
	ResultSet rs = null;
	Map request, session;
	ArrayList questPaper = new ArrayList();
	public String username;
	private String subject="";

	@Override
	public String execute() throws Exception {
	
		username = (String) session.get("username");
		session.put("subject", getSubject());
		int paperAlready = checkPaperAlreadyGiven(getSubject(), username);
		if (getSubject().equals("")) {
			addActionError("Please select Subject");
			return ERROR;
		} else 
			if (paperAlready == 1) {
			addActionError("You have already completed paper of this "
					+ "subject.Plesae choose another subject !");
			return ERROR;
		} else {
			System.out.println("Subject "+ getSubject());
			questPaper = getQues(getSubject());
			request.put("questPaper", questPaper);
			return SUCCESS;
		}
	}

	public Map getRequest() {
		return request;
	}

	public void setRequest(Map request) {
		this.request = request;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	
	public Connection getConnection() {
		Connection con;
		con = ConnectionFactory.getInstance().getConnection();
		return con;
	}
	
	public int checkPaperAlreadyGiven(String subject, String username) {
		ResultSet rs3 = null;
		int paperAlready = 0;
		connect = getConnection();
		String query = "select * from result_info where username=? and subject=?";
		try {
			pst = connect.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, subject);
			rs3 = pst.executeQuery();
			if (rs3.next()) {
				paperAlready = paperAlready + 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.toString();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return paperAlready;
	}

	public ArrayList getQues(String subject) {
		questPaper = new ArrayList();
		String queryQues = "select quesid,quest,ans1,ans2,ans3,ans4 from question where subject='"
				+ subject + "' order by rand() limit 2";
		try {
			pst = connect.prepareStatement(queryQues);
			rs = pst.executeQuery();
			while (rs.next()) {
				questPaper.add(rs.getString(1));
				questPaper.add(rs.getString(2));
				questPaper.add(rs.getString(3));
				questPaper.add(rs.getString(4));
				questPaper.add(rs.getString(5));
				questPaper.add(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (connect != null) {
					connect.close();
				}
			} catch (Exception e) {
				e.toString();
			}
		}
		return questPaper;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
