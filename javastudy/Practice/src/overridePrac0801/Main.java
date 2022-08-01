package overridePrac0801;

public class Main {

	public static void main(String[] args) {
		
		
		Espresso espresso = new Espresso("케냐", 50);
		espresso.info();
		
		Americano americano = new Americano("케냐", 300, "아이스");
		americano.info();

	}

}
