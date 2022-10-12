package ex09_cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookieServlet2")
public class CookieServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 쿠키 가져오기
		Cookie[] cookies = request.getCookies();
		
		// 쿠키 확인
		for(int i = 0; i < cookies.length; i++) {   // 전체 쿠키 조회하는 for문
			if(cookies[i].getName().equals("name")) {   // 원하는 쿠키만 조회하는 if문
				out.println("<h1>쿠키이름 : " + cookies[i].getName() + "</h1>");
				out.println("<h1>쿠키값 : " + URLDecoder.decode(cookies[i].getValue(), "UTF-8")); 
			}
		}
		
		out.println("<a href=\"/01_Servlet/CookieServlet3\">이동</a>");
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
