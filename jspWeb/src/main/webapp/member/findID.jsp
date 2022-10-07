<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="../header.jsp" %>
	<div class="webbox">
		<h3>아이디 찾기</h3>
		이름 : <input type="text" id="mname"><br>
		이메일 : <input type="text" id="mmail"><br>
		<div id="findIDconfirmbox"></div>
		<button onclick="findID()">아이디 찾기</button>	
	</div>
	
	<script src="../js/member/findID.js"></script>
</body>
</html>