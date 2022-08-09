package prac03;

public class Main {

	public static void main(String[] args) {
		
		
		Bakery paris = new Bakery(500, 100, 10000);     // 빵 1개 500원, 빵 100개, 자본금 10000원
		Bakery tour = new Bakery(1000, 50, 10000);		// 빵 1개 1000원, 빵 50개, 자본금 10000원
		
		Customer customer = new Customer(20000);    // 20000원 가진 고객
		
		try {
			// customer.buy(paris, 30000); 	// 구매 불가
			// customer.buy(tour, 500);		// 판매 불가
			customer.buy(paris, 10000);    // 구매한 빵 20개, 남은 돈돈 10000원
			customer.buy(tour, 5000);     // 구매한 빵 25개, 남은 돈 5000원
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		paris.info();    // 빵 80개, 자본금 20000원
		tour.info();     // 빵 45개, 자본금 15000원
		

	}

}
