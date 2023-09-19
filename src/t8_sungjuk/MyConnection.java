package t8_sungjuk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	Connection conn;
	
	
	private MyConnection() {}
	
	private static class MyConnectionHolder{
		private static final MyConnection INSTANCE = new MyConnection();
	}
	public static MyConnection getInstance() {
		return MyConnectionHolder.INSTANCE;
	}
	public Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/javaProject";
		String user = "atom";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버검색실패");
		} catch (SQLException e) {
			System.out.println("DB연동실패");		
		}
		return conn;
	}
	
	public void connClose() {
		try {
			conn.close();
		} catch (Exception e) {	}
	}
}
