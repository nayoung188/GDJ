package ex12_object_class;

public class Main {

	public static void main(String[] args) {
		
		// Object 클래스는 모든 객체(변수)를 저장할 수 있다.
		Object p = new Person();
		
		
		// Object 클래스타입의 객체는
		// 항상 다운캐스팅해서 사용해야 한다.
		if(p instanceof Person) {
			((Person) p).eat();
		}
		
		
		// 새로운 Person ( toString()  확인용)
		Person person = new Person();
		person.setName("james");
		
		System.out.println(person);      //이름 : james
		
		
		
		// 새로운 Person(equals() 확인용)
		// name이 같으면 동일한 객체로 인식하기
		Person p1 = new Person();
		Person p2 = new Person();
		p1.setName("kim");
		p2.setName("kim");
		System.out.println(p1.equals(p2));      // 동일한 name 은 true
		// 내용이 같더라도 참조값의 저장 위치가 다르기 때문에 false
		
		

	}

}
