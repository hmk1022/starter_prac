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
<title>게시물 작성</title>

<lint rel="stylesheet" href="/resource/common.css" />
</head>
<body>
	
	<script>
		function submitAddForm(form) {
			/* trim은 공백제거  */
			/* form태그 안에 있는 인풋값에 name을 이용해 바로접근가능 */
			form.title.value.length = form.title.value.trim();
			if( form.title.value == 0){
				alert('제목을 입력해 주세요!')
				form.title.focus();
				return false;
			} 
			
			form.body.value = form.body.value.trim();
			if( form.body.value.length == 0){
				alert('내용을 입력해 주세요!')
				form.body.focus();
				return false;
			} 
			
			form.submit();
			
		}
	</script>
	<h1 class="con">게시물 작성</h1>
	<!-- submit 버튼을 누르면 doAdd 페이지로 간다 -->
	<form class="con common-form" action="./doAdd" method="POST"
		onsubmit="submitAddForm(this); return false;">
		<div>
			<span> 제목 </span>
			<div>
				<input name="title" type="text" placeholder="제목"
					autofocus="autofocus">
			</div>
		</div>

		<div>
			<span> 내용 </span>
			<div>
				<textarea name="body" placeholder="내용"></textarea>
			</div>
		</div>

		<div>
			<span> 작성 </span>
			<div>
				<input type="submit" value="작성">
				<!-- 뒤로가기 버튼 -->
				<input type="reset" value="취소" onclick="history.back();">
			</div>
		</div>
	</form>

</body>
</html>