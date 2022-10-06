<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- test하면서 name 다 바뀌었음. 작동x -->
	<h3> 회원가입 페이지 </h3>
	<form action="/jspWeb/signup" method="get">
		<!-- 폼태그 : 전송기능 action="경로" method="" -->
		아이디 : <input type="text" name="id"> <br>
		비밀번호 : <input type="text" name="pw"> <br>
		이름 : <input type="text" name="name"> <br>
		전화번호 : <input type="text" name="phone"> <br>
		<input type="submit" value="signUp">
	</form>

</body>
</html>