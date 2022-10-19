<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style>
	h1{
		text-align: center;
	}
	ul {
		list-style: none;
		display: flex;
		justify-content: space-between;
		width: 630px;
		margin: 30px auto;
	}
	ul > li {
		width: 200px;
		height: 200px;
		text-align: center;
		border: 1px solid gray;
		border-radius: 5px;
	}
</style>
</head>
<body>

	<h1>게시글 목록 보기</h1>
	<ul>
		<c:forEach items="${boards}" var="b">
			<li>
				<div>${b.title}</div>
				<div>${b.createDate}</div>
			</li>
		</c:forEach>
	</ul>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

</body>
</html>