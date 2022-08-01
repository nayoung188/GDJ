package ex06_constructor;

public class StudentMain {

	public static void main(String[] args) {
		
		Student student = new Student("tom", "goodee");
		System.out.println(student.getName());
		System.out.println(student.getSchool());
		
		Alba alba = new Alba("jessica","seoul univ","library");
		System.out.println(alba.getName());
		System.out.println(alba.getSchool());
		System.out.println(alba.getAlba());


	}

}
