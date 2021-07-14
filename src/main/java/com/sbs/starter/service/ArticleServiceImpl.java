package com.sbs.starter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sbs.starter.dto.Article;

@Service
public class ArticleServiceImpl implements ArticleService {
	// DB에 접근해 데이터를 가져오는곳?
	public List<Article> getList(){
		//일단 가짜데이터를 뿌려보자
		Article article1 = new Article(1, "2019-08-20 12:12:12", "제목1", "내용1");
		Article article2 = new Article(2, "2019-08-20 12:12:12", "제목2", "내용2");
		Article article3 = new Article(3, "2019-08-20 12:12:12", "제목3", "내용3");
		
		List<Article> list = new ArrayList<>();
		
		list.add(article3);
		list.add(article2);
		list.add(article1);
		
		return list;
	}
}
