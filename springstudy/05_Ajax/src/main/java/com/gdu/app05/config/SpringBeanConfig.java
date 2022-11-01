package com.gdu.app05.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app05.service.BoardService;
import com.gdu.app05.service.BoardServiceImpl;

@Configuration
public class SpringBeanConfig {
	
	@Bean
	public BoardService boardService() {
		return new BoardServiceImpl();
	}
	
}
