package prac0729;

import java.util.Scanner;

public class prac01 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요 >>> ");
		int score = sc.nextInt();
		System.out.print("학년을 입력하세요 >>> ");
		int grade = sc.nextInt();

		if ( (grade < 4 && score >= 60) || ( grade == 4 && score >= 70)){
			System.out.println("합격!");
		} else { 
			System.out.println("불합격!");
		}

	}

}
