<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("contextPath", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

	<div class="wrap">
		<h1>로그인</h1>
		<form>
			<div>
				<input type="text" name="id" id="id" placeholder="아이디">
			</div>
			<div>
				<input type="password" name="pw" id="pw" placeholder="패스워드">
			</div>
			<div>
				<p>아래 이미지를 보이는 대로 입력해주세요.</p>
				<div>
					<div>
						<img>
					</div>
					<div>
						<input type="button">
					</div>
				</div>
			</div>
			<div>
				<input type="text" name="user_input" placeholder="자동입력 방지문자">
			</div>
			<div>
				<button>로그인</button>
			</div>
		</form>
	</div>






</body>
</html>