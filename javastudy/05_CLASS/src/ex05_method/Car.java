package ex05_method;

public class Car {

	// 필드와 메소드를 함께 작성시 필드, 메소드 순으로 작성
	
	
	// 필드
	int oil;
	int speed;
	
	
	// 메소드
	
	// 1. 기름 넣기
	// 반환타입 : void ( 반환값이 없다 )
	// 메소드명 : addOil
	// 매개변수 : int o
	void addOil (int o) {
		oil += o;
		if( oil > 60 ) {
			oil = 60;
		}
	}
	
	
	
	// 2. 달리기
	// 반환타입 : void
	// 메소드명 : pushAccel
	// 매개변수 : X      매개변수가 없기 떄문에 괄호도 빈칸
	void pushAccel() {
		if(oil == 0 ) {
			return;      // 반환타입이 void 일때만 사용 가능
		}
		if ( speed == 120) {
			oil--;
			return;       // 속도가 120이면 기름은 줄어든다
		}
		// 속도는 25씩 증가, 최대 속도 120
		// 기름은 1씩 사용
		speed += 25 ;
		if ( speed > 120) {
			speed = 120;
		}
		oil--;
	}
	
	
	
	
	// 3. 멈추기
	// 반환타입 : void
	// 메소드명 : pushBreak
	// 매개변수 : X
	void pushBreak() { 
		if ( speed == 0) {
			return;
		}
		speed -= 25;
		if ( speed < 0 ) {
			speed = 0;
		}
	}
	
	
	// 4. 계기판 (기름, 속도) 확인
	// 반환타입 : void
	// 메소드명 : panel
	// 매개변수 : X
	void panel() {
		System.out.println("기름 : " + oil);
		System.out.println("속도 : " + speed);
	}
	
	
	
	
	
	
	
	
}
