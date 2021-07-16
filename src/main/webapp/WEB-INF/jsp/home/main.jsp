
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageName" value="메인페이지" />
<%@ include file="../part/head.jspf"%>

<div>
	테스트 넘버 : ${testNumber}
</div>

<c:if test="${loginedMember != null}">
	<div class="con">회원 로그인 ID: ${loginedMenber.loginId}</div>
</c:if>
<%@ include file="../part/foot.jspf"%>