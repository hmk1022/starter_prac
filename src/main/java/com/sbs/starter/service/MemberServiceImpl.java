
package com.sbs.starter.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.starter.dao.MemberDao;
import com.sbs.starter.dto.Member;
import com.sbs.starter.util.CUtil;

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
	 
	@Override
	public Member getOne(long loginedMemberId) {

		return memberDao.getOne(loginedMemberId);
	}
	
	// 회원가입
	@Override
	public Map<String, Object> join(Map<String, Object> param ) {
		memberDao.join(param);
		
		long newId = CUtil.getAslong(param.get("id"));
		
		String resultCode = "";
		String msg = "";
		
		if (newId == 0) {
			resultCode = "F-1";
			msg = "회원가입에 실패했습니다";
		} else {
			resultCode = "S-1";
			msg = "회원가입이 완료됐습니다";
		}
		
		Map<String, Object>rs = new HashMap<String, Object>();
		rs.put("resultCode", resultCode);
		rs.put("msg", msg);
		rs.put("newId", newId);
		
		return rs;
	}

	
	@Override
	public Member getMatchOne(String loginId, String loginPw) {
		
		return memberDao.getMatchOne(loginId, loginPw);
	}

}