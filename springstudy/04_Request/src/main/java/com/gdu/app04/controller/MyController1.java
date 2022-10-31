package com.gdu.app04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app04.domain.Member;

@RequestMapping("member")			// 중간매핑값을 컨트롤러 위로 뺼 수 있다. / URL Mapping이 member로 시작하는 모든 요청을 처리하는 컨트롤러이다.
@Controller
public class MyController1 {
	
	// <a href="${contextPath}/member/detail">
	@GetMapping("detail1")				// member/detail 요청을 처리하시오
	public String detail(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Member member = new Member(id, pw);
		
		// forward할 데이터를 request에 담아 두는 방법
		request.setAttribute("member", member);
		
		return "member/detail"; 		// member폴더 아래 detail.jsp로 forward 하시오
	}
	
	// location.href='${contextPath}/member/detail2?id=admin%pw=1234';
	@GetMapping("detail2")
	public String detail2(@RequestParam(value="id", required=false, defaultValue = "master") String id			// 파라미터 id를 String id에 저장하시오
						 ,@RequestParam(value="pw", required=false, defaultValue = "1111") String pw			// 파라미터 pw를 String pw에 저장하시오
						 ,Model model) {
		/*
		 	@RequestParam
		 	1. value : 파라미터 이름
		 	2. required : 파라미터의 필수 여부(디폴트는 true)
		 	3. defaultValue : 파라미터가 없을 때 사용할 값
		 */
		
		
		Member member = new Member(id, pw);
		
		// forward할 데이터를 model에 담아 두는 방법(이것이 스프링의 방식)
		// request를 이용하는 방식에 비해 보안이 향상되었다.
		model.addAttribute("member", member);			// model은 request를 저장소로 사용한다.
		
		return "member/detail";	 		// member폴더 아래 detail.jsp로 forward 하시오
	
	}
	
	// location.href='${contextPath}/member/detail3?id=admin%pw=1234';
	@GetMapping("detail3")
	public String detail3(String id				// @RequestParam은 생략할 수 있다. 파라미터 ID가 없는 경우 null이 저장된다.
						, String pw				// @RequestParam은 생략할 수 있다.	파라미터 pw가 없는 경우 null이 저장된다.
						, Model model) {
		Member member = new Member(id, pw);
		
		model.addAttribute("member", member);
		return "member/detail";
	}
	
	// <form action="{$contextPath}/method/detail4" method="get">
	@GetMapping("detail4")
	public String getDetail4(Member member		// 파라미터 id, pw를 setId(), setPw() 메소드를 이용해서 member 객체에 저장해 준다.
							,Model model) {
		model.addAttribute("member", member);
		return "member/detail";
	}
	

	// <form action="{$contextPath}/method/detail4" method="post">
	@PostMapping("detail4")		// 요청 : URLMapping + 요청메소드
	public String poseDetail4(@ModelAttribute(value="member") Member member) {		// 파라미터 id,pw를 이용해 Member member를 만들고, Model에 member라는 이름의 속성으로 저장하시오.
		

		
		return "member/detail";
	}
	
	// 같은 요청이어도 메소드가 다르면 상관없다
	
}











