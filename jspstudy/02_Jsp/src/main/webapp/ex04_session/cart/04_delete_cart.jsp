<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// session에 저장된 cart제거하기
	// session.invalidate();  로그아웃까지 되기때문에 사용하면 안됨
	session.removeAttribute("cart");
	
	// 장바구니 목록으로 이동
	response.sendRedirect("03_cart_list.jsp");
%>