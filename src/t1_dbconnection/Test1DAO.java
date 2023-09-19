package t1_dbconnection;

import java.sql.DriverManager;
import java.sql.SQLException;

//DB 연결 및 DB의 각종 처리를 담당

public class Test1DAO {
	public Test1DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");  // JDBC드라이버 검색
			System.out.println("JDBC드라이버 검색 성공");
			
			String url = "jdbc:mysql://localhost:3306/javaproject";
			String user = "atom";
			String password = "1234";
			DriverManager.getConnection(url, user, password);//
			System.out.println("DB연결성공");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("드라이버검색실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("DB연결실패");
			
		}finally{
			System.out.println("끝");
		}
	}
	
}
