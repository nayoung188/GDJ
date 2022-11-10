package com.gdu.app12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	
	
	
}