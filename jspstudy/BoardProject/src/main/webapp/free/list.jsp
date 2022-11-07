<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		$('#btn_insert').click(function(event){
			location.href='${contextPath}/free/insert.do';
		});
	});
</script>
</head>
<body>

	<a href="${contextPath}/free/insert.do">작성하러가기</a>
	
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<td>게시글번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>조회수</td>
				<td>삭제</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${free}" var="f">
				<tr>	
					<td>${f.freedNo}</td>
					<td>${f.title}</td>
					<td>${f.writer}</td>
					<td>${f.hit}</td>
					<td>
						<input type = "button" value="삭제" class="btn_remove" onclick="fn_remove(${f.freeNo})">
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>