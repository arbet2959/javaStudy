package t1_dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test2DAO {
	Connection conn;
	
	public Test2DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 검색성공");
			
			String url = "jdbc:mysql://localhost:3306/javaProject";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
			System.out.println("드라이버를 검색실패");
		} catch (SQLException e) {
			System.out.println(e.toString());
			System.out.println("데이터베이스 실패");
		
		}finally {
			
		}
	}

		// connect객체 close하는 메서드
	public void connClose() {
		try {
			conn.close();
			System.out.println("커넥션객체가 닫힘");
		} catch (SQLException e) {}
		
	}
	
	
	
	
	
}
