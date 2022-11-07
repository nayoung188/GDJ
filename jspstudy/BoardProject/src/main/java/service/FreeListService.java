package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ActionForward;
import repository.FreeDao;

public class FreeListService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("hit") != null) {
			session.removeAttribute("hit");
		}

		FreeDao dao = FreeDao.getInstance();
		request.setAttribute("list", dao.selectAllFrees());
		
		return new ActionForward("/free/list.jsp", false);
	}

}
