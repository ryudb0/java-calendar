package javabasic.calendar;

import java.io.File;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

public class Calendar {
	private static final int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final int[] LEAP_MAX_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final String SAVE_FILE = "calendar.dat";
 	
	private HashMap<Date, PlanItem> planMap;
	
	Calendar() {
		planMap = new HashMap<>();
	}
	
	/**
	 * 
	 * @param date ex:"2015-04-01"
	 * @param plan
	 * @throws ParseException 
	 */
	public void registerPlan(String strDate, String plan) {
		PlanItem p = new PlanItem(strDate, plan);
		planMap.put(p.getDate(), p);
		
		File f = new File(SAVE_FILE);
//		ddf
		
	}
	
	public PlanItem searchPlan(String strDate)  {
		Date date = PlanItem.getDatefromString(strDate);
		return planMap.get(date);
	}
	
	public boolean isLeapYear(int year) {
		if(year % 4 == 0 && (year % 100 != 0 || year % 400 ==0)) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getMaxDaysOfMonth(int year, int month) {
		if(isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		} else {
			return MAX_DAYS[month];
		}
	}
	
	public void printCalendar(int year, int month) {
		System.out.printf("   <<%4d년%3d월>>%n", year, month);
		System.out.println(" SU MO TU WE TH FR SA"); 
		System.out.println("---------------------");

		int weekday = getWeekDay(year, month, 1);
		
		
		
		int maxDay = getMaxDaysOfMonth(year, month);

//		print blank space
		int count = 1;
		for(int i = 0; i< weekday; i++) {
			System.out.print("   ");
			count++;
		}
		weekday = count;
		
		for(int i=1; i<=maxDay; i++) {
			System.out.printf("%3d", i);
			if(weekday % 7 == 0) {
				System.out.println();
			}
			weekday++;
		}
		System.out.println();
		System.out.println();
	}

	private int getWeekDay(int year, int month, int day) {
		int syear = 1970;
		final int STANDARD_WEEK_DAY = 4; //Thursday
		
		int count =0;
		
		for(int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}
			
		for(int i = 1; i < month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}
		
		count += day - 1;
		
		int weekday = (count + STANDARD_WEEK_DAY) % 7;
		
		return weekday;
	}
	
//	test code
	public static void main(String[] args) throws ParseException {
		Calendar cal = new Calendar();
		System.out.println(cal.getWeekDay(1970, 1, 1) == 4);
		System.out.println(cal.getWeekDay(1971, 1, 1) == 5);
		System.out.println(cal.getWeekDay(1972, 1, 1) == 6);
		System.out.println(cal.getWeekDay(1973, 1, 1) == 1);
		System.out.println(cal.getWeekDay(1974, 1, 1) == 2);
		
		cal.registerPlan("2017-06-23", "Let's eat beef!");
		System.out.println(cal.searchPlan("2017-06-23"));
		
		
	}
}
