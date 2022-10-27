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
		$('#btn_list').click(function(event){
			location.href='${contextPath}/board/list.go';
		});
	});
</script>
</head>
<body>

	<div>
		<form id="frm_write" action="${contextPath}/board/add.go" method="POST">
			<table border="1">
				<tbody>
					<tr>
						<td>작성자</td>
						<td><input type="text" id="writer" name="writer"></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" id="title" name="title"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea id="content" name="content" rows="5" cols="30"></textarea></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="등록">
							<input type="button" value="목록" id="btn_list">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	
</body>
</html>