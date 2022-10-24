package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.MemberAddService;
import service.MemberDetailService;
import service.MemberListService;
import service.MemberService;


@WebServlet({"*.do" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 , 응답 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	
		// 요청 확인
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlMapping = requestURI.substring(contextPath.length());
		
		// StudentService객체
		MemberService service = null;
		
		// ActionForward 객체
		ActionForward af = null;
		
		//요청에 따른 Service 선택
		switch(urlMapping) {
		case "/member/manage.do" :
			af = new ActionForward("/member/manage.jsp", false);
			break;
		case "/member/list.do" : 
			service = new MemberListService();
			break;
		case "/member/detail.do" :
			service = new MemberDetailService();
			break;
		case "/member/add.do" :
			service = new MemberAddService();
			break;
		}
		
		// 선택된 Service 실행
		try {
			if(service != null) {
				service.execute(request, response);		// 서비스는 af를 반환하지 않는 void타입이기 때문에 af= 부분 지워준다
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// 어디로 어떻게 이동하는가
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
