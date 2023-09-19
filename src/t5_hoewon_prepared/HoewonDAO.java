package t5_hoewon_prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HoewonDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql ="";
	HoewonVO vo;

	public HoewonDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		// 1. jdbcDriver검색
			String url = "jdbc:mysql://localhost:3306/javaProject";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
		//2.DB연동하고 Connetion클래스 객체로 담음
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가없습니다"+e.toString());
		} catch (SQLException e) {
			System.out.println("DB연결실패"+e.toString());
		}
	}// 생성시 driver검색 and DB연동(+커넥션클래스 객체로담아둠)
	
	public void connClose() {
		try {
			if(conn !=null)conn.close();
		} catch (Exception e) {}
	}// 연결 끊는 메서드
	
	public void pstmtClose() {
		
		if(pstmt !=null)
			try {	pstmt.close();	} catch (SQLException e) {}
	}
	
	public void rsClose() {
		if(rs !=null)
			try {	rs.close();	} catch (SQLException e) {	}
		if(pstmt !=null)
			try {	pstmt.close();	} catch (SQLException e) {}
	}
	
	
	public void close() {
		
		if(rs !=null)
			try {	rs.close();	} catch (SQLException e) {	}
		if(pstmt !=null)
			try {	pstmt.close();	} catch (SQLException e) {}
		if(conn !=null)
			try {	conn.close();	} catch (SQLException e) {	}
		
	}

	
	public List<HoewonVO> getList() {
		List<HoewonVO> vos = new ArrayList<>();
		try {
			sql = "select * from hoewon order by idx desc";
			pstmt = conn.prepareStatement(sql);   // Connection객체로 prepared Statement객체를 얻음
			rs = pstmt.executeQuery(); // Statement클래스의 exucute를 사용해 sql을 사용하고 결과를 ResultSet클래스으로 반환
			
			while(rs.next()) {
				vo = new HoewonVO();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setAddress(rs.getString("address"));
				vo.setGender(rs.getString("gender"));
				
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql 문장오류 :"+ e.toString());
		}finally {
			rsClose();
		}
		return vos;
	}
	//	개별회원조회하는 메서드
	public List<HoewonVO> getSearch(String name) {
		List<HoewonVO> vos = new ArrayList<>();

		try {
			
			sql = "select * from hoewon where name = ?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, name); // 첫번째 물음표에 넣을 값;
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new HoewonVO();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setAddress(rs.getString("address"));
				vo.setGender(rs.getString("gender"));
				
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql 오류");
			System.out.println(e.toString());
		}finally {
			rsClose();
		}
		return vos;
		
	}
	public List<HoewonVO> getSearchidx(int idx) {
		List<HoewonVO> vos = new ArrayList<>();

		try {
			
			sql = "select * from hoewon where idx = ?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new HoewonVO();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setAddress(rs.getString("address"));
				vo.setGender(rs.getString("gender"));
				
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql 오류");
			System.out.println(e.toString());
		}finally {
			rsClose();
		}
		return vos;
		
	}
//회원자료삭제메서드
	public void setDelete(String name) {
		
		try {
			sql = "delete from hoewon where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			
		}finally {
			pstmtClose();
		}
	}
	//삭제하고 리턴타입을 숫자로 받기
	public int setDelete2(String name) {
			int res = 0;
			try {
				sql = "delete from hoiwon where name = '"+name+"'";
				Statement stmt = conn.createStatement();
				res = stmt.executeUpdate(sql); //리턴타입을 int로 받음
			} catch (SQLException e) {
			  System.out.println("SQL 문장 오류 : " + e.getMessage());
			}finally {
				pstmtClose();
			}
			return res;
	}
//회원가입처리
//	public void setHoewonInput(String name, int age, String address, int gender) {}

	public int setHoewonInput(HoewonVO vo) {
		int res = 0;
		try {
			sql = "insert into hoewon values(default,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getGender());
			res = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			
		}finally {
			pstmtClose();
		}
		
		return res;
	}

	public int setUpdate(String name, int age, String address, String strGender) {
		int res=0;
		try {
			sql = "update hoewon set age =?, address = ?, gender = ? where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, age);
			pstmt.setString(2, address);
			pstmt.setString(3, strGender);
			pstmt.setString(4, name);
			res = pstmt.executeUpdate();
		
		} catch(SQLException e) {
			System.out.println(e.toString());
			e.getMessage();
		}finally {
			pstmtClose();
		}
		return res;
	}

	
		
	
		
		
	
}
