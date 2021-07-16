package com.sbs.starter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.starter.dto.Member;
import com.sbs.starter.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	@Autowired
	MemberService memberService;

	@RequestMapping("/home/main")
	/* 인터셉트를 이용하면 아래 코드는 필요가 없어진다
	 * public String showMain(HttpSession session, Model model) {
	 * 
	 * 
	 * // 접속한 회원정보를 url에 보여주기 위함? HttpSession
	 * 
	 * long loginedMemberId = 0;
	 * 
	 * // 로그인 체크 if (session.getAttribute("loginedMemberId") != null) { // 비회원으로
	 * 게시판에 접근 loginedMemberId = (long)session.getAttribute("loginedMemberId"); }
	 * 
	 * // 해당 로그인 번호로 db에서 회원의 정보를 불러오기 // 거의 모든 페이지에 필요한작업 Member loginedMember =
	 * memberService.getOne(loginedMemberId);
	 * 
	 * 
	 * 
	 * return "home/main"; }
	 */
	

	public String showMain2(Model model) {
		
		return "home/main";
	}

}
