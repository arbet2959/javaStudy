package t2_hoewon;

public class HoewonRun {
	public static void main(String[] args) {
//		HoewonDAO dao = new HoewonDAO();
//		HoewonDAO2 dao2 = new HoewonDAO2();
		HoewonDAO3 dao3 = new HoewonDAO3();
		
		//hoewon table의전체조회
		dao3.getList();
		
		dao3.connClose();
	}
}
