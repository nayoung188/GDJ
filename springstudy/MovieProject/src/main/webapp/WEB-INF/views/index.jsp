<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script>
	
	$(document).ready(function(){

	});
	
	$(window).on('load', function(){
		alert('전체 ${totalRecord}개의 목록을 가져왔습니다.');
		$.ajax({
			type:'get',
			url: '${contextPath}/searchAllMovies',	
			dataType: 'json',
			success: function(resData){
				$.each(resData, function(i, movie){
					var tr = '<tr>';
					tr += '<td>' + movie.title + '</td>';
					tr += '<td>' + movie.genre + '</td>';
					tr += '<td>' + movie.description + '</td>';
					tr += '<td>' + movie.star + '</td>';
					tr += '</tr>';
					$('#list').append(tr);
				});
			}
		});
	});
	
</script>
</head>
<body>

	<div>
	
		<form id="frm_search">
			
			<select id="column" name="column">
				<option value="TITLE" <c:if test="${movie.column == 'title'}">selected</c:if>>제목</option>
				<option value="GENRE"<c:if test="${movie.column == 'genre'}">selected</c:if>>장르</option>
				<option value="DESCRIPTION"<c:if test="${movie.column == 'description'}">selected</c:if>>내용</option>
			</select>
			<input type="text" id="searchText" name="searchText">
			<input type="button" id="btn_search" value="검색">
			<input type="button" id="btn_init" value="초기화">
			
			<br><hr><br>
			
			<table border="1">
				<thead>
					<tr>
						<td>제목</td>
						<td>장르</td>
						<td>내용</td>
						<td>평점</td>
					</tr>
				</thead>
				<tbody id="list"></tbody>
			</table>
			
		</form>
		
	</div>

</body>
</html>