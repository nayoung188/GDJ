package com.gdu.app04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("board")		// URLMapping이 board로 시작하는 모든 요청을 처리하는 컨트롤
@Controller
public class MyController2 {
	
	
	/*
	  	까먹으면 죽음뿐이다.
	  
	  	1. forward
	  	return "board/detail";    
	  	board 폴더 아래 detail.jsp로 forward 하시오
	  	
	  	2. redirect
	  	return "redirect:/board/detail";
	  	URLMapping 값이 /board/detail 인 새로운 요청으로 redirect하시오
	 */
	
	
	// <a href="${contextPath}/board/detail1?title=공지사항&hit=10">전송</a>
	@GetMapping("detail1")
	public String detail1(HttpServletRequest request) {
		
		String title = request.getParameter("title");
		String hit = request.getParameter("hit");
		
		request.setAttribute("title", request.getParameter("title"));
		request.setAttribute("hit", request.getParameter("hit"));
		
		return "redirect:/board/detail2?title=" + title + "&hit=" + hit;		// 새로운 요청 /board/detail2?title=공지사항&hit=10  처리하시오
	}
	
	@GetMapping("detail2")	
	public String detail2(String title, int hit, Model model) {		// 변수로 받기
		model.addAttribute("title", title);
		model.addAttribute("hit", hit);
		return "board/detail";
	}

}
