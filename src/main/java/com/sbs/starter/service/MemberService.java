
package com.sbs.starter.service;

import java.util.Map;

import com.sbs.starter.dto.Member;

public interface MemberService {
	// 회원가입
	public Map<String, Object> join(Map<String, Object> param);
	
	// 로그인 ID 중복성 체크
	public Map<String, Object> checkLoginIdDup(String loginId);

	public Member getOne(long loginedMemberId);

	public Member getMatchOne(String loginId, String loginPw);
}