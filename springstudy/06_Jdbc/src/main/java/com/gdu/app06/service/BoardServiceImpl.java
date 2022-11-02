package com.gdu.app06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.app06.domain.BoardDTO;
import com.gdu.app06.repository.BoardDAO;

//서비스가 사용하는 전용 컴포넌트 .. @Service

/*
	@Service
	안녕. 난 Servoice에 추가하는 @Component애너테이션이야.
	servlet-context.xml에 등록된 <context:component-scan> 태그에 의해서 bean으로 검색되지
	root-context.xml이나 @Configuration에 @Bean으로 등록하지 않아도 컨테이너에 만들어져
*/

@Service		// Service가 사옹하는 @Component
public class BoardServiceImpl implements BoardService {
	
	// Service는 언제나 DAO를 사용합니다.
	@Autowired		// 컨테이너에 생성된 Bean중에서 BoardDAO타입 bean을 가져오시오
	private BoardDAO dao;		// 현재 null값이 아니다
	

	@Override
	public List<BoardDTO> findAllBoards() {
		return dao.selectAllBoards();
	}

	@Override
	public BoardDTO fineBoardByNo(int board_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveBoard(BoardDTO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyBoard(BoardDTO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeBoard(int board_no) {
		// TODO Auto-generated method stub
		return 0;
	}

}
