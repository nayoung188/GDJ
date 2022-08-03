package ex15_interface;

public class Main {

	public static void main(String[] args) {

		// 메소드 호출 연습
		Phone p1 = new SmartPhone();
		p1.call();
		p1.sms();
		((Computer)p1).game();       // Computer로 캐스팅 해야 함
		((Computer)p1).internet();
		
		
		Computer p2 = new SmartPhone();
		((Phone)p2).call();        // Phone 으로 캐스팅 해야 함
		((Phone)p2).sms();
		p2.game();
		p2.internet();

	
	}

}
