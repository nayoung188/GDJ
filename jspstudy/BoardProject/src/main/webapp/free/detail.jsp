<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>

	$(document).ready(function(){
		
		$('#btn_edit').submit(function(event){
			alert('게시글이 수정되었습니다.');
		});
		
		$('#btn_list').click(function(event){
			location.href = '${contextPath}/free/list.do';
		});
	});

</script>
</head>
<body>
	<h1>자유게시판 게시글 상세보기화면</h1>
	<div>${free.freeNo}</div>
	<div>${free.writer}</div>
	<div>${free.ip}</div>
	<div>${free.hit}</div>
	<div>
		<form id="frm_edit" action="${contextPath}/free/modify.do" method="POST">
			<div>
				<label for="title">제목</label>
				<input type="text" id="title" value="${free.title}">
			</div>
			<div>
				<label for="content">내용</label>
				<textarea id="content"  rows="5" cols="30">${free.content}</textarea>
			</div>
		</form>
	</div>
	<input type="hidden" name="freeNo" value="${free.freeNo}">
	<div>
		<input type="button" value="수정" id="btn_edit">
		<input type="button" value="목록" id="btn_list">
	</div>
</body>
</html>