package javabasic.calendar;

import java.util.Scanner;

public class Prompt {
	
	public void runPrompt() {
		Calendar cal = new Calendar();
		Scanner scanner = new Scanner(System.in);
		int year = 0;
		int month = 0;
		int weekday = 0;

		while (true) {
			System.out.println("년도를 입력하세요.(exit: -1)");
			System.out.print("YEAR> ");
			year = scanner.nextInt();
			if(year ==-1) {
				break;
			}
			
			System.out.println("월을 입력하세요.");
			System.out.print("MONTH> ");
			month = scanner.nextInt();
			if (month < 1 || month > 12) {
				System.out.println("잘못된 입력입니다.");
				System.out.println();
				continue;
			}
			
			System.out.println("첫번째 요일을 입력하세요.(SU, MO, TU, WE, TH, FR, SA");
			System.out.print("WEEKDAY> ");
			String week = scanner.next();
			weekday = cal.parseDay(week);
			
			cal.printCalendar(year, month, weekday);
		}
		
		System.out.println("Have a nice day~!");
		scanner.close();
	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
		
	}
}
