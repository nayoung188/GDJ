package ex02_casting;

public class Ex02 {

	public static void main(String[] args) {
		
		// 강제 형 변환
		// casting 이라고 한다.
		// 큰 크기의 데이터타입을 작은 크기의 데이터타입으로 변환할 때 강제로 진행한다.
		// 실수를 정수로 변환할 때 강제로 진행한다.
		// 강제로 변환할 변수 앞에 괄호를 붙이고 변환할 데이터타입을 작성한다.
		
		int score = 256;
		byte realScore = (byte)score;
		System.out.println(realScore);
		
		double grade = 4.5;
		int realGrade = (int)grade;
		System.out.println(realGrade);  //소수점은 항상 잘려 나간다.
		
		
		

	}

}
