package prac0729;

import java.util.Scanner;

public class prac06 {

	public static void main(String[] args) {
		
	
		String[] yut = {"", "도", "개", "걸", "윷", "모"};
		
		int total = 0;
		
		while(true) {
			
			int move = (int)(Math.random() * 5 ) + 1;
			total += move;
			if( move <= 3) {
				System.out.println(yut[move] + "," + total + "칸 움직인다.");
			break;
			} else {
				System.out.println(yut[move] + ",");
			}
			
		}
		
		

	}

}
