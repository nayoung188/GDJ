package ex01_thread;


// 스레드 (Thread)
// 1. 세부 실행 단위
// 2. 자바 실행의 기본 단위 (main 스레드)
// 3. main 스레드 이외의 스레드 추가 가능

// 스레드 생성
// 1. Thread 클래스 상속
// 2. Runnable 인터페이스 구현

// Thread 클래스 상속
// 1. extends Thread
// 2. Thread 클래스의 public void run() 메소드를 오버라이드해서 수행할 작업 작성

// 스레드 실행
// 1. start() 메소드를 호출
// 2. start() 메소드를 호출하면 run() 메소드에 오버라이드 한 내용이 실행

 

public class Process extends Thread{
	
	private String name;

	public Process(String name) {
		super();
		this.name = name;
	}
	
	
	@Override
	public void run() {
		try {
			
			Thread.sleep(3000);    // 3초 일시중지
			System.out.println(name + "작업실행");
	
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
