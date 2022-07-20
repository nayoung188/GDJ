package ex02_casting;

public class Ex03 {

	public static void main(String[] args) {
		
		String strScore = "100";
		String strMoney = "10000000000";
		String strGrade = "4.5";
		
		// 문자열을 숫자데이터로 변환하기
		// 아래 변환은 매우 중요하다.
		int score = Integer.parseInt(strScore);
		long money = Long.parseLong(strMoney);
		double grade = Double.parseDouble(strGrade);
		// 자주 사용하는 코드들이므로 반드시 암기
		
		
		System.out.println(score);
		System.out.println(money);
		System.out.println(grade);
		
		// 숫자데이터를 문자열로 변환하기
		// 100 -> "100" ,  4.5 -> "4.5"
		int age = 100;
		String strAge = String.valueOf(age);
		System.out.println(strAge);
		
		
	}

}
