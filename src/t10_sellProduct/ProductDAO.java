package t10_sellProduct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql = "";
	
	ProductVO vo;

	
	private ProductDAO() {
	
	}
	
	private static class SaleDAOHolder{
		private static final ProductDAO INSTANCE = new ProductDAO();
	}
	public static ProductDAO getInstance() {
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
	// 상품명 검색(중복처리)
	public ProductVO getNameSearch(String pName) {
		ProductVO vo  = new ProductVO();
		
		try {
			sql = "select * from product where pName = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pName);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				vo.setIdx(rs.getInt("idx"));
				vo.setpName(rs.getString("pName"));
				vo.setPrice(rs.getInt("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rsClose();
		}
		return vo;
	}
	public int setProductInput(ProductVO vo) {
		int res = 0;
		sql = "insert into product values (default,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getpName());
			pstmt.setInt(2, vo.getPrice());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rsClose();
		}
		return res;
	}
	public List<ProductVO> getProductList() {
		List<ProductVO> vos = new ArrayList<>();
		
		sql = "select * from product order by idx desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				vo = new ProductVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setpName(rs.getString("pName"));
				vo.setPrice(rs.getInt("price"));
				
				vos.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rsClose();
		}
		return vos;
	}
	
	public int setproductDelete(int idx) {
		int res =0;
		sql = "delete from product where idx = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pstmtClose();
		}
		return res;
	}
	
	
	
	
}
