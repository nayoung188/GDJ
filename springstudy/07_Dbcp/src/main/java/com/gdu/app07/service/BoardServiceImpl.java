package com.gdu.app07.service;

import java.util.List;

import com.gdu.app07.domain.BoardDTO;
import com.gdu.app07.repository.BoardDAO;

public class BoardServiceImpl implements BoardService {
	

	private BoardDAO dao;
	
	
	// 생성자의 매개변수 BoardDAO dao로 new BoardDAO()가 주입되고 있다.
	// BoardAppContext.java를 참고
	public BoardServiceImpl(BoardDAO dao) {   // @Autowired특성상 생성자에서는 생략 가능하다
		super();
		this.dao = dao;
	}

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

}
