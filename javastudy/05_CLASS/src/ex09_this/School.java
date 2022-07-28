package ex09_this;

public class School {

	
	
	
	// 필드
	private Student[] students;
	private int idx;    // students 배열의 인덱스이면서 students 배열에 저장된 학생수와 같다.
	
	
	// 생성자
	public School(int cnt) {
		students = new Student[cnt];
	}
	
	
	// 메소드
	public void addStudent(Student student) {
		if ( idx == students.length ) {
			System.out.println("Full");
			return;
		}
		students[idx++] = student;
		// idx++;  가능	
	}
		
}

	/*
	
	 //위의 코드와 동일하다.
	 
	  if ( idx == students.length ) {
			System.out.println("Full");
		} else {
		students[idx++] = student;
		}
	 
	
	
	
	// 정보확인 방법 : getter (읽어오는것) / print 사용
	
	//일반 for문 활용 출력방법
	/*
	public void printStudents() { 
		for ( int i = 0; i < idx; i++) {
			System.out.println(students[i].getName() + ", " + students[i].getStuNo());
		}
	}
	*/
	/*
	// 향상 for문 활용방법
	for(Student student : students) {
		if( student != null) {
		System.out.println(student.getName() + ", " + student.getStuNo());
		}	
	
	*/
	
	

   



