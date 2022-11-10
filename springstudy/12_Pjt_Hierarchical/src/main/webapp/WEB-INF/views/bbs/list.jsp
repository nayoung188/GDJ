<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<table border="1">
			<thead>
				<tr>	
					<td>순번</td>
					<td>작성자</td>
					<td>제목</td>
					<td>IP</td>
					<td>작성일</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bbs" items="${bbsList}"  varStatus="vs"> 
					<tr>
						<td>${beginNo - vs.index}</td>
						<td>${bbs.writer}</td>
						<td>${bbs.title}</td>
						<td>${bbs.ip}</td>
						<td>${bbs.createDate}</td>
						<td><a href="">X</a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>	
					<td colspan="6">${paging}</td>
				</tr>
			</tfoot>
		</table>
	</div>
	
</body>
</html>