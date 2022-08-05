package parking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ParkingLot {
	
	
	private String name;
	private Car[] cars;
	private int idx;
	private Scanner sc;
	
	
	public ParkingLot(String name) {
		this.name = name;
		cars = new Car[10];
		sc = new Scanner(System.in);			
	}

	public void addCar() throws RuntimeException{
		System.out.println("현재 등록된 차량 " + idx + "대");
		if ( idx == cars.length) {
			throw new RuntimeException("Full");
		}
		System.out.println("차량번호 >>> ");
		String carNo = sc.next();
		System.out.print("차량모델 >>> ");
		String model = sc.next();
		Car car = new Car(carNo,model);
		cars[idx++] = car;
		System.out.println("차량번호 " + carNo + "차량이 등록되었습니다.");
	}
	
	
	public void deleteCar() throws RuntimeException{
		if (idx == 0) {
			throw new RuntimeException("EMPTY");
		}
		System.out.println("제거할 차량번호 >>> ");
		String carNo = sc.next();
		for( int i = 0; i < idx; i++) {
			if( cars[i].getCarNo().equals(carNo)) {
				System.arraycopy(cars, i + 1, cars, i, idx - i - 1);
				cars[--idx] = null;
				System.out.println("차량번호 " + carNo + "차량이 삭제되었습니다.");
				return;
			}
		}
		System.out.println("대상 차량이 존재하지 않습니다.");	
	}
	
	
	
	public void printAllCars() throws RuntimeException{

		if (idx == 0) {
			throw new RuntimeException("EMPTY");
		}
		System.out.println(name + "차량 목록");
		for( int i = 0 ; i < idx; i++) {
			System.out.println(cars[i]);
		}
	}
	
	
	public void manage() {
		
		while(true) {
			try {
				System.out.println("1.추가 2.삭제 3.전체 0.종료");
				int choice = sc.nextInt();
				sc.nextLine();
				
				switch(choice) {
				case 1 : addCar(); break;
				case 2 : deleteCar(); break;
				case 3 : printAllCars(); break;
				case 0 : System.out.println("주차관리 시스템을 종료합니다."); return;
				default : System.out.println("존재하지 않는 메뉴입니다.");
				}
			} catch (InputMismatchException e) {
				sc.next();
				System.out.println("처리 명령은 정수 1~3 , 0 입니다.");
			} catch ( RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
