package com.aloha.spring.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.aloha.spring.dto.User;

@Mapper
public interface UserMapper {
	
	// 회원 가입
	public int insert(User user) throws Exception;
}
