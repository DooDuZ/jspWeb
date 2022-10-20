<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="../css/chatting.css" rel="stylesheet">
</head>
<body>

	<%@ include file="../header.jsp" %>
	<!-- 로그인 변수 숨기기 -->
	<input type="hidden" class="mid" value="<%= loginID %>">
	<div class="webbox">
		<h3>채팅</h3>
		<div class="contentbox"></div>
		<textarea rows="" cols="" class="msgbox" onkeyup="enterKey()"></textarea>
		<button type="button" onclick="send()">보내기</button>
	</div>	
	<script src="../js/board/chatting.js"></script>
</body>
</html>