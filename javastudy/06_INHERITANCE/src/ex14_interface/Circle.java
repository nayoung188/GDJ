package ex14_interface;

public class Circle implements Shape{
	
	private double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return PI * Math.pow(radius, 2);     // PI는 intetface final에 선언해둔 값
	}
	
	

}
