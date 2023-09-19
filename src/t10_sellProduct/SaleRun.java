package t10_sellProduct;

import java.util.Scanner;

public class SaleRun {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.println("\n\t ***메뉴선택 ***");
			System.out.println("===========================");
			System.out.println("1.상품관리 2.판매관리 3.종료");
			System.out.println("===========================");
			int no = sc.nextInt();
			
			switch (no) {
				case 1:
					ProductService pService = new ProductService();
					pService.getProductMenu();
	
					break;
				case 2:
					SaleService sService = new SaleService();
					sService.getSaleMenu();
					break;
					
				case 3:
					
					run = false;
					break;
				
			}
		}
		

		System.out.println("종료되었습니다.");
		
		
		sc.close();
	}
}
