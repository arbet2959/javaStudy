package t3_hoewon;

import java.util.Scanner;

public class HoewonRun {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HoewonDAO2 dao2 = new HoewonDAO2();
		while(true) {
			System.out.println("1. 전체조회 2. 개별조회 3. 종료 ===>");
			int no = sc.nextInt();
			if(no==3) break;
			switch(no) {
				case 1:
					dao2.getList();
					break;
				case 2:
					System.out.println("검색할 회원명을 입력하세요?");
					String name = sc.next();
					dao2.getSearch(name);
					break;
				default: 
					System.out.println("잘못입력했습니다. 처음부터시작합니다.");
					continue;
			}
					
		}
		
		
		dao2.connClose();
		sc.close();
	}
}
