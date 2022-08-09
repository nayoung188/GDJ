package prac03;


public class Bakery {

	// 필드
	private int price;      // 빵 가격
	private int cnt;        // 빵 개수
	private int money;		// 자본금
	
	// 생성자
	
	public Bakery(int price, int cnt, int money) {
		super();
		this.price = price;
		this.cnt = cnt;
		this.money = money;
	}
	
	
	// 판매 메소드
	public BreadAndChange sell(int custMoney) throws RuntimeException{
	
			// 판매 불가
		if ( custMoney < price) {
			throw new RuntimeException("판매불가");
		}
		
		
		// 판매할 수 있는 빵은 몇 개인가?
		int sellcnt = custMoney / price;
		
		
		// 잔돈은 얼마인가
		int change = custMoney % price;
		
		// 매장 내부의 변화처리
		cnt -= sellcnt;
		money += (custMoney - change);
		
		// 고객에게 되돌려 줄 빵과 잔돈
		return new BreadAndChange(sellcnt, change);
	
		
	}
	
	// 정보 확인
	public void info() {
		System.out.println("빵" + cnt + "개 , 자본금 " + money + "원");
	}
	
	
	
}
