package questions;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import connection.ConnectionFactory;


public class ResultAction implements Serializable {
	private int rightAns;
	private int wrongAns;
	Connection connect;
	PreparedStatement pst;
	ResultSet rs;
	int counter = 0, i = 0;


	public Connection getConnection() {
		Connection con;
		con = ConnectionFactory.getInstance().getConnection();
		return con;
	}

	public void selectedAns(PaperResultModel obPaperSubmitModel, String language) {
		connect = getConnection();
		String ansQuesQuery = "insert into result(username,quesno,selectopt,language) values(?,?,?,?)";
		try {
			pst = connect.prepareStatement(ansQuesQuery);
			pst.setString(1, obPaperSubmitModel.getUsername());
			pst.setString(2, obPaperSubmitModel.getQuesno());
			pst.setString(3, obPaperSubmitModel.getAnswer());
			pst.setString(4, obPaperSubmitModel.getSubject());
			pst.execute();
			System.out.println("Paper Successfully inserted in database.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
			} catch (Exception e) {
				e.toString();
			}
		}
	}

	public FinalResultModel finalResult(PaperResultModel obResultModel,String loginUser, String subject) {
		ArrayList selectedQues = new ArrayList();
		ArrayList selectedquesN = new ArrayList();
		ArrayList selectedOptAns = new ArrayList();
		ArrayList rightQuesNAns = new ArrayList();
		FinalResultModel obFinalResultModel = new FinalResultModel();
		connect = getConnection();
		String sql1 = "select quesno, selectopt from  result_info where username=? and subject=?";
		try {
			pst = connect.prepareStatement(sql1);
			pst.setString(1, loginUser);
			pst.setString(2, subject);
			rs = pst.executeQuery();
			while (rs.next()) {
				selectedquesN.add(rs.getString(1));
				selectedOptAns.add(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
			} catch (Exception e) {
				e.toString();
			}
		}
		String quesNum;
		String option;
		String resultQuery = "select quesid,rightans from question where quesid=? and rightans=?";
		Iterator quesIter = selectedquesN.iterator();
		Iterator ansIter = selectedOptAns.iterator();
		while (quesIter.hasNext()) {
			ResultSet rs2 = null;
			PreparedStatement pst2 = null;
			quesNum = (String) quesIter.next();
			option = (String) ansIter.next();
			try {
				pst2 = connect.prepareStatement(resultQuery);
				pst2.setString(1, quesNum);
				pst2.setString(2, option);
				rs2 = pst2.executeQuery();
				selectedQues.add(quesNum);
				if (rs2.next()) {
					counter = counter + 2;
					rightAns = rightAns + 1;
				} else {
					counter = counter - 1;
					wrongAns = wrongAns + 1;
				}
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
			} catch (Exception e) {
				e.toString();
			}
		}
		try {
			String rightAnsQuery = "select question,rightans from question where quesno=?";
			Iterator selectQuesIter = selectedQues.iterator();
			while (selectQuesIter.hasNext()) {
				pst = connect.prepareStatement(rightAnsQuery);
				pst.setString(1, (String) selectQuesIter.next());
				rs = pst.executeQuery();
				while (rs.next()) {
					rightQuesNAns.add(rs.getString(1));
					rightQuesNAns.add(rs.getString(2));
				}
			}
		} catch (Exception e) {
			e.toString();
		}
		obFinalResultModel.setRightQuesNans(rightQuesNAns);
		obFinalResultModel.setCount(counter);
		obFinalResultModel.setRightAns(rightAns);
		obFinalResultModel.setWrongAns(wrongAns);
		return obFinalResultModel;
	}
}
