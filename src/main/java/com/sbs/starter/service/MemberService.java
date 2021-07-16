
package com.sbs.starter.service;

import java.util.Map;

public interface MemberService {
	// 로그인 ID 중복성 체크
	 Map<String, Object> checkLoginIdDup(String loginId);
	
}