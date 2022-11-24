package com.gdu.app15.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BlogService {
	public void getBlogList(Model model);
	public void saveBlog(HttpServletRequest request, HttpServletResponse response);
	public Map<String, Object> saveSummernoteImage(MultipartHttpServletRequest multipartRequest);
	
}
