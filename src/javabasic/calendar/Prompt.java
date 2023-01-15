package javabasic.calendar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class ToDoList {
	String plan = "";
	
	ToDoList(String plan) {
		this.plan = plan;
	}
	
	public String toString() {
		return plan;
	}
}

public class Prompt {
	
	
	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록           ");
		System.out.println("| 2. 일정 검색           ");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
	}
	
	public void runPrompt() { 
		
		Scanner scanner = new Scanner(System.in);
		String order ="";
		printMenu();
//		toDoList 객체를 생성한후 일정을 저장후 리스트에 추가
//		리스트를 맵에 추가후 밸류보기
//		객체1개 리스트1개 해시맵1개씩 해보자
		ToDoList tdl;
		ArrayList<ToDoList> tdlArr	= new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		
		do {
			System.out.println("명령 (1, 2, 3, h, q)");
			System.out.print("> ");
			order = scanner.next();
			
			if(order.equals("1")) {
//				일정 등록
				System.out.println("[일정 등록] 날짜를 입력하세요.");
				System.out.print("> ");
				String calendar = scanner.next();
				System.out.println("일정을 입력하세요.");
				System.out.print("> ");
				tdl = new ToDoList(scanner.next());
				tdlArr.add(tdl);
				map.put(calendar, tdlArr);
				System.out.println("일정이 등록되었습니다.");
				
			} else if(order.equals("2")) {
//				일정 검색
				System.out.println("[일정 검색] 날짜를 입력하세요.");
				System.out.print("> ");
				String calendar = scanner.next();
				System.out.println(map.get(calendar)); 
				
				
			} else if(order.equals("3")) {
//				달력보기
				Calendar cal = new Calendar();
				
				int year = 0;
				int month = 0;

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
					
					cal.printCalendar(year, month);
				}
				
			} else if(order.equalsIgnoreCase("h")) {
//				도움말
				printMenu();
			}
			
		} while(!order.equalsIgnoreCase("q"));
			
		System.out.println("Have a nice day~!");
		scanner.close();
	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
		
		
		
		
	}
}
