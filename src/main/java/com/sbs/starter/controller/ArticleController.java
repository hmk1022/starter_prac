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

	// 게시물 상세페이지
	@RequestMapping("/article/detail") // 이 url로 요청이 오면
	public String showDetail(Model model, long id) { // id도 받아야 id에 맞는 상세페이지 view 제공

		Article article = articleService.getOne(id); 
		//dto에 정의 해놓은 Atricle 객체를 이용해 선언하고
		//article = ArticleService에 정의 해놓은 getOne(id)을 이용해 찾은 데이터 
		
		//조회수
		articleService.hitUp(id);
	
		model.addAttribute("article", article);
		// model에 getOne(id)로 찾은 article정보를 넣어준다?
		
		return "article/detail"; // jsp 파일을 보내줌
	}

	// 수정 
	@RequestMapping("/article/modify") // 이 url로 요청이 오면
	public String showModify(Model model, long id) { // id도 받아야 id에 맞는 상세페이지 view 제공

		Article article = articleService.getOne(id);
		// 위와 같이 id를 이용해 게시글을 찾아온다
		
		model.addAttribute("article", article);
		// title과 body를 바꾼 article을 model에 넣어준다.
		
		return "article/modify"; // jsp 파일을 보내줌
	}
	
	
	@RequestMapping("/article/list") // 이 url로 요청이 오면
	public String showList(Model model) { // 이렇게 response를 해준다

		List<Article> list = articleService.getList();
		//음.. Aricle을 리스트로 형식으로 가져온다? 
		
		//전체 게시물 수 
		int totalCount = articleService.getTotalCount();
		
		// System.out.println("list : " + list); // 디버깅
		// request.setAttribute("list", list); 와 같은 표현이다
		model.addAttribute("list", list);

		// 전체 게시물 개수
		model.addAttribute("totalCount", totalCount);
		// model 이라는 객체에 totalCount : totalCouun(전체 게시물 수) 추가
		
		return "article/list"; // jsp 파일을 보내줌
	}

	@RequestMapping("/article/add")
	public String showAdd() {
		return "article/add";
	}

	// 게시물 수정 페이지
	
	@RequestMapping("/article/doModify")
	@ResponseBody
	// HttpServeletRequest req;
	public String doModify(@RequestParam Map<String, Object> param, long id) {
		// Map<String, Object> => string 값의 객체라는 뜻인가?
 		// param은 {title = "title", body = "body"} 이런 형식으로 데이터가 담긴다

		articleService.modify(param);

		String msg = id + "번 게시물이 수정되었습니다.";

		// StringBuilder은 문자열을 합칠때 사용한다
		StringBuilder sb = new StringBuilder();

		sb.append("alert('" + msg + "');");
		sb.append("location.replace('./detail?id=" + id + "');");
		sb.insert(0, "<script>"); // 맨앞에 추가
		sb.append("</script>"); // 맨뒤에 추가 => script 형태로 자바스크립트 코드를 구현할 수 있다?

		return sb.toString();
	}
	
	
	
	
	@RequestMapping("/article/doAdd")
	@ResponseBody
	// HttpServeletRequest req;
	public String doAdd(@RequestParam Map<String, Object> param, String title) {
		// param은 {title = "title", body = "body"} 이런 형식으로 데이터가 담긴다

		long newId = articleService.add(param);

		/*
		 * param.get("title"); param.get("body");
		 */

		String msg = newId + "번 게시물이 추가되었습니다.";

		// StringBuilder은 문자열을 합칠때 사용한다
		StringBuilder sb = new StringBuilder();

		sb.append("alert('" + msg + "');");
		sb.append("location.replace('./detail?id=" + newId + "');");
		sb.insert(0, "<script>"); // 맨앞에 추가
		sb.append("</script>"); // 맨뒤에 추가 => script 형태로 자바스크립트 코드를 구현할 수 있다?

		// 그 이유는 페이지 이동 등의 자바스크립트 코드가 필요하기때문?
		// => <script>alert('31번 게시물이
		// 추가되었습니다!')location.replace('./detail?id=31');</script>
		System.out.println(sb);

		return sb.toString();
	}

	// 게시물 삭제

	@RequestMapping("/article/doDelete")
	@ResponseBody
	// HttpServeletRequest req;
	public String doDelete(long id) {	
		articleService.delete(id);

		String msg = id + "번 게시물이 삭제되었습니다.";

		// StringBuilder은 문자열을 합칠때 사용한다
		StringBuilder sb = new StringBuilder();

		sb.append("alert('" + msg + "');");
		sb.append("location.replace('./list');");
		sb.insert(0, "<script>"); // 맨앞에 추가
		sb.append("</script>"); // 맨뒤에 추가 => script 형태로 자바스크립트 코드를 구현할 수 있다?

		// 그 이유는 페이지 이동 등의 자바스크립트 코드가 필요하기때문?
		// => <script>alert('31번 게시물이
		// 추가되었습니다!')location.replace('./detail?id=31');</script>
		System.out.println(sb);

		return sb.toString();
	}

}