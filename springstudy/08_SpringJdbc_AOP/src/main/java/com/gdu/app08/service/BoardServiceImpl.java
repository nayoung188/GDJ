package com.gdu.app08.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app08.domain.BoardDTO;
import com.gdu.app08.repository.BoardDAO;

@Service // 컴포넌트로 등록
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO dao;

	@Override
	public List<BoardDTO> findAllBoards() {
		return dao.selectAllBoards();
	}

	@Override
	public BoardDTO findBoardByNo(int board_no) {
		return dao.selectBoardByNo(board_no);
	}

	@Override
	public int saveBoard(BoardDTO board) {
		return dao.insertBoard(board);
	}

	@Override
	public int modifyBoard(BoardDTO board) {
		return dao.updateBoard(board);
	}

	@Override
	public int removeBoard(int board_no) {
		return dao.deleteBoard(board_no);
	}
	
	@Override
	public void testTransaction() {
		// 성공
		dao.insertBoard(new BoardDTO(0, "트랜잭션제목","트랜잭션내용","트랜잭션작성자", null, null));
		
		// 실패
		dao.insertBoard(new BoardDTO());			// Exception이 발생하는 상황 연출		
		
		
		// 트랜잭션이 정상적으로 동작한다면, 
		// 둘다 실패해야 한다. 
	}
	

}
