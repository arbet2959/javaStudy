package t1_dbconnection;

public class Test2Run {
	public static void main(String[] args) {
		Test2DAO dao= new Test2DAO();
		
		Test2Service service = new Test2Service();
		service.getTestMethod();
		
		System.out.println("데이터베이스연결종료");
		
		dao.connClose();
	}
	
	
	
}
