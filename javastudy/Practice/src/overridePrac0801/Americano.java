package overridePrac0801;

public class Americano extends Espresso{

	private String ice;
	
	
	public Americano(String been, int water, String ice) {
		super(been, water);
		this.ice = ice;
	}
/*
	@Override
	public void info() {
		System.out.println( super.info() + ice + "아메리카노");
	}
	
*/
}
