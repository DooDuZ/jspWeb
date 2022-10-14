package board.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	// 서블렛에는 반드시 필요함
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/board",
					"root", 
					"1234");
			System.out.println("DB연동 성공");
		} catch (Exception e) {
			System.out.println("DB연결 오류" + e);
		}
	}
}
