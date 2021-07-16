package com.sbs.starter.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.starter.dto.Member;
import com.sbs.starter.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j // 이걸 해야 log.info(..) 가 가능, 디버깅 용도
public class MemberController {
	@Autowired
	MemberService memberService;

	@RequestMapping("/member/join")
	public String showJoin() {
		return "member/join";
	}
	
	@RequestMapping("/member/login")
	public String showLogin() {
		return "member/login";
	}
	
	@RequestMapping("/member/doLogin")
	public String doLogin(@RequestParam Map<String, Object> param, Model model, HttpSession session  ) {
		// id와 pw가 일치하는 유저가 있는지 찾아보기
		Member matchedMember = memberService.getMatchOne((String)param.get("loginId"),(String)param.get("loginPw"));
		
		// 일치하는 회원정보가 없을경우
		if (matchedMember == null) {
			model.addAttribute("alertMsg", "일치하는 회원이 존재하지 않습니다");
			model.addAttribute("historyBack",true);
			
			return "common/redirect";
		}
		
		// 일치하는 회원정보가 있을경우
		session.setAttribute("loginedMemberId", matchedMember.getId());
		
		model.addAttribute("alertMsg", "로그인 되었습니다");
		model.addAttribute("redirectUrl","/");
		
		return "common/redirect";
	}
	
	
	@RequestMapping("/member/doLogOut")
	public String showLogout() {
		return "member/logout";
	}
	
	
	
	@RequestMapping("/member/doJoin")
	public String doJoin(@RequestParam Map<String, Object> param, Model model) {
		// 로그인 ID의 중복성 체크
		Map<String, Object> checkLoginIdDupRs = memberService.checkLoginIdDup((String)param.get("loginId"));

		// checkLoginIdDupRs의 resultCode가 F- 으로 시작하는지 조건문
		if (((String)checkLoginIdDupRs.get("resultCode")).startsWith("F-")) {
			
			model.addAttribute("alertMsg",checkLoginIdDupRs.get("msg"));
			model.addAttribute("historyBack", true);
			
			return "common/redirect";
		} 
		
		Map<String, Object> joinRs = memberService.join(param);
		
		if (((String)joinRs.get("resultCode")).startsWith("F-")) {
			model.addAttribute("alertMsg", joinRs.get("msg"));
			model.addAttribute("historyBack", true);
			return "common/redirect";
		}
		
		model.addAttribute("alertMsg", joinRs.get("msg"));
		model.addAttribute("redirectUrl", "/member/login");
		
		return "common/redirect";
		
	}
}