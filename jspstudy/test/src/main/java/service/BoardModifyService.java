package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Board;
import repository.BoardDao;

public class BoardModifyService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Board board = new Board();
		board.setBoardNo(boardNo);
		board.setTitle(title);
		board.setContent(content);
		
		int result = BoardDao.getInstance().updateBoard(board);
		
		PrintWriter out = response.getWriter();
		if (result > 0) {
			out.print("<script>");
			out.print("alert('수정성공')");
			out.print("location.href='" + request.getContextPath() + "/board/detail.go?boardNo=" + boardNo + "'");
			out.print("</script>");
		}
		out.close();
		
		return null;
	}

}
