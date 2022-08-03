package ex01_setter;

public class Main {

	public static void main(String[] args) {
	
		// Bean - 값을 가지고 있는 객체
		
		User user = new User();
		user.setUserNo(1);
		user.setId("admin");
		user.setEmail("admin@naver.com");
		
		System.out.println(user);
		
	}

}
