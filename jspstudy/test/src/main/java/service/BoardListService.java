package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.BoardDao;

public class BoardListService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("boards", BoardDao.getInstance().selectAllBoards());
		request.setAttribute("count", BoardDao.getInstance().selectAllBoardsCount());
		
		ActionForward af = new ActionForward();
		af.setView("/board/list.jsp");
		af.setRedirect(false);
		return af;
	}

}
