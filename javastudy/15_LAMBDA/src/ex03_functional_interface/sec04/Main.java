package ex03_functional_interface.sec04;

public class Main {

	public static void main(String[] args) {
		
		Calculator calc = (a, b) ->  a + b;
		System.out.println(calc.add(1, 1));
	}

}
