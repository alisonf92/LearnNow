package questions;

import java.io.Serializable;
import java.util.ArrayList;

public class FinalResultModel implements Serializable {
	private int count;
	private int rightAns;
	private int wrongAns;
	private ArrayList rightQuesNans = new ArrayList();

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getRightAns() {
		return rightAns;
	}

	public void setRightAns(int rightAns) {
		this.rightAns = rightAns;
	}

	public int getWrongAns() {
		return wrongAns;
	}

	public void setWrongAns(int wrongAns) {
		this.wrongAns = wrongAns;
	}

	public ArrayList getRightQuesNans() {
		return rightQuesNans;
	}

	public void setRightQuesNans(ArrayList rightQuesNans) {
		this.rightQuesNans = rightQuesNans;
	}

}
