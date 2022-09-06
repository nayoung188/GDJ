package ex04_update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import domain.Board;

public class UpdateMain {

	public static void main(String[] args) {


		Connection con = null;
		PreparedStatement ps = null;
		
		try {
		
			Scanner sc = new Scanner(System.in);
			
		// UPDATE할 게시글의 번호 입력 받기
			System.out.println("수정할 게시글 번호 >>> ");
			int board_no = sc.nextInt();
			sc.nextLine();
		
		// UPDATE할 게시글의 내용(CONTENT) 입력 받기
			System.out.println("수정할 게시글 내용 >>> ");
			String content = sc.nextLine();
			
		
		// UPDATE할 번호 + 내용을 가진 Board 객체 생성	
			Board board = new Board();
			board.setBoard_no(board_no);
			board.setContent(content);
			
		
		// Connection 생성
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";  
		    String user = "scott";     
		    String password = "TIGER";
		    con = DriverManager.getConnection(url, user, password);
			
		// 쿼리문 작성
			String sql = "UPDATE BOARD SET CONTENT = ? WHERE BOARD_NO = ?";
			
		// PreparedStatement 객체 생성
			ps = con.prepareStatement(sql);
			
		// 쿼리문의 ?에 변수 전달하기
			ps.setString(1, board.getContent());
			ps.setInt(2, board.getBoard_no());
			
		// 쿼리문 실행
			int result = ps.executeUpdate();
			
			
		// 실행 결과
		// 업데이트 성공, 업데이트 실패
			if(result>0) {
				System.out.println("업데이트 성공");
			} else {
				System.out.println("업데이트 실패");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			// con, ps 닫기
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
		

	}

}
