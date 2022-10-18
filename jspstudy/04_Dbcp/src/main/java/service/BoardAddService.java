package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Board;
import repository.BoardDao;

public class BoardAddService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 요청 파라미터
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// DB로 보낼 board 생성
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		
		// DB로 Board 보냄 (삽입)
		int result = BoardDao.getInstance().insertBoard(board);			// 0이면 삽입 실패, 1이면 삽입 성공
		
		// 삽입 성공,실패 처리는 하지 않음
		System.out.println("삽입 결과 : " + result);
		
		// 어디로 어떻게 
		ActionForward af = new ActionForward();
		af.setView(request.getContextPath()+ "/board/list.do");		// Redirect할 때는 대부분 매핑으로 요청한다 
		af.setRedirect(true);		// 리다이렉트 하겠다는 뜻 / INSERT, UPDATE, DELETE 이후에는 Redirect
		return af;
	}

}
