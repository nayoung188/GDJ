<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		// 시작할 때 session 초기화 해 두기.
		session.invalidate();
	%>
	
	<form action="Quiz07B.jsp">
		설문작성자<br>
		<input type="text" name="name"><br>
		<h3>1. 좋아하는 연예인은 누구인가요?</h3>
		<input type="text" name="celeb">
		<button>다음</button>
	</form>
	
</body>
</html>