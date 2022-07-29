package prac0729;

import java.util.Scanner;

public class prac02 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("무슨커피를 드릴까요? >>> ");
		String menu = sc.next();
		switch (menu) {
		case "에스프레소" : 
		case "카푸치노" :
		case "카페라떼" : System.out.println(menu + "는 3500원입니다."); break;
		case "아메리카노" : System.out.println(menu + "는 2000원입니다.");break;
		default : System.out.println( menu + "는 메뉴에 없습니다.");
		}
		
		
		
		
	}

}
