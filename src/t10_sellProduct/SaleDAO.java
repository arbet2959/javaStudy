package t10_sellProduct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaleDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql = "";
	
	ProductVO pVO;
	SaleVO sVO;
	
	private SaleDAO() {
		
	}
	
	private static class SaleDAOHolder{
		private static final SaleDAO INSTANCE = new SaleDAO();
	}
	public static SaleDAO getInstance() {
		return SaleDAOHolder.INSTANCE;
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
	
	public void pstmtClose() {
		try {
			if(pstmt!=null) pstmt.close();
		} catch (Exception e) {}
	}
	
	public void rsClose() {
		try {
			if(rs != null) rs.close();
		} catch (Exception e) {}
		try {
			if(pstmt!=null) pstmt.close();
		} catch (Exception e) {	}
	}
	
	public int setSaleInput(SaleVO vo) {
		int res = 0;
		try {
			sql = "insert into sale values(default,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getpName());
			pstmt.setInt(2, vo.getEa());
			pstmt.setString(3, vo.getpDate());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rsClose();
		}
		return res;
	}
	
	public List<SaleVO> getNameSearch(String pName) {
		List<SaleVO> vos = new ArrayList<>();
		
		try {
			sql = makeSql("name");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pName);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				SaleVO vo = new SaleVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setpName(rs.getString("pName"));
				vo.setEa(rs.getInt("ea"));
				vo.setpDate(rs.getString("pDate"));
				vo.setSalePrice(rs.getInt("price"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rsClose();
		}
		return vos;
	}
	public List<SaleVO> getDateSearch(String startDate, String endDate) {
		List<SaleVO> vos = new ArrayList<>();
		
		try {
			sql = makeSql("date");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				SaleVO vo = new SaleVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setpName(rs.getString("pName"));
				vo.setEa(rs.getInt("ea"));
				vo.setpDate(rs.getString("pDate"));
				vo.setSalePrice(rs.getInt("price"));
				vos.add(vo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rsClose();
		}
		return vos;
	}
	public List<SaleVO> getSaleList() {
		List<SaleVO> vos = new ArrayList<>();
		
		try {
			sql = makeSql("Sale");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				SaleVO vo = new SaleVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setpName(rs.getString("pName"));
				vo.setEa(rs.getInt("ea"));
				vo.setpDate(rs.getString("pDate"));
				vo.setSalePrice(rs.getInt("price"));
				vos.add(vo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rsClose();
		}
		return vos;
	}
	
	public int setSaleDelete(int idx) {
		int res =0;
		try {
			sql = "delete from sale where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rsClose();
		}
		return res;
	}
	
	public String makeSql(String str) {
		if(str.equalsIgnoreCase("name"))
			return sql = "select * from sale join product on sale.pName=product.pName where sale.pName = ?";
		if(str.equalsIgnoreCase("date"))
			return sql = "select * from sale join product on sale.pName=product.pName where pDate>= ? and pDate<= ?";
		return sql ="select * from sale join product on sale.pName=product.pName";
	}
	
	
}
