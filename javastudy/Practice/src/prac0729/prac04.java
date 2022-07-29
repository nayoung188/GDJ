package prac0729;

import java.util.Scanner;

public class prac04 {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		System.out.print("몇 개의 랜덤을 생성할까요? >>> ");
		int count = sc.nextInt();
		
		if( count < 1 ||  count > 100) {
			System.out.println(("다음에는 1~100 사이로 입력하세요!"));
			return;
		}
		int[] arr = new int[count];
		for( int i = 0; i < arr.length; i++) {
			int random = (int)(Math.random() * 100) + 1;
			arr[i] = random;
		}
		
		for (int i = 0; i <arr.length; i++) {
			if( i != 0 && 1 % 10 == 0) 
				System.out.println();
			System.out.println(arr[i] + " \t");		
		}
		
		
		

	}

}
