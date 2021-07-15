package com.sbs.starter.controller;

import org.springframework.web.bind.annotation.RequestMapping;


public class MemberController {
	
	@RequestMapping("/member/join")
	public String showJoin() {
		return "member/join";
	}
}