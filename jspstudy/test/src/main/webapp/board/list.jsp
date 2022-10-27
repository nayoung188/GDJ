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
		$('#btn_write').click(function(event){
			location.href='${contextPath}/board/write.go';
		});
		
	});
</script>
</head>
<body>
	<div> 총 게시글 : ${count} 개</div>
	<table border="1">
		<thead>
			<tr>
				<td>순번</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boards}" var="board">
				<tr >
					<td>${board.boardNo}</td>
					<td>${board.writer}</td>
					<td><a href="${contextPath}/board/detail.go?boardNo=${board.boardNo}">${board.title}</a></td>
					<td>${board.createDate}</td>
				</tr>
			</c:forEach>
			<tr>
				<td id="btn_write" colspan="4"><button>새글작성</button></td>
			</tr>
		</tbody>
	
	</table>
	

</body>
</html>