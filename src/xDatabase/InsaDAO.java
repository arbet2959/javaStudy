package xDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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
	
	public int setInsaUpdate(InsaVO vo) {
		int res =0;
		sql = "update insa set age=?, gender=?, ipsail=? where name = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getAge());
			pstmt.setString(2, vo.getGender());
			pstmt.setString(3, vo.getIpsail());
			pstmt.setString(4, vo.getName());
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.toString());
		}	finally {
			pstmtClose();
		}
		return res;
	}

	public int setInsaDelete(String name) {
		int res = 0;
		sql = "delete from insa where name = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.toString());
		}	finally {
			pstmtClose();
		}
		return res;
	}

	public Vector getInsaList() {
		Vector vData = new Vector<>();
		
		sql = "select * from insa order by idx desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
//				vo = new InsaVO();
//				vo.setIdx(rs.getInt("idx"));
//				vo.setName(rs.getString("name"));
//				vo.setAge(rs.getInt("age"));
//				vo.setGender(rs.getString("gender"));
//				vo.setIpsail(rs.getString("ipsail"));
//				vData.add(vo);
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				vData.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}	finally {
			rsClose();
		}
		return vData;
	}

	public Vector getList(String column,String order) {
		Vector vData = new Vector();
	
		sql = "select * from insa order by "+column +" "+order;
		try {
			pstmt = conn.prepareStatement(sql);
	
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
//				vo = new InsaVO();
//				vo.setIdx(rs.getInt("idx"));
//				vo.setName(rs.getString("name"));
//				vo.setAge(rs.getInt("age"));
//				vo.setGender(rs.getString("gender"));
//				vo.setIpsail(rs.getString("ipsail"));
//				vData.add(vo);                            //ㅅㅂ안돼
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				vData.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}	finally {
			rsClose();
		}
		return vData;
	}
	
	public Vector getColumnDescList(String column) {
		Vector vData = new Vector();
		
		sql = "select * from insa order by ? desc";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, column);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
//				vo = new InsaVO();
//				vo.setIdx(rs.getInt("idx"));
//				vo.setName(rs.getString("name"));
//				vo.setAge(rs.getInt("age"));
//				vo.setGender(rs.getString("gender"));
//				vo.setIpsail(rs.getString("ipsail"));
//				vData.add(vo);                            //ㅅㅂ안돼
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				vData.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}	finally {
			rsClose();
		}
		return vData;
	}

	public Vector getSearch(String column, String condition) {
		Vector vData = new Vector();
		sql = "select * from insa where "+column+"= ?";
		if(column.equals("ipsail"))
			sql = "select * from insa where date(ipsail)=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, column);
			pstmt.setString(1, condition);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				vData.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}	finally {
			rsClose();
		}
		return vData;
	}

	public Vector getContainSearch(String column, String condition) {
		Vector vData = new Vector();
		sql = "select * from insa where "+column+"like ?";
		if(column.equals("idx"))
			sql = "select * from insa where idx=?";
		if(column.equals("gender"))
		sql = "select * from insa where gender=?";
		if(column.equals("name"))
			sql = "select * from insa where "+column+"like ?";
		if(column.equals("age"))
			sql = "select * from insa where age=?";
		if(column.equals("ipsail"))
			sql = "select * from insa where date(ipsail)=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+condition+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail"));
				vData.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}	finally {
			rsClose();
		}
		return vData;
	}


}
