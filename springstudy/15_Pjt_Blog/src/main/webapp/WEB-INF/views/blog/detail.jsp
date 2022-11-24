<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<jsp:include page="../layout/header.jsp">
	<jsp:param value="${blog.blogNo}번 블로그" name="title" />
</jsp:include>

<div>
	<h1>${blog.title}</h1>
	<div>
		<span>▶ 작성일  <fmt:formatDate value="${blog.createDate}" pattern="yyyy. M. d HH:mm" /></span>
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
		<span>▶ 수정일  <fmt:formatDate value="${blog.modifyDate}" pattern="yyyy. M. d HH:mm" /></span>
	</div>
	
	<div>
		<span>조회수 <fmt:formatNumber value="${blog.hit}" pattern="#,##0" /></span>
	</div>
	
	<hr>
	
	<div>
		${blog.content}
	</div>
	
	<div>
		<form id="frm_btn" method="post">
			<input type="hidden" name="blogNo" value="${blog.blogNo}">
			<input type='button' value="수정" id="btn_edit_blog">
			<input type='button' value="삭제" id="btn_remove_blog">
			<input type="button" value="목록" onclick="location.href='${contextPath}/blog/list'">
		</form>
		<script>
			$('#btn_edit_blog').click(function(){
				$('#frm_btn').attr('action','${contextPath}/blog/edit');
				$('#frm_btn').submit();
			});
			$('#btn_remove_blog').click(function(){
				if(confirm('블로그를 삭제하면 블로그애 달린 댓글을 더 이상 확인할 수 없습니다. 삭제하시겠습니까?')){
					$('#frm_btn').attr('action','${contextPath}/blog/remove');
					$('#frm_btn').submit();
				}
			});

		</script>
	</div>
	
</div>

	
</body>
</html>