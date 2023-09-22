package xDatabase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InsaService {
	private InsaVO vo; 
	
	public InsaVO getDefaultDate() {
		vo = new InsaVO();
		LocalDate currentdate = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-M-d");
		String currentdateStr= currentdate.format(dtf);
		String[] date = currentdateStr.split("-");
		
//		if(Integer.parseInt(date[1])<10) {
//			date[1] = date[1].replaceAll("0", "");
//		}
//		if(Integer.parseInt(date[2])<10) {
//			date[2] = date[2].replaceAll("0", "");
//		}
//		
		
		vo.setStrYY(date[0]);
		vo.setStrMM(date[1]);
		vo.setStrDD(date[2]);
		return vo;
	}

}
