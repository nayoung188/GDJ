package ex01_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
	     // OracleDriver 열기(메모리에 로드하기)
	     // 1. oracle.jdbc.OracleDriver
	     // 2. orcale.jdbc.driver.OracleDriver
	     try {
	         Class.forName("oracle.jdbc.OracleDriver");
	     } catch(ClassNotFoundException e) {
	         System.out.println("OracleDriver 로드 실패");
	     }
	      
	     // DriverManager로부터 Connection 받아오기
	     Connection con = null;
	     try {
		     String url = "jdbc:oracle:thin:@localhost:1521:xe";      //DB마다 url은 달라짐 (Oracle XE 버전 기준)
		     String user = "scott";         // 대소문자 상관 없음
		     String password = "TIGER";		// 계정 만들 때 사용한 대소문자를 지켜야 함	
		     con = DriverManager.getConnection(url, user, password);
		     System.out.println("DB접속성공");
	     } catch (SQLException e) {
	    	 System.out.println("DB접속정보 오류");
	     }
	     
	     
	     // Connection 종료
	     // JDBC에서는 Connection을 닫는 것이 굉장히 중요!
	     // 특정 메소드를 실행할 때마다 Connection을 열고 닫는다.
	     try {
	    	 if(con != null)
	    	  con.close();
	     } catch(SQLException e) {
	    	 e.printStackTrace(); 
	     }
	}
}
