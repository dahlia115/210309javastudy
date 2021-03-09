package day_20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBClass {
	private String url ="jdbc:oracle:thin:@localhost:1521:xe";
	private String id ="jwoo";
	private String pwd ="1234";
	
	public DBClass() {
		try {
			//오라클 관련된 기능을 사용하기 위해서 제일 먼저 처리해 줘야한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getMember() {
		String sql = "select * from newst";
		//db연결
		try {
			Connection con = DriverManager.getConnection(url,id,pwd);
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}
}
