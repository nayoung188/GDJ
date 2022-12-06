package ex02_lambda.sec04;

public class Main {

	public static void main(String[] args) {
		
		
		Soil soil = new Soil();
		
		// 어떤 자동차가 오는지 임시객체를 만들어 주어야 함
		soil.sellOil(new Car() {
			@Override
			public void addOil() {
				int oil = 30;
				soil.setTotalOil(soil.getTotalOil() - oil);
				soil.setEarning(soil.getEarning() + oil * soil.getPayPerLiter());
				System.out.println("감사합니다 BMW");
			}
		});
		
		soil.sellOil(() -> {
			int oil = 50;
			soil.setTotalOil(soil.getTotalOil() - oil);
			soil.setEarning(soil.getEarning() + oil * soil.getPayPerLiter());
			System.out.println("감사합니다 소나타");
		});
		
		//List<String> list = Arrays.asList("a", "b", "c");
		//Stream<String> stream = list.forEach(("a"));
		
		System.out.println(soil.getTotalOil());
		System.out.println(soil.getEarning());

	}

}
