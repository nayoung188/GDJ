package ex01_branch;

public class Ex01_If {

	public static void main(String[] args) {
		
		// if문
		// 조건을 만족하는 경우에만 실행
		// if(조건) {
		// 	   실행문
		// }
		
		
		
		int score = 80;
		
		if(score >= 60) {
			System.out.println("합격");
			System.out.println("축하합니다.");
		}
		
		if(score < 60) {
			System.out.println("불합격");
		}

	}

}
