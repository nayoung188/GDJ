package com.gdu.app05.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.gdu.app05.domain.Member;

public class MemberServiceImpl implements MemberService {

	@Override
	public String execute1(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		return "당신의 아이디는 " + id + "이고 패스워드는 " + pw + "입니다.";
	}

	@Override
	public Member execute2(String id, String pw) {
	
		return new Member(id,pw);
	}

	@Override
	public Map<String, Object> execute3(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

}
