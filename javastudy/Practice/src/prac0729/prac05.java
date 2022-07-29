package prac0729;

import java.util.Scanner;

public class prac05 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("피카츄의 점수 입력 >>> ");
		int pikaScore = sc.nextInt();
		System.out.print("뽀로로의 점수 입력 >>> ");
		int pororoScore = sc.nextInt();
		System.out.print("브레드의 점수 입력 >>> ");
		int breadScore = sc.nextInt();
		
		System.out.println("평균 : " + (double)(pikaScore+pororoScore+breadScore)/3);
		System.out.println();

	}

}
