package ques01_coffee;

public class Coffee {
	
	
	private String origin;
	


	public Coffee(String origin) {
		super();
		this.origin = origin;
	}

	public void info() {
		System.out.println(origin + "원두");
	}

}
