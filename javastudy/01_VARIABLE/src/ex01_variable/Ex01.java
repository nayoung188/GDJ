package ex01_variable;

public class Ex01 {

	public static void main(String[] args) {
		
		// single comment - 한 줄짜리 주석 (설명)
		/*
 		     - multiple comment
		     여러 줄의 주석
		 */
		
		
		// 키워드 이름 규칙
		// 1. 패키지 : 모두 소문자 . 실제로는 회사 도메인을 거꾸로 작성한다. (com.samsung.galaxy)
		// 2. 클래스 : 각 단어의 첫 글자만 대문자. 나머지는 소문자 (upper camel case)
		// 3. 변수/메소드 : 첫 글자는 소문자. 이후 단어는 첫글자 대문자 나머지 소문자. (lower camel case)
		// 4. 상수 : 모두 대문자. 언더바(_)로 연결. (snake case)
		
		// main 메소드
		// 1. 자바 프로젝트를 실행할 때 반드시 필요하다.
		// 2. JVM (Java Virtual Machine)은 열려있는 main 메소드를 실행한다.
		// 3. 열려있는 main 메소드가 없으면 최근에 실행한 main 메소드를 실행한다.
		
		// 변수 선언
		// 사용할 변수의 데이터 타입과 이름을 미리 결정해야 한다.
		// 형식
		// 데이터타입 변수명 = 초기값
		
		// 논리 타입
		boolean isGood = true;
		boolean isAlive = false;
		System.out.println(isGood);
		System.out.println(isAlive);
		
		// 문자(Character) 타입 : 1글자를 의미, 2글자 이상은 안됨
		char ch1 = 'A';
		char ch2 = '홍';
		char ch3 = '\n';  //라인 피드 - 줄 바꿈
		char ch4 = '\t';  // 탭
		char ch5 = '\'';  // 작은 따옴표
		char ch6 = '\"';  // 큰 따옴표
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		System.out.println(ch4);
		System.out.println(ch5);
		System.out.println(ch6);
		
		// 정수 타입
		int score = 100;
		long view = 10000000000L;  //long타입의 값은 마지막에 L 또는 l 을 추가해야 한다.
		System.out.println(score);
		System.out.println(view);
		
		// 실수 타입
		double discount = 0.5;
		double pi = 3.1415926535;
		System.out.println(discount);
		System.out.println(pi);
		
		
	}
}
