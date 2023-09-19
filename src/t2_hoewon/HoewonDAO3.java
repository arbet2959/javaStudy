package t2_hoewon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HoewonDAO3 {
	Connection conn;
	public HoewonDAO3() {
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
			System.out.println("\t\t**주  소  록 **");
			System.out.println("==========================================================================");
			System.out.println("번호\t성명\t나이\t주소\t성별");
			System.out.println("==========================================================================");
			while(rs.next()) {
				System.out.print(rs.getInt("Idx")+"\t");
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getString("age")+"\t");
				System.out.print(rs.getString("address")+"\t");
				System.out.print(rs.getString("gender")+"\t");
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("sql오류");
			System.out.println(e.toString());
		}
	}
}
