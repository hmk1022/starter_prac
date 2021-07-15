<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.sbs.starter.dto.Article"%>

<!-- jstl 문법사용 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
List<Article> list = (List<Article>) request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<lint rel="stylesheet" href="/resource/common.css" />
</head>
<body>
	<h1>게시물 리스트</h1>

	<h2 class="con">전체 게시물 개수 : ${totalCount}</h2>

	<div class="con">
		<c:forEach items="${list}" var="article">
			<section>
				<a href="./detail?id= ${article.id}"> 번호 : ${article.id}, 제목 : ${article.title} 내용 :
					${article.body} </a>
			</section>
			<hr>
		</c:forEach>
	</div>

	<div class="btn con">
		<a href="./add">게시물 추가</a>
	</div>

	<%-- 	<h2>v1</h2>
	<!-- el의 장점은 request.getAttribue("article")할 필요가 없다 -->
	<!-- 반복문을 써서 화면에 하나씩 출력한다 자바스크립트 for문이랑 비슷!  -->
	<!-- el문법 -->
	<%
	for (int i = 0; i < list.size(); i++) {
	%>
	<%
	Article article = list.get(i);
	%>
	<section>
		번호 :
		<%=article.getId()%>
		,제목 :
		<%=article.getTitle()%>
	</section>
	<hr>
	<%
	}
	%> --%>


</body>
</html>