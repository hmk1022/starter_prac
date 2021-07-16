
package com.sbs.starter.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.starter.dao.MemberDao;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDao memberDao;
	// 로그인 ID 중복성 체크
	 public Map<String, Object> checkLoginIdDup(String loginId){
		 //memberDao 의 checkLoginIdDup는 id 중복을 검사한다?
		int count = memberDao.getLoginIdDupCount(loginId);
		
		String resultCode ="";
		String msg = "";
		
		if(count == 0) { // id가 중복되지 않았다면
			resultCode = "S-1";
			msg = "사용가능한 로그인 ID입니다";
		}
		else { // id가 중복되지 않았다면
			resultCode = "F-1";
			msg = "이미 사용중인 ID입니다";
		}

		
		Map<String, Object> rs = new HashMap<String, Object>();
		// hashmap 객체에 key, value 값으로 넣어준다
	    rs.put("resultCode",resultCode);
	    rs.put("msg",msg);
	    
	    return rs;
	 }
	
}