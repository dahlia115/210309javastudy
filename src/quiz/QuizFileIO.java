package quiz;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class QuizFileIO implements QuizPath{
	File searchFile;
	public QuizMember searchNum(int stNum) {
		if(searchMember(stNum)) {
			QuizMember m = new QuizMember();
			try {
				FileInputStream fis = new FileInputStream(searchFile);
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream ois = new ObjectInputStream(bis);
				m = (QuizMember)ois.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return m;
		}
		return null;
	}
	private boolean searchMember(int stNum) {
		searchFile = new File( FILE_PATH + stNum+".txt");
		if(searchFile.exists()) {
			return true;
		}else {
			return false;
		}
	}
	public boolean saveMember(QuizMember m) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		if(searchMember(m.getStNum())) {
			return false;
		}else {
			try {
				 fos = new FileOutputStream(searchFile);
				 bos = new BufferedOutputStream(fos);
				 oos = new ObjectOutputStream(bos);
				oos.writeObject(m);
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(oos != null) oos.close();
					if(bos != null) bos.close();
					if(fos != null) fos.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			return true;
		}
	}
}




