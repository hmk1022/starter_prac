package com.sbs.starter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.javaparser.utils.Log;
import com.sbs.starter.dto.Article;
import com.sbs.starter.service.ArticleService;

import groovy.util.logging.Slf4j;

@Controller
@Slf4j // log.info(...)이 가능하게 됨 , 디버깅 용도

public class ArticleController {
	@Autowired //Bean 자동주입
	ArticleService articleService; 
	
	@RequestMapping("/article/list") // 이 url로 요청이 오면
	public String showList() { // 이렇게 response를 해준다
		
		List<Article> list = articleService.getList(); // 이것은 가짜데이터들
		
		  System.out.println("list : " + list);
		//Log.info("list : " + list);
		
		return "article/list"; // jsp 파일을 보내줌
	}
}