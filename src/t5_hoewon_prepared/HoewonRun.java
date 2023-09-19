package t5_hoewon_prepared;


import java.util.List;
import java.util.Scanner;

public class HoewonRun {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HoewonDAO dao = new HoewonDAO();
		HoewonVO vo = null;
		String name = "";
		
		while(true) {
			System.out.print("1. 전체조회 2. 개별조회 3.회원가입 4.수정 5.삭제 6.종료 ===>");
			int no = sc.nextInt();
			if(no==6) break;
			switch(no) {
				case 1:
					
					List<HoewonVO> vos = dao.getList();
					int cnt=vos.size();
					for(HoewonVO vo1 : vos) {
						System.out.print(cnt+"\t");
//						System.out.print(vo1.getIdx()+"\t");
						System.out.print(vo1.getName()+"\t");
						System.out.print(vo1.getAge()+"\t");
						System.out.print(vo1.getAddress()+"\t");
						System.out.println(vo1.getGender());
					cnt--;
					}
					break;
					
				case 2:
					System.out.println("검색할 회원명을 입력하세요?");
					name = sc.next();
					vos = dao.getSearch(name);
					if(vos.size()==0) {
						System.out.println(name+"님 자료가 없습니다");
						break;
					}
					for(HoewonVO vo1 : vos) {
						System.out.print(vo1.getIdx()+"\t");
						System.out.print(vo1.getName()+"\t");
						System.out.print(vo1.getAge()+"\t");
						System.out.print(vo1.getAddress()+"\t");
						System.out.println(vo1.getGender());
					}
					
					break;
				case 3: //회원가입
//										
					vo = new HoewonVO();
//					while(true) {
//						System.out.println("회원 id를 입력하세요");
//						int id = sc.nextInt();
//						vos = dao.getSearchidx(id);
//						if(vos.size!=0) {System.out.println("중복된 id입니다"); continue; }
//						break;
//					}
					
					System.out.print("회원 이름을 입력하세요?");
					vo.setName(sc.next());
					do {
					System.out.print("회원 나이를 입력하세요?(20세이상)");
					vo.setAge(sc.nextInt());
					}while(vo.getAge()<=19);
					System.out.print("회원 주소을 입력하세요?");
					vo.setAddress(sc.next());
					System.out.print("회원 성별을 입력하세요?(1:남자, 2:여자)");
					int gender =sc.nextInt();
					if(gender==1)vo.setGender("남자");
					if(gender==2)vo.setGender("여자");
					
					int res = dao.setHoewonInput(vo);
					if(res ==1) System.out.println("회원가입되었습니다.");
					if(res ==0) System.out.println("회원가입실패했습니다.");
					
					break;
				case 4: //수정
					System.out.println("수정할 회원명을 입력하세요?");
					name = sc.next();
					System.out.println();
					boolean run = true;
					while(run) {
						vos = dao.getSearch(name);
						if(vos.size()==0) {
							System.out.println(name+"님 자료가 없습니다");
							break;
						}
						if(vos.size()!=0) {
							for(HoewonVO vo1 : vos) {
								System.out.print(vo1.getName()+"\t");
								System.out.print(vo1.getAge()+"\t");
								System.out.print(vo1.getAddress()+"\t");
								System.out.println(vo1.getGender());
							}
							System.out.println("수정할 항목의 번호를 입력하세요");
							System.out.print("1.나이 2.주소 3.성별 4.수정종료 ==>");
							no = sc.nextInt();
							
							int age = vos.get(0).getAge();
							String address = vos.get(0).getAddress();
							String strGender= vos.get(0).getGender();
							switch(no) {
								case 1:
									System.out.println("수정할 나이를 입력하세요?");
									age = sc.nextInt();
									break;
								case 2:
									System.out.println("수정할 주소를 입력하세요?");
									address = sc.next();
									break;
								case 3:
									System.out.println("수정할 성별를 입력하세요?(1:남자 2:여자)");
									gender = sc.nextInt();
									if(gender ==1) strGender ="남자";
									if(gender ==2) strGender ="여자";
									break;
								case 4: run = false; break;
								
							}
							res = dao.setUpdate(name,age,address,strGender);
							if(res ==0) System.out.println("수정 실패");
							if(res !=0) System.out.println(name+"님 자료가 "+res+" 건 수정 되었습니다");
							
							
						}
					}
					break;
				case 5:
					System.out.println("삭제할 회원명을 입력하세요?");
					name = sc.next();
					System.out.println();
					vos = dao.getSearch(name);
					if(vos.get(0).getName()==null) {
						System.out.println(name+"님 자료가 없습니다");
					}
					if(vos.get(0).getName()!=null) {
						dao.setDelete(name);
						
						System.out.println(name+"님 자료가 "+vos.size()+"건 삭제되었습니다.");
					} break;
				default: 
					System.out.println("잘못입력했습니다. 처음부터시작합니다.");
					continue;
			}
					
		}
		
		
		dao.close();
		sc.close();
	}
}
