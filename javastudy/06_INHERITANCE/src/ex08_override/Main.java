package ex08_override;

public class Main {

	public static void main(String[] args) {
		
		
		Circle circle = new Circle("도넛", 7.5);
		circle.info();
		
		
		Rectangle rectangle = new Rectangle("사각형", 4, 3);
		rectangle.info();
		
		Square square = new Square("정사각형", 5);
		square.info();
		

	}

}
