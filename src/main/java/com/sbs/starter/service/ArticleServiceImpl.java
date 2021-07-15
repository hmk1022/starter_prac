package com.sbs.starter.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.starter.dao.ArticleDao;
import com.sbs.starter.dto.Article;
import com.sbs.starter.util.CUtil;

import groovy.util.logging.Slf4j;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
	// DB에 접근해 데이터를 가져오는곳
	// ArticleSevice는 데이터 관련된 기능은 DAO에 위임한다
	@Autowired
	ArticleDao articleDao;

	public List<Article> getList() {

		return articleDao.getList();

		
	}

	@Override
	public long add(Map<String, Object> param) {
		articleDao.add(param);
		// void => long return 값이 생긴다
		// 여기 리턴값은 게시물 번호를 의미함
		
		// 고유한 새로운 게시물 id 생성
		/*
		 * BigInteger bigIntId = (BigInteger)param.get("id"); long newId =
		 * bigIntId.longValue();
		 */
		
		 
		
		return CUtil.getAslong(param.get("id"));
	}
}
