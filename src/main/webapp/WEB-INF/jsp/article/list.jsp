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
</head>
<body>
	<h1>게시물 리스트</h1>
	
	<h2>v2</h2>

	<c:forEach items="${list}" var="article">
		<section>
		번호 : ${article.id},
		제목 : ${article.title}
		</section>
		<hr>
	</c:forEach>
	
	
	
	
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