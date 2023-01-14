package javabasic.calendar;


public class Calendar {
	private static final int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final int[] LEAP_MAX_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
 	
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
	public static void main(String[] args) {
		Calendar cal = new Calendar();
		System.out.println(cal.getWeekDay(1970, 1, 1) == 4);
		System.out.println(cal.getWeekDay(1971, 1, 1) == 5);
		System.out.println(cal.getWeekDay(1972, 1, 1) == 6);
		
		
	}
}
