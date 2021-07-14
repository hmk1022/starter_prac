package com.sbs.starter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.starter.dao.ArticleDao;
import com.sbs.starter.dto.Article;

@Service
public class ArticleServiceImpl implements ArticleService {
	// DB에 접근해 데이터를 가져오는곳
	// ArticleSevice는 데이터 관련된 기능은 DAO에 위임한다
	@Autowired
	ArticleDao articleDao;

	public List<Article> getList() {

		return articleDao.getList();

		
	}
}
