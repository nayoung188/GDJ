package com.gdu.app12.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BbsService {
	public void findAllBbsList(HttpServletRequest request, Model model);
	public int addBbs(HttpServletRequest request);
	public int addReply(HttpServletRequest request);
	public int removeBbs(int bbsNo);
}