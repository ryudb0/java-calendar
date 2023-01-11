package javabasic.calendar;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		System.out.println("두 수를 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		int sum =0;
		sum+=scanner.nextInt();
		sum+=scanner.nextInt();
		System.out.println("두 수의 합은 "+sum+"입니다.");
	}
	
}
