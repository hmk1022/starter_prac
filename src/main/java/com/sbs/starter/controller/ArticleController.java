package com.sbs.starter.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.javaparser.utils.Log;
import com.sbs.starter.dto.Article;
import com.sbs.starter.service.ArticleService;

import groovy.util.logging.Slf4j;

@Controller
@Slf4j // log.info(...)이 가능하게 됨 , 디버깅 용도

public class ArticleController {
	@Autowired // Bean 자동주입
	ArticleService articleService;

	@RequestMapping("/article/list") // 이 url로 요청이 오면
	public String showList(Model aModel) { // 이렇게 response를 해준다

		List<Article> list = articleService.getList(); 

		// System.out.println("list : " + list); // 디버깅

		aModel.addAttribute("list", list);
		// request.setAttribute("list", list); 와 같은 표현이다

		return "article/list"; // jsp 파일을 보내줌
	}

	@RequestMapping("/article/add")
	public String showAdd(){
		return "article/add"; 
	}	
	
	@RequestMapping("/article/doAdd")
	@ResponseBody
	//HttpServeletRequest req;
	public String doAdd(@RequestParam Map<String, Object> param, String title  ){
		
		
		articleService.add(param);
		
		/*
		 * param.get("title"); param.get("body");
		 */
		return "게시물이 추가되었습니다!"; 
	}	
}