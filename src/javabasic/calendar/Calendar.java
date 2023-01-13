package javabasic.calendar;


public class Calendar {
	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public boolean isLeapYear(int year) {
		if(year % 4 == 0 && (year % 100 != 0 || year % 400 ==0)) {
			return true;
		} else {
			return false;
		}
	}
	
//	이렇게 안하고 기존메서드에 year를 추가해준다
//	public int getMaxDaysOfLeapMonth(int month) {
//		return LEAP_MAX_DAYS[month -1];
//	}
	
	public int getMaxDaysOfMonth(int year, int month) {
		if(isLeapYear(year)) {
			return LEAP_MAX_DAYS[month-1];
		} else {
			return MAX_DAYS[month-1];
		}
	}
	
	public void printCalendar(int year, int month) {
		System.out.printf("   <<%4d년%3d월>>%n", year, month);
//		System.out.println(" 1  2  3  4  5  6  7");
//		System.out.println(" 8  9 10 11 12 13 14");
//		System.out.println("15 16 17 18 19 20 21");
//		System.out.println("22 23 24 25 26 27 28");
//		System.out.println("29 30 31");
		
		System.out.println(" SU MO TU WE TH FR SA"); 
		System.out.println("---------------------");
		
		int maxDay = getMaxDaysOfMonth(year, month);
		
//		내가 생각한 메서드
//		if(isLeapYear(year)) {
//			maxDay = getMaxDaysOfLeapMonth(month);
//		} else {
//			maxDay = getMaxDaysOfMonth(month);
//		}
//		윤년에대한 내 생각 잘못짬
//		if(year % 100 !=0 || year % 4 ==0 || (year % 4 ==0 || year % 400 ==0)) {
//			if(month == 2) {
//				maxDay++;
//			}
//		}
		
		for(int i=1; i<=maxDay; i++) {
			System.out.printf("%3d", i);
			if(i % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		
		
	}
		
}
