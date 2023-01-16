package javabasic.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanItem {
	private Date planDate;
	private String detail;
	private String person;
	

	PlanItem(String date, String detail) {
		planDate = getDatefromString(date);
		this.detail = detail;
	}
	
	public static Date getDatefromString(String strDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
			
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.println("잘못된 형식입니다.");
		}
		return date;
	}
	
	
	public Date getDate() {
		return planDate;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public void addPeople(String name) {
		person += name;
	}
	
}
