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
		<h1>마이페이지</h1>
		<div>
			<input type="button" value="비밀번호변경" id="btn_edit_pw">
		</div>
		<div>
			<form action="${contextPath}/user/modify/pw">
				
			</form>
		</div>
	</div>

</body>
</html>