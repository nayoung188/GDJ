package com.gdu.app05.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app05.domain.Member;
import com.gdu.app05.service.MemberService;

@Controller
public class MyController1 {
	
	@GetMapping("/")
	public String index() {
		return "index";			// index.jsp로 forward
	}
	
	@GetMapping("member")
	public String member() {
		return "member";		// member.jsp로 forward
	}
	
	
	// field
	@Autowired   // 자동으로 bean을 주입해라/ Container(root-context.xml)에서 타입(class)이 일치하는 bean을 가져오세요
	private MemberService memberService;
	
	
	/*
		@ResponseBody			중요
		안녕. 난 ajax 처리하는 메소드야.
		내가 반환하는 값은 뷰(jsp) 이름이 아니고, 어떤 데이터(text, json, xml 등)야.
	 */
	
	@ResponseBody			// 안붙어있으면 jsp로 인식, 붙어있으면 응답으로 인식
	@GetMapping(value="member/detail1"
				,produces="text/plain; charset=UTF-8")		// produces : 응답 데이터의 타입(MIME-TYPE)
	public String detail1(HttpServletRequest request) {
		String str = memberService.execute1(request);
		return str;		
	}
	
	@ResponseBody
	@GetMapping(value="member/detail2"
			   ,produces="application/json; charset=UTF-8")
	public Member detail2(@RequestParam(value="id") String id, @RequestParam(value="pw") String pw) {
		Member member = memberService.execute2(id, pw);
		return member;			// jackson이 member 객체를 {"id" :아이디,"pw": 패스워드} 형식의 JSON으로 바꿔서 전달
		
		/*
		 * 추억의 코드
		 * JSONObject obj = new JSONObject(member);
		 * return obj.toString();
		 */
	}

}
