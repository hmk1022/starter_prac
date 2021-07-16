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
	public String showMain(HttpSession session, Model model) {
	
		
		// 접속한 회원정보를 url에 보여주기 위함? HttpSession
		
		long loginedMemberId = 0;
		
		if (session.getAttribute("loginedMemberId") != null) {
			// 비회원으로 게시판에 접근
			loginedMemberId = (long)session.getAttribute("loginedMemberId");
		}
		
		Member loginedMember = memberService.getOne(loginedMemberId);
		
		
		
		return "home/main";
	}
	
	@RequestMapping("/")
	public String showMain2() {
		
		return "redicect:/home/main";
	}

}
