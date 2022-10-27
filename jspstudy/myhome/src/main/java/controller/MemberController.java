package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.MemberService;
import service.MemberServiceImpl;


@WebServlet("*.me")
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
		
		// MemberServisceImpl 객체 생성(
		MemberService service = new MemberServiceImpl();
		
		// ActionForward 객체
		ActionForward af = null;
		
		//요청에 따른 Service 선택 및 실행
		switch(urlMapping) {
		case "/member/login.me" :
			af = service.login(request, response);
			break;
		case "/member/logout.me" :
			af = service.logout(request, response);
			break;
		case "/member/join.me" : 
			af = new ActionForward("/member/join.jsp", false);
			break;
		case "/member/register.me" : 
			service.register(request, response);		// af없이 register() 메소드 내부에서 직접 이동
			break;
		case "/member/cancel.me" :
			service.cancel(request, response);			// af없이 cancel() 메소드 내부에서 직접 이동
			break;
			
			// 매핑 잘못 작성한 경우
			default : 
				System.out.println("매핑을 학인하세요");
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
