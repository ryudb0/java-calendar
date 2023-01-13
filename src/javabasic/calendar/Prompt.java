package javabasic.calendar;

import java.util.Scanner;

public class Prompt {
	private final static String PROMPT = "cal> ";
	
	public void runPrompt() {
		Calendar cal = new Calendar();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("년도를 입력하세요.");
			System.out.print("YEAR> ");
			int year = scanner.nextInt();
			
			System.out.println("월을 입력하세요.");
			System.out.print("MONTH> ");
			int month = scanner.nextInt();
			if (month == -1) {
				System.out.println("Have a nice day~!");
				break;
			}
			if (month > 12) {
				continue;
			}
			cal.printCalendar(year, month);
		}
	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
		
	}
}
