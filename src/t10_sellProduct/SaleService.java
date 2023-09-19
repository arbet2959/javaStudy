package t10_sellProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaleService {
	Scanner sc= new Scanner(System.in);
	ProductVO pVO;
	SaleVO svO;
	String pName = "";
	int res=0;
	String ans = "";
	SaleDAO dao = SaleDAO.getInstance();
	
	public void getSaleMenu() {
		dao.getConnection();
	
		boolean run = true;
		while(run) {
			System.out.println("\n1:상품등록 2: 상품별검색 3.날짜별검색 4: 판매내역리스트 5:상품삭제 6:종료 ==>");
			int no = sc.nextInt();
			switch (no) {
				case 1:
					saleInput();
					break;
				case 2:
					getSaleSearch();
					break;
				case 3:
					saleDateList();
					break;
				case 4:
					saleGetList();
					break;
				case 5:
					saleDelete();
					break;
				case 6:
					dao.connClose();
					run=false;
					break;
			}
	}
	

}
	
	private void saleDelete() {
		while(true) {
			
			System.out.println("판매번호을 입력하세요");
			int idx = sc.nextInt();
			res = dao.setSaleDelete(idx);
			if(res==0) System.out.println("==>상품삭제 실패");
			if(res==1) System.out.println("==>상품삭제 성공");
			System.out.print("상품을 계속 삭제하시겠습니까?(y/n)");
			ans = sc.next();
			if(ans.equalsIgnoreCase(ans)) break;
		}
		
		
	}
	
	private void saleGetList() {
		List<SaleVO> vos = new ArrayList<>();
	
		vos = dao.getSaleList();
		
		if(vos.size()==0) {
			System.out.println("==>판매상품이 존재하지않습니다.");
			return;
		}
		printList(vos);
		
	}

	private void saleDateList() {
		List<SaleVO> vos = new ArrayList<>();
		System.out.println("검색범위 시작날짜(yyyy-mm-dd)를 입력하세요");
		String startDate = sc.next();
		System.out.println("검색범위 끝날짜(yyyy-mm-dd)를 입력하세요");
		String endDate = sc.next();
		vos = dao.getDateSearch(startDate,endDate);
		
		if(vos.size()==0) {
			System.out.println("==>해당날짜에 판매상품이 존재하지않습니다.");
			return;
		}
		printList(vos);
		
	}

	private void getSaleSearch() {
		List<SaleVO> vos = new ArrayList<>();
		System.out.println("검색할 판매상품명을 입력하세요");
		pName = sc.next();
		vos = dao.getNameSearch(pName);
		
		if(vos.size()==0) {
			System.out.println("==>검색한 판매상품이 존재하지않습니다.");
			return;
		}
		printList(vos);
		
	}

	private void saleInput() {
		while(true) {
			SaleVO vo= new SaleVO();
			System.out.println("상품명을 입력하세요");
			pName = sc.next();
			vo.setpName(pName);		
			
			System.out.println("판매수량을 입력하세요");
			int ea = sc.nextInt();
			vo.setEa(ea);
			
			System.out.println("판매날짜(yyyy-mm-dd)를 입력하세요");
			String pDate = sc.next();
			vo.setpDate(pDate);
			res = dao.setSaleInput(vo);
			if(res==0) System.out.println("==>상품등록 실패");
			if(res==1) System.out.println("==>상품등록 성공");
			System.out.print("상품을 계속 등록하시겠습니까?(y/n)");
			ans = sc.next();
			if(ans.equalsIgnoreCase(ans)) break;
		}
		
	}
	
	void printList(List<SaleVO> vos) {
		System.out.println("번호\t상품명\t갯수\t가격\t매출\t날짜");
		for(SaleVO vo:vos) {
			System.out.print(vo.getIdx()+"\t");
			System.out.print(vo.getpName()+"\t");
			System.out.print(vo.getEa()+"\t");
			System.out.print(vo.getSalePrice()+"\t");
			System.out.print(vo.getEa()*vo.getSalePrice()+"\t");
			System.out.println(vo.getpDate().substring(0, 10));
		}
	}
	
	
}