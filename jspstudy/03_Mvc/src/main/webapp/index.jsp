<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />   <%-- value 의 내용은 <%=request.getContextPath() 와 같다--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3><a href="${contextPath}/today.do">오늘은 며칠입니까?</a></h3>   <%-- /03_mvc/ 라고 쓰면 안됨 --%>
	<h3><a href="${contextPath}/now.do">지금은 몇시입니까?</a></h3>
	<h3><a href="${contextPath}/input.do">입력화면으로 이동하기</a></h3>


</body>
</html>