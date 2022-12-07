package com.gdu.rest.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gdu.rest.domain.MemberDTO;
import com.gdu.rest.service.MemberService;

@RestController   // 이 컨트롤러는 모든 메소드에 @responsebody 애너테이션을 추가한다
public class MemberRestController {
	
	/*
		REST : REpresentational State Transfer
		
		1. 자원을 정의하고 자원의 주소를 지정하는 방식에 대한 하나의 형식이다.
		2. REST 방식을 따르는 시스템을 "RESTful하다" 라고 표현한다.
		3. 동작을 URL + Method 조합으로 결정한다.
		4. 파라미터가 URL에 경로처럼 포함된다. (?를 사용하지 않는다.)
		5. CRUD 처리 방식
						URL				Method
			1) 삽입		/members		POST
	*/
	
	@Autowired
	private MemberService memberservice;

	@PostMapping(value="/members", produces="application/json")
	public Map<String, Object> addMember(@RequestBody MemberDTO member, HttpServletResponse response){
		return memberservice.register(member, response);
	}
}
