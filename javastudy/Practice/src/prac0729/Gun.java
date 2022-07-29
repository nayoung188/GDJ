package prac0729;

public class Gun {

	
	
	// 필드
	
	private String model;
	private int bullet;
	private final int FULL_BULLET = 6;
	
	
	// 생성자
	
	
	// 모델
	public Gun (String model, int bullet) {
		this.model = model;
		this.bullet = bullet;
	}
	
	
	// 장전
	public void reload(int bullet) {
		this.bullet += bullet;
		if ( this.bullet > FULL_BULLET) {
			this.bullet = FULL_BULLET;
		}
	}
	
	// 발사
	public void shoot() {
		if ( bullet <= 0) {
			System.out.println("총알이 없다.");
			return;     // 반환타입이 void인 메소드를 종료
		}
		bullet --;
		System.out.println("빵! " + bullet + "발 남았다.");
	}
	
	// 조회
	public void info() {
		System.out.println(model + "  ( " + bullet + " )");
	}
	
	
	
}
