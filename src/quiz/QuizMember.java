package quiz;

import java.io.Serializable;

public class QuizMember implements Serializable{
	private int stNum;
	private String name;
	
	public int getStNum() {
		return stNum;
	}
	public void setStNum(int stNum) {
		this.stNum = stNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
