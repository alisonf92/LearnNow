package questions;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import connection.ConnectionFactory;

public class AddQuestionAction extends ActionSupport implements ModelDriven<AdminQuestion> {
	AdminQuestion question;
	int i;
	Connection connect;
	PreparedStatement pst;


	public Connection getConnection() {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public int addQuestion(AdminQuestion question) {
		int i = 0;
		connect = getConnection();
		String addQues = "insert into question(subject,quest,ans1,ans2,ans3,ans4,rightans) values(?,?,?,?,?,?,?)";
		try {
			pst = connect.prepareStatement(addQues);
			pst.setString(1, question.getSubject());
			pst.setString(2, question.getQuestion());
			pst.setString(3, question.getAns1());
			pst.setString(4, question.getAns2());
			pst.setString(5, question.getAns3());
			pst.setString(6, question.getAns4());
			pst.setString(7, question.getRightAns());
			i = pst.executeUpdate();
			System.out.println("Question successfully Submitted");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return i;
	}

	@Override
	public String execute() throws Exception {
		i = addQuestion(question);
		return SUCCESS;
	}

	@Override
	public AdminQuestion getModel() {
		question = new AdminQuestion();
		return question;
	}
}

