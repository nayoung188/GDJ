package service;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.BoardDao;

public class BoardRemoveService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("boardNo"));
		int boardNo = Integer.parseInt(opt.orElse("0"));
		
		int result = BoardDao.getInstance().deleteBoard(boardNo);
		
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.print("<script>");
			out.print("confirm('정말 삭제하시겠습니까?')");
			out.print("alert('삭제 성공')");
			out.print("location.href='" + request.getContextPath() + "/board/list.go");
			out.print("</script>");
		}
		out.close();
		
		return null;
	}

}
