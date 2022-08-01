package ex07_override;

public class Americano extends Espresso {
	
	private int extraWater;
	
	@Override
	public void taste() {
		System.out.println("덜 쓰다");
	}

}
