package ex08;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookieServlet3")
public class CookieServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 쿠키 수정하기
		// 같은 이름의 쿠키를 만들어서 덮어쓰기
		Cookie cookie1 = new Cookie("adress", URLEncoder.encode("서울시 금천구 가산동", "UTF-8"));
		cookie1.setMaxAge(60);		// 기존 10초에서 60초로 수정
		response.addCookie(cookie1);
		
		// 쿠키 삭제하기
		// 같은 이름의 쿠키를 만들어서 유효시간을 0으로 설정하고 덮어쓰기
		Cookie cookie2 = new Cookie("name", "");
		cookie2.setMaxAge(0);
		response.addCookie(cookie2);
		
		// location 이동은 리다이렉트와 같음
		out.println("<script>");
		out.println("location.href='/01_Servelt/CookieServlet2'");
		out.println("</script>");
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
