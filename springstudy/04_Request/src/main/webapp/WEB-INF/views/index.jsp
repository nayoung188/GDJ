<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>

	<img src="${contextPath}/resources/images/hooray.jpg" width="200px">
	
	<hr>
	
	<h3>Member 관련 요청</h3>
	
	<!-- a링크관련 요청-->
	<div>
		<a href="${contextPath}/member/detail1?id=admin&pw=1234">전송</a>		<%---- a링크는 GET방식의 요청이기 때문에 getmapping 사용, /member/detail --> --%>
	</div>
	
	<!--  스크립트의 로케이션을 이용하는 요청방법-->
	<div>
		<input type="button" value="전송" id="btn">
	</div>
	<script>
		$('#btn').click(function(){
			// location.href='${contextPath}/member/detail2?id=admin&pw=1234';
			// location.href='${contextPath}/member/detail2';
			// location.href='${contextPath}/member/detail3?id=admin&pw=1234';   
            location.href='${contextPath}/member/detail3';   
		});
	</script>	
	
	<!-- 폼의 액션을 이용한 요청-->
	<!-- 
	<form action="${contextPath}/member/detail4" method="get">
		<div>
			<input type="text" name="id" placeholder="아이디">
		</div>
		<div>
			<input type="text" name="pw" placeholder="비밀번호">
		</div>
		<button>전송</button>
	</form>
	 -->
	<form action="${contextPath}/member/detail4" method="post">
		<div>
			<input type="text" name="id" placeholder="아이디">
		</div>
		<div>
			<input type="text" name="pw" placeholder="비밀번호">
		</div>
		<button>전송</button>
	</form>
	
	<hr>
	
	<div>
		<a href="${contextPath}/board/detail1?title=공지사항&hit=10">전송</a>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>