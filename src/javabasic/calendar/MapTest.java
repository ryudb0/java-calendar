package javabasic.calendar;

import java.util.ArrayList;
import java.util.HashMap;

class ListTest {
	String calendar = "";
	String plan = "";
	
	ListTest(String calendar, String plan) {
		this.calendar = calendar;
		this.plan = plan;
	}
	
	public String toString() {
		return this.calendar + this.plan;
	}
	
}

public class MapTest {
	public static void main(String[] args) {
		ArrayList<ListTest> list = new ArrayList<>();
		
		ListTest lt = new ListTest("2016-06-05", "자바지기에게 밥 얻어먹기");
		list.add(lt);
		
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("2016-06-05", lt);
		
		System.out.println(hm);
		
	}

}
