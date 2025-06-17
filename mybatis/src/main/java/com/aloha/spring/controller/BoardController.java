package com.aloha.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aloha.spring.dto.Board;
import com.aloha.spring.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	// 로거
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	// 의존성 자동 주입
	@Autowired
	private BoardService boardService;
	
	// [GET] : @GetMapping("/list")
	// [POST] : @PostMapping("/list")
	
	/**
	 * 게시글 목록		- [GET]		/list 
	 * @param model
	 * @return
	 */
	@GetMapping("/list")
	public String list(Model model) {
		List<Board> boardList = null;
		
		try {
			boardList = boardService.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("boardList : " + boardList);
		model.addAttribute("boardList", boardList);
		
		return "board/list";
	}
	
	// 게시글 조회		- [GET]		/read
	@GetMapping("/read")
	public String read(Model model, @RequestParam("no") int no) {
		Board board = null;
		
		try {
			board = boardService.select(no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("board : " + board);
		model.addAttribute("board", board);
		
		return "board/read";
	}
	
	// 게시글 등록		- [GET]		/insert
	@GetMapping("/insert")
	public String insert() {
		
		return "board/insert";
	}
	
	// 게시글 등록 처리	- [POST]	/insert
	@PostMapping("/insert")
	public String insertPost(@ModelAttribute Board board) {
		boolean success = false;
		try {
			success = boardService.insert(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(success) return "redirect:/board/list";
		
		return "redirect:/board/insert?error";
	}
	
	// 게시글 수정		- [GET]		/update
	@GetMapping("/update")
	public String update(Model model, @RequestParam("no") int no) {
		Board board = null;
		
		try {
			board = boardService.select(no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("board", board);
		
		return "board/update";
	}
	
	// 게시글 수정 처리	- [POST]	/update
	@PostMapping("update")
	public String updatePost(@ModelAttribute Board board) {
		
		boolean success = false;
		
		try {
			success = boardService.update(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(success) return "redirect:/board/list";
		
		return "redirect:/board/update?error";
	}
	
	// 게시글 삭제 처리	- [POST]	/delete
	@PostMapping("delete")
	public String deletePost(@RequestParam("no") int no) {
		boolean success = false;
		
		try {
			success = boardService.delete(no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(success) return "redirect:/board/list";
		
		return "redirect:/board/update?error";
	}
}
