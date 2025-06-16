package com.aloha.spring.dto;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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

	// 파일 정보
	List<MultipartFile> fileList;
	
	public Board() {
		
	}
	
	public Board(String id, String title, String writer, String content) {
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	
	
}
