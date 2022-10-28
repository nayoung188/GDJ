package com.gdu.app02.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
  
  	@Controller
  	
  	안녕. 난 컨트롤러야.
  	@Component에 의해서 자동으로 Bean으로 만들어지고 스프링에 의해서 사용되지
 */

@Controller
public class MvcController {
	
	// 메소드1개 : 요청 1개와 응답 1개를 처리하는 단위
	
	/*
	 	@RequestMapping
	 	
	 	안녕. 난 요청을 인식하는 애너테이션이야.
	 	매핑과 요청 메소드(GET/POST)를 인식하지
	 	
	 	속성
	 		1) value : URLMapping
	 		2) method : RequestMethod
	  
	 */
	
	// welcome 파일 작업하기
	// URLMapping으로 "/"를 요청하면 "/WEB-INF/views/index.jsp"를 열어준다.
	// 해당 애너테이션은 메소드를 다 만들고 나서 작성해주는 것

	@RequestMapping(value="/", method=RequestMethod.GET)
	
	// 메소드 작성 방법
	// 0. 접근권한 : public
	// 1. 반환타입 : String (응답할 뷰(JSP)의 이름을 반환)
	// 2. 메소드명 : 아무 일도 안함. 맘대로 작성.
	// 3. 매개변수 : 선택(요청이 있으면 request, 응답을 만들면 response 등)
	
	public String welcome() {
		return "index";			// DispatcherServlet의 ViewResolve에 의해서 해석된다.
								// prefix="/WEB-INF/views/"
								// suffix=".jsp"
								// prefix와 suffix에 의해서 "/WEB-INF/views/index.jsp" 와 같이 해석되고 처리된다.
		
		// index.jsp로 forward했을까 redirect 했을까?
		// 정답 : forward 했다
		// redirect 할때는 return "redirect:경로"; 처럼 반환한다.
	}
	
	// <a href=${contextPath}/animal">
	@RequestMapping(value="/animal", method=RequestMethod.GET)
	public String 김양갱() {
		// /WEB=INF/views + gallery/animal + .jsp   => 뷰리졸브가 하는 일
		return "gallery/animal";
	}
	
	
	// @RequestMapping(value="/animal", method=RequestMethod.GET)
	// @RequestMapping(value="animal", method=RequestMethod.GET)		슬래쉬가 없어도 됩니다
	// @RequestMapping(value="/animal")									GET생략 가능 (POST는 있어야한다)
	// @RequestMapping("/animal")										value로 인식한다
	// @RequestMapping("animal")										최종버전
	
	@RequestMapping("flower")
	public String 꽃() {
		
		// return "/gallery/flower"			슬래시가 있어도 된다
		return "gallery/flower";		 // 슬래시가 없어도 된다
	}
	
	
	// <a href="${contextPath}/animal/flower">
	@RequestMapping("animal/flower")
	public String 동물보고꽃보고() {
		
		// redirect: 다음에는 항상 다른 URLMApping을 적어준다.
		return"redirect:/flower";
	}
	
	// <a href="${contextPath }/want/animal?animal=animal5.jsp">
	
	@RequestMapping("want/animal")
	public String 동물5보기(HttpServletRequest request) {
		System.out.println(request.getParameter("filename"));
		return "gallery/animal5";
	}
	
	
	// <a href="${contextPath}/response">
	@RequestMapping("response")
	public void 응답만들기(HttpServletRequest request ,HttpServletResponse response) {
		
		// 응답을 만들때는 return을 하지 않는다.
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('김양갱괴롭히기');");
			out.println("location.href='" + request.getContextPath() + "/animal';");
			out.println("</script>");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}

















