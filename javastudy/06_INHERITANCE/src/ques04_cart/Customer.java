package ques04_cart;

public class Customer {

	private int money;
	private int bonusPoint;
	private int total;
	private Product[] cart = new Product[10];
	private int idx;  // cart에 담긴 Product의 개수, cart 배열의 인덱스

	// 생성자 생략
	// new Customer() 가능
	
	// 메소드 setMoney를 따로 만들지 않고 Getter Setter를 만든다
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	
	// buy() 메소드
	public void buy ( Product product) {
		int price = product.getPrice();
		// 가진 돈보다 비싼 물건은 못 산다.
		if(money < price) {
			System.out.println("돈이 " + (price - money) + "원 부족합니다.");
			return;
		}
		// 카트가 가득 차면 물건을 못 산다.  ( 현재 조건인 10개 보다 못산다.)
		if (idx == cart.length) {
			System.out.println("카트가 가득 찼습니다.");
			return;
		}
		
		// 구매
		cart[idx++] = product;   //cart[0]에 넣은 후 늘리는 후위연산
		total += price;
		money -= price;
		bonusPoint += price * 0.1;
	}
	
	//receipt() 메소드
	public void receipt() {
		// 물건을 안 샀다.
		if(idx == 0) {
			System.out.println("구매한 물건이 없습니다.");
			return;
		}
		// 구매 총액 구하기 및 출력하기
		for(int i = 0; i < idx; i++) {   
			Product product = cart[i];
			System.out.println(product.getName() + "\t" + product.getPrice() + "원");
		}
		System.out.println("-----------------------");
		System.out.println("구매총액 " + total + "원");
		System.out.println("보너스 " + bonusPoint + "원");
		System.out.println("남은돈 " + money + "원");
	}

}
