<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>로그인페이지</h3>
	<form action="/jspWeb/member/logIn" method = "post">
		로그인 : <input type="text" name = "ID">
		비밀번호 : <input type="password" name = "PW">
		<input type="submit" value="로그인">
	</form>
</body>
</html>