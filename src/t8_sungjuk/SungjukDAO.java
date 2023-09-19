package t8_sungjuk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SungjukDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	SungjukVO vo;
	String sql = "";
	
public SungjukDAO() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/javaProject";
		String user = "atom";
		String password = "1234";
		conn =DriverManager.getConnection(url,user,password);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void connClose() {
	try {
		if(conn !=null)conn.close();
	} catch (Exception e) {}
}

public void pstmtClose() {
	try {
		if(pstmt !=null)	pstmt.close();	
	}catch (Exception e) {}
}

public void rsClose() {
	try {
		if(rs !=null)	rs.close();	
	}catch (Exception e) {}

	try {
		if(pstmt !=null)	pstmt.close();	
	}catch (Exception e) {}
}

public void close() {
	try {
		if(rs !=null) rs.close();	
	} catch (Exception e) {	}
	try {
	if(pstmt !=null) pstmt.close();
	} catch (Exception e) {}
	try {
	if(conn !=null)conn.close();
	} catch (Exception e) {}
}

public int setInput(SungjukVO vo) {
	int res =0;
	try {
		sql = "insert into sungjuk values(default,?,?,?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setInt(2, vo.getKor());
		pstmt.setInt(3, vo.getEng());
		pstmt.setInt(4, vo.getMath());
		res = pstmt.executeUpdate();
		
	} catch (SQLException e) {
		System.out.println("sql오류");
		e.printStackTrace();
	} finally {
		pstmtClose();
	}
	return res;
}

public List<SungjukVO> getList() {
	List<SungjukVO> vos = new ArrayList<>();
	
	try {
		sql = "select * from sungjuk order by idx desc";
		pstmt=conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			vo=new SungjukVO();
			vo.setIdx(rs.getInt("idx"));
			vo.setName(rs.getString("name"));
			vo.setKor(rs.getInt("kor"));
			vo.setEng(rs.getInt("eng"));
			vo.setMath(rs.getInt("math"));
			vos.add(vo);
		}
		
	} catch (SQLException e) {
		System.out.println("sql오류");
		e.printStackTrace();
	} finally {
		rsClose();
	}
	
	return vos;
}

public SungjukVO getSearch(String name) {
	SungjukVO vo = new SungjukVO();
	try {
		sql = "select * from sungjuk where name =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			vo.setIdx(rs.getInt("idx"));
			vo.setName(rs.getString("name"));
			vo.setKor(rs.getInt("kor"));
			vo.setEng(rs.getInt("eng"));
			vo.setMath(rs.getInt("math"));
		}
	} catch (SQLException e) {
		System.out.println("sql오류");
		e.printStackTrace();
	} finally {
		rsClose();
	}
	return vo;
}

public int setUpdate(SungjukVO vo) {
	int res=0;
	try {
		sql = "update sungjuk set kor=?, eng=?,math=? where name=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, vo.getKor());
		pstmt.setInt(2, vo.getEng());
		pstmt.setInt(3, vo.getMath());
		pstmt.setString(4, vo.getName());
		res = pstmt.executeUpdate();
	} catch (SQLException e) {
		System.out.println("sql오류");
		e.printStackTrace();
	} finally {
		pstmtClose();
	}
	return res;
}

public int setDelete(String name) {
	int res=0;
	try {
		sql = "delete from sungjuk where name = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		res = pstmt.executeUpdate();
	} catch (SQLException e) {
		System.out.println("sql오류");
		e.printStackTrace();
	} finally {
		pstmtClose();
	}
	return res;
	
}





	
	
}
