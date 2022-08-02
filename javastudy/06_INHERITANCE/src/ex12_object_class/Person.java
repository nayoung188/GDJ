package ex12_object_class;

public class Person {
	
	private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void eat() {
		System.out.println("먹는다.");
	}
	
	@Override
	public String toString() {
		return "이름 : " + name;     // System.out.println(person); 에서 사용됨
	}
	// 디버깅용도로 많이 사용됨
	
	
	
	@Override
	public boolean equals(Object anObject) {         // p1.equals(p2) 에서 사용됨
		Person p = (Person) anObject;
		return name.equals(p.name);
	}
	
	

}
