package com.gdu.rest.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.gdu.rest.domain.MemberDTO;
import com.gdu.rest.mapper.MemberMapper;

@Service
public class MemberSeviceImpl implements MemberService{
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public Map<String, Object> register(MemberDTO member, HttpServletResponse response) {
		try {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("insertResult", memberMapper.insertMember(member));
			return result;
		} catch (DuplicateKeyException e) {
			e.printStackTrace();
			System.out.println(e.getClass().getName());
			
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
