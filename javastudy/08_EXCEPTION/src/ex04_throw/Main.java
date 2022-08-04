package ex04_throw;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// throw
		// 1. 예외 객체를 만들어서 직접 throw할 수 있다.
		// 2. 자바는 예외로 인식하지 않지만 실제로는 예외인 경우에 주로 사용된다.
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("나이 입력 >>> ");
			String strAge = sc.nextLine();
			int age = Integer.parseInt(strAge);
			if(age < 0 || age > 100 ) {
				throw new RuntimeException("나이는 0이상 100이하만 가능합니다.");  //메세지는 객체 e에 있다. String message; 에 저장이 되었기 때문에
			}
			System.out.println(age >= 20 ? "성인" : "미성년자");
		} catch (Exception e) {
			System.out.println(e.getMessage());    // get.message 로 호출 가능
		} finally {
			sc.close();    // 실제로 finally는 자원을 반납할 때 주로 사용됨
			System.out.println("finally 블록 실행");
		}
	}

}
