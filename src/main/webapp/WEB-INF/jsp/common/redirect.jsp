<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
	console.log('hello');
	var alertMsg = '${alertMsg}';
	var historyBack = '${historyBack}' == 'true';
	var redirectUrl = '${redirectUrl}';
</script>

<script>
console.log('hello');
	if (alertMsg) {
		alert(alertMsg);
	}
	if (historyBack) {
		history.back();
	}
	if ( redirectUrl ) {
		console.log('리다이렉트 : ',redirectUrl)
		if(redirectUrl == '/') localStorage.setItem('userId', ${userId});
		location.replace(redirectUrl);
	}
</script> 