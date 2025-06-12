package com.aloha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aloha.spring.dao.BoardDAO;
import com.aloha.spring.dto.Board;

public class BoardServiceImpl implements BoardService {
	
	private BoardDAO boardDao;
	
	// 의존성 자동 주입
	// - 빈으로 등록된 BoardDAO 를 주입
	@Autowired
	public BoardServiceImpl(BoardDAO boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public List<Board> list() {
		List<Board> list = null;
		
		try {
			list = boardDao.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
