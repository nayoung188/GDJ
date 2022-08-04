package quiz01_updown;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class UpDownGame {
	
	// 필드 
	private int rand;    // 1~100 사이 난수
	private int count;    // 시도횟수
	private Scanner sc;
	
	
	// 생성자 
	public UpDownGame() {
		// rand, sc 만들기
		rand = (int)(Math.random() * 100 + 1 );
		sc = new Scanner(System.in);
	}
	
	// 입력
	public int input() {
		try {
			count++;
			System.out.println("입력 >>> ");
			int n = sc.nextInt();
			if (n <1 || n > 100) {
				throw new RuntimeException("1~100 사이 정수만 입력할 수 있습니다.");
			}
			return n;
		} catch(InputMismatchException e) {
			System.out.println("정수만 입력할 수 있습니다.");
			sc.next();   // 잘못 입력된 문자열 먹어치우기
			input();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			input();
		}
		return 0;   // 이클립스 안심시키는 용도
	}
	
	
	// 실행
	public void play() {
		while(true) {
			int n = input();
			
			if(n < rand) {
				System.out.println("Up!");
			} else if (n > rand) {
				System.out.println("Down!");
			} else {
				System.out.println(rand + "정답입니다." + count + "번만에 정답");
				break;
			}
		}
		// 맞힐때까지 무한루프
	}

}

/*
		int rand = (int)(Math.random() * 100) + 1;
		
		System.out.println("입력 >>> ");
		sc = new Scanner(System.in);
		int input = sc.nextInt();

		while ( input != rand ) {
			if (input < 0 || input > 100) {
				System.out.println("1~100사이 숫자를 입력해주세요.");
				return;
			} else if ( input < rand ) {
				System.out.println("Up!");
				count++;
			} else if ( input > rand ) {
				System.out.println("Down!");
				count++;
			}
		}
		System.out.println( count + "번만에 정답!");
		sc.close();
 */
