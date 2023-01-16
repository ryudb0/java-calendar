package javabasic.calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록           ");
		System.out.println("| 2. 일정 검색           ");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
	}

	public void runPrompt() throws ParseException { 
		printMenu();
		
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		while(true) {
			System.out.println("명령 (1, 2, 3, h, q)");
			System.out.print("> ");
			String cmd = scanner.next();
			switch(cmd) {
				case "1":{
					cmdRegister(scanner, cal);
					break;
				}
				case "2":{
					cmdSearch(scanner, cal);
					break;
				}
				case "3":{
					cmdCal(scanner, cal);
					break;
				}
			}
			if(cmd.equalsIgnoreCase("h")) 
				printMenu();
			else if(cmd.equalsIgnoreCase("q"))
				break;
		}
		

	System.out.println("Have a nice day~!");scanner.close();

	}
	
	private void cmdRegister(Scanner s, Calendar c) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력하세요.(yyyy-MM-dd).");
		System.out.print("> ");
		String date = s.next();
		s.nextLine(); // ignore one newline
		
		System.out.println("일정을 입력하세요.");
		System.out.print("> ");
		String text = s.nextLine();
		c.registerPlan(date, text);
		System.out.println("일정이 등록되었습니다.");
	}

	private void cmdSearch(Scanner s, Calendar c) throws ParseException {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력하세요.(yyyy-MM-dd).");
		System.out.print("> ");
		String date = s.next();
		PlanItem plan = c.searchPlan(date);
		if(plan != null) {
			System.out.println(plan.getDetail()); 
		} else {
			System.out.println("일정이 없습니다.");
		}
		
	}

	private void cmdCal(Scanner s, Calendar c) {
		int year = 0;
		int month = 0;

		System.out.println("년도를 입력하세요.");
		System.out.print("YEAR> ");
		year = s.nextInt();
		
		System.out.println("월을 입력하세요.");
		System.out.print("MONTH> ");
		month = s.nextInt();
		
		if (month < 1 || month > 12) {
			System.out.println("잘못된 입력입니다.");
			return;
		}
		
		c.printCalendar(year, month);
	}


	public static void main(String[] args) throws ParseException {
		Prompt p = new Prompt();
		p.runPrompt();

	}
}
