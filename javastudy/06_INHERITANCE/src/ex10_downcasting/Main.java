package ex10_downcasting;

public class Main {

	public static void main(String[] args) {
		
		// 클래스타입 : Person
		// 객체(인스턴스) : p	
		Person p = new Student();    // 업캐스팅
		
		
		// instanceof 연산자
		// 특정 인스턴스가 어떤 클래스타입인지 점검하는 연산자
		// 해당 클래스타입이면 true 반환, 아니면 false 반환
		System.out.println(p instanceof Person);
		System.out.println(p instanceof Student);
		System.out.println(p instanceof Alba);
		
		
		// p가 Student타입의 인스턴스이면 study() 메소드를 호출할 수 있다.
		if(p instanceof Student) {
			((Student) p).study();       // 다운캐스팅 자동완성 ctrl+space
		}
		
		// p가 Alba타입의 인스턴스이면 work() 메소드를 호출할 수 있다.
		if(p instanceof Alba) {
			((Alba) p).work();
		}

	}

}
