package ex07_override;

public class CafeLatte extends Espresso{
	
	private int milk;
	
	@Override
	public void taste() {
		System.out.println("부드럽다");
	}

}
