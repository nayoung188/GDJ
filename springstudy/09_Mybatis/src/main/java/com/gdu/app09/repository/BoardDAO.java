package com.gdu.app09.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdu.app09.domain.BoardDTO;

@Repository		// 컴포넌트로 등록   ( 서블릿 컨택스트가 인식하여 빈으로 등록해줌 )
public class BoardDAO {
	
	// SqlSessionTemplate
	// Mybatis에서 지원하는 매퍼 처리 클래스
	
	@Autowired
	private SqlSessionTemplate sqlsessionTemplate;

	public List<BoardDTO> selectAllBoards() {
		return sqlsessionTemplate.selectList("mybatis.mapper.board.selectAllBoards");
	}

	
	public BoardDTO selectBoardByNo(int boardNo) {		
		return sqlsessionTemplate.selectOne("mybatis.mapper.board.selectBoardByNo", boardNo);
	}
	
	public int insertBoard(BoardDTO board) {
		return sqlsessionTemplate.insert("mybatis.mapper.board.insertBoard" , board);
	}
	
	public int updateBoard(BoardDTO board) {
		return sqlsessionTemplate.update("mybatis.mapper.board.updateBoard", board);
	}	
	
	
	public int deleteBoard(int boardNo) {
		return sqlsessionTemplate.delete("mybatis.mapper.board.deleteBoard", boardNo);
	}	

}
