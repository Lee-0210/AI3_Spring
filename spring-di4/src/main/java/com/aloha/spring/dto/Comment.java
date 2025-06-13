package com.aloha.spring.dto;

import org.springframework.stereotype.Component;

@Component
public class Comment {

	private String writer;
	private String content;
	
	public Comment() {
		this("작성자없음", "내용없음");
	}

	public Comment(String writer, String content) {
		this.writer = writer;
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Comment [writer=" + writer + ", content=" + content + "]";
	}
	
}
