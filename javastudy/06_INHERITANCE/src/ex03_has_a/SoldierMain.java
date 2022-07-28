package ex03_has_a;

public class SoldierMain {

	public static void main(String[] args) {
		
		
		
		Gun gun = new Gun();
		gun.setModel("K2");
		gun.setBullet(9);
		
		Soldier soldier  = new Soldier();
		soldier.setGun(gun);
		
		
		
		// 캡슐화
		
		
		// soldier가 총을 쏜다.
		soldier.shoot();
		soldier.shoot();
		
		
		// soldier가 장전한다.
		soldier.reload(3);
		
		
		// soldier가 가지고 있는 gun의 model/bullet
		System.out.println("soldier가 가지고 있는 총의 모델 : " + soldier.getGun().getModel());
		System.out.println("soldier가 가지고 있는 총의 탄환수 : " + soldier.getGun().getBullet());

	}

}
