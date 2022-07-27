package ex05_method;

public class CarMain {

	public static void main(String[] args) {
		
		
		
		// 객체 생성
		Car car = new Car();
		
		car.addOil(50);
		car.addOil(5);
		car.addOil(100);
		
		car.pushAccel();
		car.pushAccel();
		car.pushAccel();
		car.pushAccel();
		
		car.pushBreak();
		car.pushBreak();
		car.pushBreak();
		
		car.panel();

		
	}

}
