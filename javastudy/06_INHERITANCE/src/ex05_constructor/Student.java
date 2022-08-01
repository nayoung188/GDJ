package ex05_constructor;

// 서브클래스는 슈퍼클래스의 생성자를 "반드시" 호출해야 한다.
// ( 자식이 태어나려면 부모가 태어나 있어야 한다.)

public class Student extends Person {
	
	// 개발자가 슈퍼클래스의 생성자를 호출하지 않으면
	// 자동으로 JVM이 호출한다. (디폴트 형식의 슈퍼클래스만 자동 호출 가능)
	
	public Student() {
		System.out.println("Student 생성");
	}
	
	

}
