<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%--
    	1. 동적 레이아웃  
    		1) 포함할 페이지에 변경되는 부분이 있음
    		2) <jsp:include> 액션 태그를 사용  (  <jsp>로 시작하는 것을 액션 태그라고 부름 )
    		3) <jsp:param>	액션 태그를 이용해 파라미터를 전달함
    --%>
    <% request.setCharacterEncoding("UTF-8"); %>
    <jsp:include page="header.jsp">
    	<jsp:param value="경제" name="title"/>      <%-- 'title' 파라미터에 '경제' 라는 텍스트를 담아서 보냄 --%>
    </jsp:include>
		
	<section>
		<div>경제1</div>
		<div>경제2</div>
		<div>경제3</div>
		<div>경제4</div>
	</section>
	
	<%--
		2. 정적 레이아웃
			1) 포함할 페이지에 변경되는 부분이 있음
    		2) <%@ include %> 지시어를 사용
	--%>
	
	<%@include file = "footer.jsp" %>
