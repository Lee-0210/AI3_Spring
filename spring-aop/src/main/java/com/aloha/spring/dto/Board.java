package com.aloha.spring.dto;
import java.util.Date;

import lombok.Data;


@Data
public class Board {

	private int no;
	private String id;
	private String title;
	private String writer;
	private String content;
	private Date created_at;
	private Date updated_at;
	
	public Board(String id, String title, String writer, String content) {
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	
	
}
