package cotroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.BoardAddService;
import service.BoardDetailService;
import service.BoardEditService;
import service.BoardListService;
import service.BoardModifyService;
import service.BoardService;

@WebServlet({ "/BoardController", "*.do" })
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청/ 응답 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 요청 확인
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlMapping = requestURI.substring(contextPath.length() +1);
		
		// BoardService 선언
		BoardService service = null;
		
		// ActionForward 선언
		ActionForward af = null;
		
		// 요청(urlMapping)에 따른 Service 생성
		switch(urlMapping) {
		// 비지니스 로직이 있는 경우  (해당 비지니스 로직을 위한 서비스 생성이 필요함)
		case "board/list.do" : 
			service = new BoardListService();
			break;
		case "board/detail.do" :
			service = new BoardDetailService();
			break;
		case "board/add.do" : 
			service = new BoardAddService();
			break;
		case "board/edit.do" : 
			service = new BoardEditService();
			break;
		case "board/modify.do" :
			service = new BoardModifyService();
			break;
		
		// 비지니스 로직이 없는 경우 (단순 이동)
		case "board/write.do" : 			// 단순 이동이기 때문에 액션포워드만
			af = new ActionForward();
			af.setView("/board/write.jsp");
			af.setRedirect(false);			// 단순 이동은 forward
			break;
		}
		
		// Service 실행
		try {
			if(service != null) {
				af = service.execute(request, response);
			}			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// 어디로 어떻게 ?
		if(af != null) {
			if(af.isRedirect()) {
				response.sendRedirect(af.getView());
			} else {
				request.getRequestDispatcher(af.getView()).forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
