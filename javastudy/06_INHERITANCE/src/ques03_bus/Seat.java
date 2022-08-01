package ques03_bus;

public class Seat{

	// Person, Student, Alba를 모두 저장할 수 있는 타입은 Person
	private Person person;

	
	// Seat 생성자를 생락하면
	// public Seat() {}    -> 디폴트 생성자가 사용됨
	// new Seat()를 이용한 시트 생성이 가능함
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	
	

}
