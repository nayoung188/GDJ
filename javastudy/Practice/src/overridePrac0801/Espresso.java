package overridePrac0801;

public class Espresso extends Coffee{
	
	private String been;
	private int water;
	
	public Espresso(String been, int water) {
		this.been = been;
		this.water = water;
	}
	
	public void info() {
		System.out.println(been + "원두, 물" + water + "ml");
	}


}
