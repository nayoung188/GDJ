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

	$(function(){
		fn_list();
		fn_add();
		fn_find();
		fn_findAll();
	});
	
	function fn_list(){
		$.ajax({
			type: 'get',
			url: '${contextPath}/list.json',
			dataType: 'json',
			success: function(resData){
				$('#stf_list').empty();
				$.each(resData, function(i, staff){
					var tr = '<tr>';
					tr += '<td>' + staff.sno + '</td>';
					tr += '<td>' + staff.name + '</td>';
					tr += '<td>' + staff.dept + '</td>';
					tr += '<td>' + staff.salary + '</td>';
					tr += '</tr>';
					$('#stf_list').append(tr);
				});
			}
		});
	}
	
	function fn_add(){
		$('#btn_add').click(function(){
			if(/^[0-9]{5}$/.test($('#sno').val()) == false ) {
				alert('사원번호는 5자리 숫자입니다.');
				return;
			} 
			if(/^[가-힣]{3,5}$/.test($('#dept').val()) == false ) {
				alert('부서는 3~5자리 한글입니다.');
				return;
			}
			$.ajax({
				type: 'post',
				url: '${contextPath}/add',
				data: $('#stf_add').serialize(),
				dataType: 'text',
				success: function(resData){
					alert(resData);
					fn_list();
					$('#sno').val('');
					$('#name').val('');
					$('#dept').val('');
				},
				error: function(jqXHR){
					alert(jqXHR.responseText);
				}
			});
		});
	}
	
	function fn_find() {
		$('#btn_find').click(function(){
			$.ajax({
				type: 'get',
				url: '${contextPath}/query.json',
				data: 'sno=' + $('#query').val(),
				dataType: 'json',
				success: function(resData){
					$('#stf_list').empty();
					var tr = '<tr>';
					tr += '<td>' + resData.sno + '</td>';
					tr += '<td>' + resData.name + '</td>';
					tr += '<td>' + resData.dept + '</td>';
					tr += '<td>' + resData.salary + '</td>';
					tr += '</tr>';
					$('#stf_list').append(tr);
				},
				error: function(jqXHR){
					alert('조회된 사원 정보가 없습니다.');
				}
			});
		});
	}
	
	function fn_findAll(){
		$('#btn_find_all').click(function(){
			fn_list();
		});
	}

</script>
</head>
<body>

	<h3>사원등록</h3>
	<form id="stf_add">
		<input type="text" id="sno" name="sno" placeholder="사원번호">
		<input type="text" id="name" name="name" placeholder="사원명">
		<input type="text" id="dept" name="dept" placeholder="부서명">
		<input type="button" value="등록" id="btn_add">
	</form>
	
	<hr>
	<h3>사원조회</h3>
	<form id="stf_find">
		<input type="text" id="query" name="query" placeholder="사원번호">
		<input type="button" value="조회" id="btn_find">
		<input type="button" value="전체" id="btn_find_all">
	</form>
	
	
	<hr>

	<h3>사원목록</h3>
	<table border="1">
		<thead>
			<tr>
				<td>사원번호</td>
				<td>사원명</td>
				<td>부서명</td>
				<td>연봉</td>
			</tr>
		</thead>
		<tbody id="stf_list">
		
		</tbody>
	</table>

</body>
</html>