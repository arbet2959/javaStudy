package t8_sungjuk;

import java.util.List;
import java.util.Scanner;

public class SungjukService {
	Scanner sc = new Scanner(System.in);
	SungjukDAO dao = new SungjukDAO();
	SungjukVO vo;
	String ans = "N";
	String name ="";
	
	public void setInput() {
		vo = new SungjukVO();
		
		while(true) {
		System.out.println("\n** 성적 입력 처리 **");
		System.out.print("성명 : "); vo.setName(sc.next());
		System.out.print("국어 : "); vo.setKor(sc.nextInt());
		System.out.print("영어 : "); vo.setEng(sc.nextInt());
		System.out.print("수학 : "); vo.setMath(sc.nextInt());
		
		
		
		
		int res = dao.setInput(vo);
		if(res == 0) System.out.println("입력 실패");
		if(res == 1) System.out.println("성적이 등록되었습니다.");
		
		System.out.print("계속하시겠습니까?(y/n)");
		ans = sc.next();
		if(ans.equalsIgnoreCase("n")) break;
		}
	}
	
	public void getList() {
		List<SungjukVO> vos = dao.getList();
		
		System.out.println("\n\t*** 성 적 리 스 트 ***");
		System.out.println("=====================================================");
		System.out.println("번호\t성명\t국어\t영어\t수학\t총점\t평균\t학점");
		for(SungjukVO vo: vos) {
			System.out.print(vo.getIdx()+"\t");
			System.out.print(vo.getName()+"\t");
			System.out.print(vo.getKor()+"\t");
			System.out.print(vo.getEng()+"\t");
			System.out.print(vo.getMath()+"\t");
			calculator(vo);
			System.out.print(vo.getTot()+"\t");
			System.out.print(vo.getAvg()+"\t");
			System.out.println(vo.getGrade());
		}
		System.out.println("\t 총 인원수 : "+vos.size() +" 명");
	}

	private void calculator(SungjukVO vo) {
		vo.setTot(vo.getKor()+vo.getEng()+vo.getMath());
		vo.setAvg(vo.getTot()/3.0);
		
		if(vo.getAvg()>=90)vo.setGrade('A');
		else if(vo.getAvg()>=80)vo.setGrade('B');
		else if(vo.getAvg()>=70)vo.setGrade('C');
		else if(vo.getAvg()>=60)vo.setGrade('D');
		else vo.setGrade('F');
	}

	public void getSearch() {
		while(true) {
			System.out.println("\n조회할 성명을 입력하세요.");
			name = sc.next();
			vo = dao.getSearch(name);
			if(vo.getName()==null) {System.out.println(name+"의 정보는 없습니다.");}
			if(vo.getName()!=null) {
				System.out.println("번호\t성명\t국어\t영어\t수학\t총점\t평균\t학점");
				System.out.print(vo.getIdx()+"\t");
				System.out.print(vo.getName()+"\t");
				System.out.print(vo.getKor()+"\t");
				System.out.print(vo.getEng()+"\t");
				System.out.print(vo.getMath()+"\t");
				calculator(vo);
				System.out.print(vo.getTot()+"\t");
				System.out.print(vo.getAvg()+"\t");
				System.out.println(vo.getGrade());
			}
		System.out.print("계속검색하시겠습니까?(y/n)");
		ans = sc.next();
		if(ans.equalsIgnoreCase("n")) break;
		
		}

	}

	public void setUpdate() {
		boolean run = true;
		int kor = 0;
		int eng = 0;
		int math = 0;
		System.out.println("수정할 이름을 입력하세요.");
		name = sc.next();
		vo = dao.getSearch(name);
		while(run) {
		if(vo.getName()==null) {System.out.println(name+"의 정보는 없습니다."); continue;}
		if(vo.getName()!=null) {
			System.out.println("번호\t성명\t국어\t영어\t수학\t총점\t평균\t학점");
			System.out.print(vo.getIdx()+"\t"+vo.getName()+"\t"+vo.getKor()+"\t"+vo.getEng()+"\t"+vo.getMath()+"\t");
			calculator(vo);
			System.out.print(vo.getTot()+"\t");
			System.out.print(vo.getAvg()+"\t");
			System.out.println(vo.getGrade());
		}
			kor = vo.getKor();
			eng = vo.getEng();
			math = vo.getMath();
			System.out.println("수정 내용을 입력해주세요");
			System.out.println("1.국어 2.영어 3.수학 4.종료");
			int num=sc.nextInt();
			switch (num) {
				case 1: 
					System.out.print("변경할 국어성적을입력해주세요>");
					kor=sc.nextInt();
					vo.setKor(kor);
					break;
				case 2: 
					System.out.print("변경할 영어성적을입력해주세요>");
					eng=sc.nextInt();
					vo.setEng(eng);
					break;
				case 3:
					System.out.print("변경할 수학성적을입력해주세요>");
					math=sc.nextInt();
					vo.setMath(math);
					break;
				case 4: run= false; break;
			}
		}
		int res=dao.setUpdate(vo);
		if(res==0) System.out.println("수정실패");
		if(res==1) System.out.println(name+"의 성적 수정 성공했습니다.");
	}

	public void setDelete() {
		int res=0;
		System.out.println("삭제할 이름을 입력하세요.");
		name = sc.next();
		vo = dao.getSearch(name);
		
		if(vo.getName()==null) System.out.println(name+"의 정보는 없습니다."); 
		if(vo.getName()!=null) {
			System.out.println("번호\t성명\t국어\t영어\t수학\t총점\t평균\t학점");
			System.out.print(vo.getIdx()+"\t"+vo.getName()+"\t"+vo.getKor()+"\t"+vo.getEng()+"\t"+vo.getMath()+"\t");
			calculator(vo);
			System.out.print(vo.getTot()+"\t");
			System.out.print(vo.getAvg()+"\t");
			System.out.println(vo.getGrade());
		}
		res=dao.setDelete(name);
		if(res==0)System.out.println("삭제실패");
		if(res==1)System.out.println("삭제성공");
		
	}
		
	
	
}