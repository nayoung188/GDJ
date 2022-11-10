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
<script type="text/javascript">
	$(function(){
		if('${recordPerPage}' != ''){
			$('#recordPerPage').val(${recordPerPage});			
		} else {
			$('#recordPerPage').val(10);
		}
		$('#recordPerPage').change(function(){
			location.href = '${contextPath}/bbs/list?recordPerPage=' + $(this).val();
		});
	});
</script>
<style>
    @import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css');
</style>
</head>
<body>
	<div>
		<a href="${contextPath}/bbs/write">작성하러가기</a>
	</div>

	<div>
		<select id="recordPerPage">
			<option value="10">10</option>
			<option value="20">20</option>
			<option value="30">30</option>
		</select>
	</div>

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
						<td><a href=""><i class="fa-solid fa-trash-can"></i></a></td>
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