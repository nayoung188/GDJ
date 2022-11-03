package com.gdu.app06.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.management.remote.rmi.RMIIIOPServerImpl;

import org.springframework.stereotype.Repository;

import com.gdu.app06.domain.BoardDTO;

// @Component			// 빈으로 만들어두라는 뜻  (서블릿 컨텍스에 컴포넌트 스캔에 있는 것들만 동작이 가능하다)

/*
	@Repository	
	안녕. 난 DAO에 추가하는 @Component애너테이션이야.
	servlet-context.xml에 등록된 <context:component-scan> 태그에 의해서 bean으로 검색되지
	root-context.xml이나 @Configuration에 @Bean으로 등록하지 않아도 컨테이너에 만들어져
*/
// 다오는 컴포ㅌ넌트가 따로 만들어져있는데 그것이 .. 다오의 전용 컴포넌트이다 
@Repository			// DAO가 사용하는 @Component로 트랜잭션 기능이 추가되어있어
public class BoardDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	
	// private 메소드
	// 이 메소드는 BoardDAO에서만 사용된다.
	private Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SCOTT","TIGER");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	
	private void close() {
		try {
			if(rs != null) {rs.close();}
			if(ps != null) {ps.close();}
			if(con != null) {con.close();}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 레파지토리 계층의 이름은 "DB 친화적으로" 작성
	
	public List<BoardDTO> selectAllBoards(){
		List<BoardDTO> boards = new ArrayList<BoardDTO>();
		try{
			con = getConnection();
			sql = "SELECT BOARD_NO, TITLE, CONTENT, WRITER, CREATE_DATE, MODIFY_DATE FROM BOARD ORDER BY BOARD_NO DESC";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {			//검색되면 true이기 때문에 while문으로 들어와서 select문 순서대로 값을 낸다
				BoardDTO board = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				boards.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return boards;
	}
	
	
	public BoardDTO selectBoardByNo(int board_no) {
		BoardDTO board = null;
		try {
			con = getConnection();
			sql = "SELECT BOARD_NO, TITLE, CONTENT, WRITER, CREATE_DATE, MODIFY_DATE FROM BOARD WHERE BOARD_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, board_no);
			rs = ps.executeQuery();
			if(rs.next()) {
				board = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return board;
	}
	
	public int insertBoard(BoardDTO board) {
		int result = 0;
		try {
			con = getConnection();
			sql = "INSERT INTO BOARD(BOARD_NO, TITLE, CONTENT, WRITER, CREATE_DATE, MODIFY_DATE)" 
			    + " VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, TO_CHAR(SYSDATE, 'YYYY-MM-DD'), TO_CHAR(SYSDATE, 'YYYY-MM-DD'))";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getContent());
			ps.setString(3, board.getWriter());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public int updateBoard(BoardDTO board) {
		int result = 0;
		try {
			con = getConnection();
			sql = "UPDATE BOARD " 
				+ "SET TITLE = ?, CONTENT = ?, MODIFY_DATE = TO_CHAR(SYSDATE, 'YYYY-MM-DD') "
				+ "WHERE BOARD_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getContent());
			ps.setInt(3, board.getBoard_no());
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}	
	
	
	public int deleteBoard(int board_no) {
		int result = 0;
		try {
			con = getConnection();
			sql	= "DELETE FROM BOARD WHERE BOARD_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, board_no);
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}	
	
	
	// 보드다오가 클래스로 (객체, 컨테이너의 빈으로) 등록되고자 한다. 그동안은 1.루트컨텍스트에 빈 추가, 2. 컨피규레이션에 빈추가 두가지 방법이 있었다
	// 3번째 방법 :  이 보드를 컴포넌트라고 알려준다   
	
	
}
