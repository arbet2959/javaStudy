package t2_hoewon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HoewonDAO {
	Connection conn;
	public HoewonDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/javaProject";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);   //커넥션객체 DB연결시사용
		}catch(ClassNotFoundException e) {
		System.out.println("드라이버검색실패");
		System.out.println(e.toString());
		} catch (SQLException e) {
			System.out.println("DB연결실패");
			System.out.println(e.toString());
		}
	}
	
	public void connClose() {
		try {
			conn.close();
		} catch (Exception e) {}
	}
	//전체회원 조회하기
	public void getList() {
		try {
			Statement stmt=conn.createStatement(); //Statement객체
			String sql = "select * from hoewon;";
			
			ResultSet rs = stmt.executeQuery(sql); //select할때는 executeQuery(String)  나머지는 executeUpdate
			//쿼리를 실행해서 반환한것을 레코드별로 ResultSet타입으로 반환
			rs.next(); //레코드포인트를 아래로변경
			System.out.println("번호 : " + rs.getInt("Idx"));
			System.out.println("성명 : " + rs.getString("name"));
			System.out.println("나이 : " + rs.getString("age"));
			System.out.println("주소 : " + rs.getString("address"));
			System.out.println("성별 : " + rs.getString("gender"));
			
			rs.next();
			System.out.println("번호 : " + rs.getInt("Idx"));
			System.out.println("성명 : " + rs.getString("name"));
			System.out.println("나이 : " + rs.getString("age"));
			System.out.println("주소 : " + rs.getString("address"));
			System.out.println("성별 : " + rs.getString("gender"));
		} catch (SQLException e) {
			System.out.println("sql오류");
			System.out.println(e.toString());
		}
	}
}
