package com.gdu.app02.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app02.domain.CommentDTO;
import com.gdu.app02.service.CommentService;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@ResponseBody
	@GetMapping(value="/comment/getCount", produces="application/json")		// 한글이 필요 없기 때문에 UTF-8처리는 뺌
	public Map<String, Object> getCount(@RequestParam("blogNo") int blogNo){
		return commentService.getCommentCount(blogNo);
	}
	
	@ResponseBody
	@PostMapping(value="/comment/add", produces="application/json")
	public Map<String, Object> add(CommentDTO comment){
		return commentService.addComment(comment);
	}
	
	@ResponseBody
	@GetMapping(value="/comment/list", produces="application/json")	
	public Map<String, Object> list(HttpServletRequest request){
		return commentService.getCommentList(request);
	}
	
	@ResponseBody
	@PostMapping(value="/comment/remove", produces="application/json")
	public Map<String, Object> remove(@RequestParam("commentNo") int commentNo){
		return commentService.removeComment(commentNo);
	}
	
	@ResponseBody
	@PostMapping(value="/comment/reply/add", produces="application/json")
	public Map<String, Object> replyAdd(CommentDTO reply){
		return commentService.addReply(reply);
	}
	
}
