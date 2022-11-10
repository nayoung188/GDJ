package com.gdu.app12.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.app12.service.BbsService;

@Controller
public class BbsController {

	@Autowired
	private BbsService bbsService;
	
	@GetMapping("/")
	public String welcome() {
		return "index";
	}
	
	@GetMapping("/bbs/list")
	public String list(HttpServletRequest request, Model model) {
		bbsService.findAllBbsList(request, model);
		return "bbs/list";
	}
	
	
}