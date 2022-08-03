package ex14_interface;

public interface Shape {
	
	// final 상수
	public final static double PI = 3.141592;  // static 생략 가능
	
	// 추상 메소드
	public double getArea();    // public, abstract 생략 가능
	
	
	// default 메소드 ( 본문이 있는 메소드)
	public default void message() {
		System.out.println("나는 도형이다.");
	}
	

}
