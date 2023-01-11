package javabasic.calendar;

import java.util.Scanner;

public class Calendar {
	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month-1];
	}
	
	public void sampleCalendar() {
		System.out.println("일  월  화  수  목  금  토");
		System.out.println("-----------------------");
		System.out.println(" 1  2  3  4   5   6   7");
		System.out.println(" 8  9 10  11  12  13  14");
		System.out.println("15  16  17  18  19  20  21");
		System.out.println("22  23  24  25  26  27  28");
	}
	
	public static void main(String[] args) {
//		숫자를 입력받아 해당하는 달의 초대 일수를 출력하는 프로그램
//		int[] month = new int[12];
//		month[0] =31; month[1] = 28; month[2] = 31; month[3] = 30; month[4] = 31; month[5] = 30;
//		month[6] = 31; month[7] = 31; month[8] = 30; month[9] = 31; month[10] = 30; month[11] =31;
		
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		System.out.println("달을 입력하세요.");
		int month = scanner.nextInt();
		System.out.printf("%d월은 %d일까지 있습니다.%n", month, cal.getMaxDaysOfMonth(month));
	}

}
