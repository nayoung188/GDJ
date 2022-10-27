package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Board;
import repository.BoardDao;

public class BoardDetailService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("boardNo"));
		int boardNo = Integer.parseInt(opt.orElse("0"));
		
		Board board = BoardDao.getInstance().selectBoardByNo(boardNo);
		
		request.setAttribute("board", board);
		
		ActionForward af = new ActionForward();
		af.setView("/board/detail.jsp");
		af.setRedirect(false);
		return af;
		
		
	}

}
