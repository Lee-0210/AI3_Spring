package com.aloha.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.spring.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	private BoardDAO boardDao;
	
	/**
	 * 생성자 주입
	 * @param boardDao
	 */
	@Autowired		// 의존성 자동 주입
	public BoardServiceImpl(BoardDAO boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public void test() {
		boardDao.test();
	}

	/**
	 * 세터주입
	 */
	@Autowired		// 의존성 자동 주입
	@Override
	public void setDAO(BoardDAO boardDao) {
		this.boardDao = boardDao;
	}

}
