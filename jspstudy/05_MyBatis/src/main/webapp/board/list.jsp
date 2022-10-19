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
	* {
		box-sizing: border-box;
		padding:0;
		margin:0;
		color: #333;
	}
	a{
		text-decoration: none;
	}
	h1{
		margin-top: 20px;
		text-align: center;
	}
	.btn_write {
		width: 100px;
		height: 40px;
		text-align: center;
		line-height: 40px;
		margin: 40px auto 20px;
		background-color: teal;
		color: #fff;
		cursor: pointer;
	}
	.btn_write:hover {
		background-color: orange;
	}
	ul {
		list-style: none;
		display: flex;
		flex-wrap: wrap;
		width: 630px;
		margin: 30px auto;
	}
	ul > li {
		width: 200px;
		height: 200px;
		padding-top: 10px;
		margin-top: 10px;
		margin-right: 10px;
		text-align: center;
		border: 1px solid gray;
		border-radius: 5px;
	}
	ul > li > a {
		display: block;
		width: 100%;
		height: 100%;
	}
	ul > li:hover {
		background-color: orange;
	}

</style>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		$('#btn_write').click(function(event){
			location.href='${contextPath}/board/write.do';
		});
		
	});
</script>
</head>
<body>

	<h1>게시글 목록 보기</h1>
	<div style="text-align: center" id="btn_write"><button>추가</button></div>
	<ul>
		<c:forEach items="${boards}" var="b">
			<li>
				<a href="${contextPath}/board/detail.do?boardNo=${b.boardNo}">
					<div>${b.title}</div>
					<div>${b.createDate}</div>
				</a> 
			</li>
		</c:forEach>
	</ul>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

</body>
</html>