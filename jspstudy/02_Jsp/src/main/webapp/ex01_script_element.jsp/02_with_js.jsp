<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
		1. 가능한 작업
			Java 변수를 JavaScript에서 표현식으로 사용할 수 있다.
	-->
	
	<%
		String name = "홍길동";
		int age = 25;
	%>
	<script>
		var name = '<%=name%>';
		var age = <%=age%>;
		alert(name + ', ' + age);
	</script>
	
	<!--
		2. 불가능한 작업
			JavaSctipt 변수는 Java 영역에서 사용할 수 없다.
	-->
	<script>
		var address = '서울시';
	</script>
	<%-- 
	<div><%=address %></div>		=> 실행 안되는 코드
	--%>

</body>
</html>