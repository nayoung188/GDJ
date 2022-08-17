package ex01_thread;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("main 시작");
		
		Process process = new Process("연산");		
		process.start();   // Process 클래스의 오버라이드된 run() 메소드가 호출	
		
		Process process2 = new Process("제어");
		process2.start();
		
		
		System.out.println("main 종료");
		
	}

}

