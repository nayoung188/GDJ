package com.gdu.app05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app05.service.MovieService;

@Controller
public class MyController3 {

	@GetMapping("movie")
	public String movie() {
		return "movie";
	}
	
	// field
	@Autowired			// Container(root-context.xml)에 저장
	private MovieService movieService;

	
	@ResponseBody
	@GetMapping("movie/boxOfficeList")
	public String boxOfficeList(@RequestParam String targetDt) {
		return movieService.getBoxOffice(targetDt);
	}
	
}
