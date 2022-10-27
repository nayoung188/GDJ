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
		
		$('#frm_edit').submit(function(event){
			alert('수정 성공');
		});
		
		$('#btn_list').click(function(event){
			location.href = '${contextPath}/board/list.go'};
		});
		
		$('#btn_remove').click(function(event){
			if(confirm('정말 삭제하시겠습니까?')){
				alert('삭제 성공');
				location.href='${contextPath}/board/remove.go?boardNo=${board.boardNo}';
			}
		});
	});
</script>
</head>
<body>

	<form id="frm_edit" method="POST" action='${contextPath}/board/modify.go'>
		<table border="1" >
			<tbody>
				<tr>
					<td>순번</td>
					<td><input type="text" id="board_no"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${board.writer}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" id="title" value="${board.title}"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea id="content" name="content" rows="5" cols="30" >${board.content}</textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정">
						<input type="button" value="목록" id="btn_list">
						<input type="button" value="삭제" id="btn_remove">
					</td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>