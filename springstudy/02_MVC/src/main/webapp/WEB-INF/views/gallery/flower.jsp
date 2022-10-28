<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		$('#title').text('꽃은 나영이');
		$('#image').attr('src', '${contextPath}/resources/images/flower1.jpg');
	});
</script>
</head>
<body>

	<h1 id="title"></h1>
	<img id="image" width="400px">
	
</body>
</html>