<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<form action="${contextPath }/adder.do">
			<div>
				<input type="text" name="a">
				+
				<input type="text" name="b">
				<button>계산</button>
			</div>
		</form>
	</div>

</body>
</html>