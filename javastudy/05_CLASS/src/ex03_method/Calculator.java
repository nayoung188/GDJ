package ex03_method;

public class Calculator {

	
	// 메소드 (Method)
	// 함수의 개념과 동일
	// 클래스 내부에 포함된 함수는 메소드라고 부름
	
	
	// 계산 기능 (메소드)
	
	// add 메소드 정의
	// 1. int : 반환타입 (add 메소드를 실행하면 int 타입의 결과값이 반환된다.)
	// 2. add : 메소드명 (마음대로 지으면 됨)
	// 3. int a, int b : 매개변수(add 메소드를 호출할 때는 int 타입의 값 2개가 전달되어야 한다.
	int add(int a, int b) {
		int result = a + b;
		return result;    //반환값
	}
	
	
	//sub 메소드 정의
	int sub(int a, int b) {
		int result = a - b;
		return result;
	}
	// mul 메소드 정의
	int mul(int a, int b) {
		int result = a * b;
		return result;
	}
	// div 메소드 정의 ( div(7,2) --> 3.5 )
	double div(int a, int b) {
		double result = (double)a / b;
		return result;
	}
	
}
