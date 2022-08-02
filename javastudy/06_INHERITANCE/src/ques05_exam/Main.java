package ques05_exam;

public class Main {

	public static void main(String[] args) {


		Exam exam = new Exam("중간고사");
		exam.setScore();       // 국, 영, 수 점수 0~100 사이 랜덤 생성
		
		Student student = new Student("emily");
		
		student.setExam(exam);
		
		student.info();
		// 학생이름 : emily
		// 중간고사 성적
		// 국어 : 50, 영어 : 50, 수학 : 50, 총점 : 150, 평균 : 50.0점


	}

}
