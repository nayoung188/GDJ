package com.gdu.app12.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.app12.mapper.BbsMapper;
import com.gdu.app12.util.PageUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor			// 오토와이어드를 여러개 해야하면 생성자를 이용해서 주입해주는 것이 좋다
@Service
public class BbsServiceImpl implements BbsService {
	
	private BbsMapper bbsMapper;
	private PageUtil pageUtil;

	@Override
	public void findAllBbsList(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public int addBbs(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addReply(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeBbs(int bbsNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
