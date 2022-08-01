package prac0729;

public class SoldierMain {

	public static void main(String[] args) {
		
		Soldier soldier = new Soldier(new Gun("K2", 5), "람보");
		
		soldier.reload(2);
		soldier.shoot();
		
		soldier.reload(10);
		soldier.info();
	
		

	}

}
