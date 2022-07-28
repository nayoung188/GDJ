package ex01_is_a;


// 서브클래스 
// extends 키워드를 사용
// 슈퍼클래스 Person의 모든 메소드를 자기것처럼 사용
// 상속의 단계는 끊임없이 생성 가능, 후손은 모든 상위 슈퍼클래스 사용이 가능하다


public class Student extends Person {
	// is a 관계가 성립할 때 상속 가능
	
	public void study() {
		System.out.println("공부한다");
	}
	
	
	
	

}
