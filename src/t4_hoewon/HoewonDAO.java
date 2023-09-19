package t4_hoewon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HoewonDAO {
	Connection conn;
	Statement stmt;
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
	
	public void stmtClose() {
		
		if(stmt !=null)
			try {	stmt.close();	} catch (SQLException e) {}
	}
	
	public void rsClose() {
		if(rs !=null)
			try {	rs.close();	} catch (SQLException e) {	}
		if(stmt !=null)
			try {	stmt.close();	} catch (SQLException e) {}
	}
	
	
	public void close() {
		
		if(rs !=null)
			try {	rs.close();	} catch (SQLException e) {	}
		if(stmt !=null)
			try {	stmt.close();	} catch (SQLException e) {}
		if(conn !=null)
			try {	conn.close();	} catch (SQLException e) {	}
		
	}

	
	public List<HoewonVO> getList() {
		List<HoewonVO> vos = new ArrayList<>();
		try {
			stmt = conn.createStatement();   // Connection객체로 Statement객체를 얻음
			sql = "select * from hoewon order by idx desc";
			rs = stmt.executeQuery(sql); // Statement클래스의 exucute를 사용해 sql을 사용하고 결과를 ResultSet클래스으로 반환
			
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
			
			stmt =conn.createStatement();
			sql = "select * from hoewon where name = '"+name+"'";
			rs = stmt.executeQuery(sql);
			
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
			
			stmt =conn.createStatement();
			sql = "select * from hoewon where idx = '"+idx+"'";
			rs = stmt.executeQuery(sql);
			
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
			sql = "delete from hoewon where name = '"+name+"'";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
		} catch(SQLException e) {
			
		}finally {
			stmtClose();
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
				stmtClose();
			}
			return res;
	}
//회원가입처리
//	public void setHoewonInput(String name, int age, String address, int gender) {}

	public int setHoewonInput(HoewonVO vo) {
		int res = 0;
		try {
			sql = "insert into hoewon values(default,'"+vo.getName()+"',"+vo.getAge()+",'"+vo.getAddress()+"','"+vo.getGender()+"');";
			stmt = conn.createStatement();
			res = stmt.executeUpdate(sql);
			
		} catch(SQLException e) {
			
		}finally {
			stmtClose();
		}
		
		return res;
	}

	public int setUpdate(String name, int age, String address, String strGender) {
		int res=0;
		try {
			sql = "update hoewon set age = "+age+", address = '"+address+"', gender = '"+strGender+"' where name = '"+name+"'";
			stmt = conn.createStatement();
			res = stmt.executeUpdate(sql);
		
		} catch(SQLException e) {
			System.out.println(e.toString());
			e.getMessage();
		}finally {
			stmtClose();
		}
		return res;
	}

	
		
	
		
		
	
}
