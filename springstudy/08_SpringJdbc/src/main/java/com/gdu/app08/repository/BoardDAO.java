package com.gdu.app08.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gdu.app08.domain.BoardDTO;

@Repository		// 컴포넌트로 등록   ( 서블릿 컨택스트가 인식하여 빈으로 등록해줌 )
public class BoardDAO {
	
	// JdbcTemplate
	// Connection, PreparedStatement, ResultSet을 내부에서 사용하는 스프링 클래스
	// DriverManagerDataSource에 의해서 Connection Pool 방식으로 동작
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<BoardDTO> selectAllBoards() {
		String sql = "SELECT BOARD_NO, TITLE, CONTENT, WRITER, CREATE_DATE, MODIFY_DATE FROM BOARD ORDER BY BOARD_NO DESC";
	      return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BoardDTO.class));
	}

	
	public BoardDTO selectBoardByNo(final int board_no) {			// 예전에 매개변수 해킹 시도가 있었기 떄문에 final사용
		String sql = "SELECT BOARD_NO, TITLE, CONTENT, WRITER, CREATE_DATE, MODIFY_DATE FROM BOARD WHERE BOARD_NO = ?";
		BoardDTO board = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BoardDTO.class), board_no);
		return board;
	}
	
	public int insertBoard(BoardDTO board) {
		return 0;
	}
	
	public int updateBoard(BoardDTO board) {
		return 0;
	}	
	
	
	public int deleteBoard(int board_no) {
		return 0;
	}	

}
