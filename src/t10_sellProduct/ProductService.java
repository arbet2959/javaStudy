package t10_sellProduct;

import java.util.List;
import java.util.Scanner;

public class ProductService {
	Scanner sc= new Scanner(System.in);
	ProductVO vo;
	boolean run = true;
	String pName="";
	int res=0;
	String ans = "n";
	ProductDAO dao = ProductDAO.getInstance();
	public void getProductMenu() {
			dao.getConnection();
		while(run) {
			System.out.println("\n1:상품등록 2: 상품검색 3: 상품리스트 4:상품삭제 5:종료 ==>");
			int no = sc.nextInt();
			switch (no) {
				case 1:
					productInput();
					break;
				case 2:
					getProductSearch();
					break;
				case 3:
					productList();
					break;
				case 4:
					productDelete();
					break;
				case 5:
					dao.connClose();
					run=false;
					break;
			}
		}
	}
//상품삭제
	private void productDelete() {
		System.out.println("삭제할 상품명을 입력하세요");
		pName = sc.next();
		vo = dao.getNameSearch(pName);
		
		if(vo.getpName() ==null) {
			System.out.println("==>삭제할 상품이 존재하지않습니다.");
			return;
		}
			res=dao.setproductDelete(vo.getIdx());
			if(res ==0) System.out.println("실패");
			if(res ==1) System.out.println("성공");
		
		
	}

	private void productInput() {
		
		while(true) {
			ProductVO vo = new ProductVO();
			System.out.println("상품명을 입력하세요");
			pName = sc.next();
			vo = dao.getNameSearch(pName);
			if(vo.getpName() !=null) {System.out.println("==>동일한 상품이 존재합니다."); continue;}
			vo.setpName(pName);
			System.out.println("상품가격을 입력하세요");
			int price = sc.nextInt();
			vo.setPrice(price);
			res = dao.setProductInput(vo);
			if(res==0) System.out.println("==>상품등록실패");
			if(res==1) System.out.println("==>상품등록성공");
			System.out.print("상품을 계속 등록하시겠습니까?(y/n)");
			ans = sc.next();
			if(ans.equalsIgnoreCase(ans)) break;
		
		}
	}

	public void getProductSearch() {
		System.out.println("검색할 상품명을 입력하세요");
		pName = sc.next();
		vo = dao.getNameSearch(pName);
		
		if(vo.getpName() ==null) {System.out.println("==>검색한 상품이 존재하지않습니다.");}
		if(vo.getpName() !=null) {
			System.out.println(vo.getIdx());
			System.out.println(vo.getpName());
			System.out.println(vo.getPrice());
		}
		
	}

	public void productList() {
		List<ProductVO> vos = dao.getProductList();
		
		System.out.println("*** 전체상품리스트 ***");
		System.out.println("================================");
		System.out.println("번호\t상품명\t상품가격");
		for(ProductVO vo :vos) {
			System.out.print(vo.getIdx()+"\t");
			System.out.print(vo.getpName()+"\t");
			System.out.print(vo.getPrice()+"\n");
		}
		
		System.out.println("총 상품건수는 "+vos.size()+"입니다.");
	}
	
	

}
