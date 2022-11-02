package com.gdu.app05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app05.service.GalleryService;

@Controller
public class MyController5 {

	
	@GetMapping("gallery")			// 반환이 void인 경우 mapping을 뷰(JSP)로 인식한다
	public void gallery() {
		
	}
	
	@Autowired
	private GalleryService galleryService;
	
	@ResponseBody
	@GetMapping("image/display")
	public ResponseEntity<byte[]> display(@RequestParam String path, @RequestParam String filename) {
		return galleryService.imageDisplay(path, filename);
	}
	
	// 바이트로 변환은 임플에서 진행하고 컨트롤러는 연결만 해줌
}
