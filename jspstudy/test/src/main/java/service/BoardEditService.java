package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.BoardDao;

public class BoardEditService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("boardNo"));
		int boardNo = Integer.parseInt(opt.orElse("0"));
		
		request.setAttribute("board", BoardDao.getInstance().selectBoardByNo(boardNo));
		
		ActionForward af = new ActionForward();
		af.setView("/board/edit.jsp");
		af.setRedirect(false);
		
		return af;
	}

}
