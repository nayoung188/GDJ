package quiz04_employee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Company {
	
	private Employee[] employees;
	private int idx;
	private Scanner sc;
	
	
	public Company() {
		employees = new Employee[5];
		sc = new Scanner(System.in);
	}
	
	
	public void addEmployee() throws EmployeeException {
		if ( idx == employees.length) {
			throw new EmployeeException("FULL" , 1);
		}
		System.out.print("고용 형태 선택 (1.정규직 2.비정규직)");
		int kind = sc.nextInt();
		System.out.print("신규 사원번호 >>> ");
		int empNo = sc.nextInt();
		System.out.println("신규 사원명 >>> ");
		String name = sc.next();
		switch(kind) {
		case 1 : 
			System.out.print("기본급 >>> ");
			int salary = sc.nextInt();
			employees[idx++] = new Regular(empNo, name, salary);
			break;
		case 2 : 
			System.out.print("시급 >>> ");
			double hourPay = sc.nextDouble();
			System.out.print("근무시간 >>> ");
			int workTimes = sc.nextInt();
			Temporary temporary = new Temporary(empNo, name);
			temporary.setHourPay(hourPay);
			temporary.setWorkTimes(workTimes);
			employees[idx++] = temporary;
			break;
		default : throw new EmployeeException("잘못된 명령", 3);
		}
		System.out.println("사원 등록 완료. 현재 등록된 사원 " + idx + "명");
		
	}
	
	public void dropEmployee() throws EmployeeException {
		if ( idx == 0) {
			throw new EmployeeException("EMPTY", 2);
		}
		System.out.print("삭제할 직원의 번호 >>> ");
		int empNo = sc.nextInt();
		for( int i = 0 ; i < idx; i++) {
			if ( empNo == employees[i].getEmpNo()) {
				System.arraycopy(employees, i+1, employees, i, idx - i - 1);
				employees[--idx] = null;
				System.out.println("사원 삭제 완료. 현재 등록된 사원" + idx + "명");
				return;
			}
		}
		throw new EmployeeException("해당 사원 없음", 4);
	}
	
	public void findEmployee() throws EmployeeException {
		if ( idx == 0) {
			throw new EmployeeException("EMPTY", 2);
		}
		System.out.println("조회할 직원번호 입력 >>> ");
		int empNo = sc.nextInt();
		for (int i = 0 ; i < idx; i++) {
			if ( empNo == employees[i].getEmpNo()) {
				System.out.println("사원 조회 완료. 조회된 사원 정보");
				System.out.println(employees[i]);
				return;
			}
		}
		throw new EmployeeException("해당 사원 없음", 4);
	}
	
	public void printAllEmployees() throws EmployeeException {
		if ( idx == 0) {
			throw new EmployeeException("EMPTY", 2);
		}
		int total = 0;
		System.out.println("전체 사원 목록 (" + idx + "명)");
		for(int i = 0; i < idx; i++) {
			System.out.println(employees[i] + "[Pay : " + employees[i].getPay() + "]");
			total += employees[i].getPay();
		}
		System.out.println("Total salary " + total);
		
	}
	
	
	public void manage() {
		while (true) {
			try {
				System.out.println("1.추가 2.삭제 3.조회 4.전체조회 0.종료 >>> ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1 : addEmployee();break;
				case 2 : dropEmployee();break;
				case 3 : findEmployee();break;
				case 4 : printAllEmployees();break;
				case 0 : System.out.println("시스템을 종료합니다."); return;
				default : throw new EmployeeException("잘못된 요청", 3);
				}
			}catch (EmployeeException e) {
				System.out.println(e.getMessage() + " , " + e.getErrorCode());
			}catch (InputMismatchException e) {
				sc.next();
				System.out.println("명령은 정수로 입력");
			}catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
	}
		
}
