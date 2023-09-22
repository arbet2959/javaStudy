package xDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsaDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	InsaVO vo;
	String sql;
	
	private InsaDAO() {
		conn = getConnection();
	}
	
	private static class InsaDAOHolder{
		private static final InsaDAO INSTANCE = new InsaDAO();
	}
	public static InsaDAO getInstance() {
		return InsaDAOHolder.INSTANCE;
	}
	
	private Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/javaProject";
		String user = "root";
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
	
	public void pstmtClose() {
		try {
			if(pstmt!=null)pstmt.close();
		} catch (Exception e) {	}
	}
	
	public void rsClose() {
		try {
			if(rs!=null)rs.close();
		} catch (Exception e) {	}
	
		try {
			if(pstmt!=null)pstmt.close();
		} catch (Exception e) {	}
	}

	public InsaVO getNameSearch(String name) {
		vo = new InsaVO();
		sql = "select * from insa where name = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setIpsail(rs.getString("ipsail"));
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}	finally {
			rsClose();
		}
		return vo;
	}

	public int setInsaInput(InsaVO vo) {
		int res =0;
		sql = "insert into insa values(default,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getIpsail());
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.toString());
		}	finally {
			pstmtClose();
		}
		return res;
	}
	
	
}
