package t9_sungjuktest;

import java.util.Scanner;

public class SungjukRun {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SungjukService service = new SungjukService();
		
		boolean run = true;
		
		while(run) {
			System.out.println("\n\t** 성  적  표  **");
			System.out.println("무엇을 하시겠습니까?");
			System.out.println("1.입력 2.전체조회 3.개별조회 4.수정 5.삭제 0.종료");
			int no = sc.nextInt();
			
			switch (no) {
				case 1: //성적입력
					service.setInput();
					break;
				case 2: //전체조회
					service.getList();
					break;
				case 3: //개별조회
					service.getSearch();
					break;
				case 4: //수정
					service.setUpdate();
					break;
				case 5: //삭제
					service.setDelete();
					break;
				case 0: run = false; break;
			}
			
		}
		System.out.println("작업 종료!");
		
		sc.close();
	}
}
