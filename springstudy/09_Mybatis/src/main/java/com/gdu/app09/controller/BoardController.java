package com.gdu.app09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app09.domain.BoardDTO;
import com.gdu.app09.service.BoardService;

import lombok.AllArgsConstructor;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
	@GetMapping("brd/list")
	public String list(Model model) {	// Model은 forward 할 속성(attribute)을 저장할 때 사용한다.
		model.addAttribute("boards", boardService.findAllBoards());
		return "board/list";			// board 폴더의 list.jsp로 forward (redirect가 없으면 forward)
	}
	
	
	@GetMapping("brd/write")
	public String write() {
		return "board/write";			// board폴더의 write.jsp로 forward
	}
	
	@PostMapping("brd/add")
	public String add(BoardDTO board) {
		boardService.saveBoard(board);			/// saveBoard()로 부터	0 / 1 반환되지만 처리하지 않았다
		return "redirect:/brd/list";
	}
	
	
	@GetMapping("brd/detail")
	public String detail(@RequestParam(value = "boardNo", required=false, defaultValue="0") int boardNo
						,Model model) {
		model.addAttribute("board", boardService.findBoardByNo(boardNo));
		return "board/detail";
	}
	
	@PostMapping("brd/edit")
	public String edit(int boardNo
						, Model model) {
		model.addAttribute("board", boardService.findBoardByNo(boardNo));
		return "board/edit";
	}
	
	@PostMapping("brd/modify")
	public String modify(BoardDTO board) {
		boardService.modifyBoard(board);			// modifyBoard()로 부터 0 / 1이 반환되지만 처리하지 않았다
		return "redirect:/brd/detail?boardNo=" + board.getBoardNo();
	}
	
	@PostMapping("brd/remove")
	public String remove(int boardNo) {
		boardService.removeBoard(boardNo);			// removeBoard()로 부터 0 / 1이 반환되지만 처리하지 않았다
		return "redirect:/brd/list";
	}

}
