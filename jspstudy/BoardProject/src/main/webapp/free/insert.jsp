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
		$('#frm_insert').submit(function(event){
			
		});
		$('#btn_list').click(function(event){
			location.href='${contextPath}/free/list.do';
		});
	});
</script>
</head>
<body>

	<h1>자유게시판 게시글 작성화면</h1>
	<div>
		<form id="frm_insert" method="POST" action="${contextPath}/free/insert.do">
			<div>
				<label for="writer">작성자</label>
				<input type="text" placeholder="작성자">
			</div>
			<div>
				<label for="title">제목</label>
				<input type="text" placeholder="제목">
			</div>
			<div>
				<textarea id="content" rows="5" cols="30" placeholder="내용"></textarea>
			</div>
			<div>
				<input type="submit" value="작성완료">
				<input type="reset" value="다시작성">
				<input type="button" value="목록" id="btn_list">
			</div>
		</form>
	</div>
	
</body>
</html>