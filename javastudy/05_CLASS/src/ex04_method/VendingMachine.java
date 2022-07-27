package ex04_method;

public class VendingMachine {

	
	String getCoffee(int money, int button) {
		
		/*
		String getCoffee = button + money;
			int money = (money / 1000) ;
			if( button == 1) {
				System.out.println("아메리카노");
			} else  {
				System.out.println("카페라떼");
			}
		return getCoffee;
		*/
		
		
		/*
		String[] menu = { "아메리카노", "카페라떼"};
		return menu[button - 1] + " " + ( money / 1000) + "잔";
		*/
		
		String[] menu = { "","아메리카노", "카페라떼"};
		return menu[button] + " " + ( money / 1000) + "잔";
	
		
	}
	
}
