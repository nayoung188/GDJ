package ex02_is_a;

public class HybridMain {

	public static void main(String[] args) {
		
		
		Hybrid hybrid = new Hybrid();
		hybrid.drive();
		hybrid.charge();
		hybrid.addOil();
		
		Ev ev = new Ev();
		ev.drive();
		ev.charge();
		
		Car car = new Car();
		car.drive();
		
		

	}

}
