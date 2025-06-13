package com.aloha.spring.dao;

import org.springframework.stereotype.Repository;

@Repository
public class CommentDAO extends BoardDAO {
	
	public void test() {
		System.out.println("CommentDAO...");
	}
}
