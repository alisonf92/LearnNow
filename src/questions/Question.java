package questions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Question implements Serializable {
	private String quesno;
	private String question;
	private List option;
	private String ans1;
	private String ans2;
	private String ans3;
	private String ans4;
	private int radioId;

	public Question() {
		option = new ArrayList();
		option.add("ans1");
		option.add("ans2");
		option.add("ans3");
		option.add("ans4");
	}

	public List getOption() {
		return option;
	}

	public void setOption(List option) {
		this.option = option;
	}

	public String getQuesno() {
		return quesno;
	}

	public void setQuesno(String quesno) {
		this.quesno = quesno;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAns1() {
		return ans1;
	}

	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}

	public String getAns2() {
		return ans2;
	}

	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}

	public String getAns3() {
		return ans3;
	}

	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}

	public String getAns4() {
		return ans4;
	}

	public void setAns4(String ans4) {
		this.ans4 = ans4;
	}

}
