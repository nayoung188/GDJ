<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 상세 보기</h1>
	
	<div>아이디 ${member.id }</div>			<%-- ${member.id} 는 자바로 member.getid()를 호출한다. 게터를 만들어 줘야 정상 작동함 --%>
	<div>패스워드 ${member.pw }</div>		<%-- ${member.id} 는 자바로 member.getpw()를 호출한다. 게터를 만들어 줘야 정상 작동함 --%>
</body>
</html>