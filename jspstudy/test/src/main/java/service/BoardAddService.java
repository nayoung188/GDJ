package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Board;
import repository.BoardDao;

public class BoardAddService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Board board = new Board();
		board.setWriter(writer);
		board.setTitle(title);
		board.setContent(content);
		
		int result = BoardDao.getInstance().insertBoard(board);
		
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('삽입 성공')");
			out.println("location.href='" + request.getContextPath() + "/board/list.go'");
			out.println("</script>");
		}
		out.close();
		
		return null;
	}

}
