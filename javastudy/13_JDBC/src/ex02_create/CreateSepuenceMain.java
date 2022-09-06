package ex02_create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateSepuenceMain {

	public static void main(String[] args) {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			
			// OracleDriver 로드
			Class.forName("oracle.jdbc.OracleDriver");
			
			// Connectioin 생성
			String url = "jdbc:oracle:thin:@localhost:1521:xe";  
		    String user = "scott";     
		    String password = "TIGER";
		    con = DriverManager.getConnection(url, user, password);
		    
		    // 쿼리문 작성
			String sql = "CREATE SEQUENCE BOARD_SEQ NOCACHE";
			
			// PreparedStatement 객체 생성
			ps = con.prepareStatement(sql);
			
			// 쿼리문 실행
			ps.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			// Connection 닫기, PreparedStatement 닫기 
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}	

	}

}
