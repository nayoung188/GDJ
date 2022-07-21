package ex02_loop;

public class Ex05_nested_for {

	public static void main(String[] args) {
		
		// 1일차 1교시
		// 1일차 2교시
		// ...
		// 1일차 8교시
		// 2일차 1교시
		// ...
		// 3일차 8교시
		
		
		for (int day = 1; day <= 3; day++) {
			for ( int hour = 1; hour <= 8; hour++) {
				System.out.println(day + "일차" + hour + "교시");
			}
			
		}
		
		//연습
		// 전체 구구단
		// 2x1=2
		// ...
		// 9x9=81
		
		
		/*
		for (int n = 2; n <= 9; n++) {
			for ( int s = 1; s <= 9 ; s++) {
				System.out.println(n + "x" + s + "=" + n * s);
			}
		}
		*/
		
		for(int dan = 2; dan <= 9; dan++) {
			for( int n = 1; n <= 9; n++) {
				System.out.println(dan + "x" + n + "=" + (dan * n));
			}
		}
		
		// 연습
		// 2x1=2
		// 2x2=4
		// ...
		// 5x5=25
		
		for ( int dan = 2; dan <= 5; dan++) {
			for ( int n = 1; n <= 9; n ++) {
				System.out.println(dan + "x" + n + "=" + (dan * n));
				if ( dan == 5 && n == 5) {
					break;
				}
			
			}
		}
		
		
		
		// 라벨 (label)을 이용한 풀이   라벨 : 코드의 위치를 정해줌
		
		outer: for ( int dan = 2; dan <= 9; dan++) {
			for ( int n = 1; n <= 9; n ++) {
				System.out.println(dan + "x" + n + "=" + (dan * n));
				if ( dan == 5 && n == 5) {
					break outer;
				}
			
			}
			
		}
		
		
		// 연습
		// 2x1=2 3x1=3 ... 9x1=9
		// 2x2=4 3x2=6 ... 9x2=18
		
		/*
		
		for ( int n = 1 ; n <= 9; n++) {
			for ( int dan = 2 ; dan <= 9; dan++) {
				
				System.out.print( dan + "x" + n + "=" + (dan * n ) + " " );
				if ( dan == 9) {
					System.out.println();
				}
			}
			
		}
		
		*/
		
		for (int n = 1; n <= 9; n++) {
			for (int dan = 2; dan <= 9; dan++) {
				System.out.print( dan + "x" + n + "=" + (dan * n ) + "\t");
			}
			System.out.println();
		}
			
	
	}

}
