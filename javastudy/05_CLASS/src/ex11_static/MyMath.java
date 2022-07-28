package ex11_static;

public class MyMath {
	
	// static
	// 1. 정적 요소
	// 2. 객체 생성 이전에 메모리에 미리 만들어 지는 공유 요소
	// 3. 클래스에서 1개만 만들어 짐
	// 4. 클래스를 이용해서 호출하기 때문에 클래스 변수(필드), 클래스 메소드라고 부름
	
	
	// 필드
	public static final double PI = 3.141592;  // final = 값 변경 불가

	
	// 메소드
	public static int abs(int n) {
		return ( n >= 0 ) ? n : - n;
	}
	
	public static int pow (int a,int c) {
		// a의 b제곱 반환
		// for문 구현
		int result = 1;
		for (int cnt = 0; cnt < c; cnt++) {
			result *= a ;
		}
		return result;
		
	}

	
	
	
	
	
}
