<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>

	<div>
	
		<h1>회원가입</h1>
		
		<div>* 표시는 필수 입력사항입니다.</div>
		
		<hr>
		
		<form id="frm_join" action="${contextPath}/user/join" method="post">
			<!-- 약관 동의 여부 -->
			<input type="hidden" name="location" value="${location}">
			<input type="hidden" name="promotion" value="${promotion}">
			
			<!-- 아이디 -->
			<div>
				<label for="id">아이디 *</label>
				<input type="text" name="id" id="id">
				<span id="msg_id"></span>
			</div>
			
		</form>
		
	</div>

</body>
</html>