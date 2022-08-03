package ex16_interface;

public class Person {

	public void foodFeed (Pet pet, String food) {		
		System.out.println(pet.getPetName() + "에게" + food + "주기");		
	}
	
	public void walk(Walkable pet) {
		System.out.println(((Pet)pet).getPetName() + "와 산책");
	}
}
