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
	
	<% if(loginID==null){ response.sendRedirect("../member/login.jsp"); } %>
	
	<div class="">
		<h3>글쓰기</h3>
		<!--  
		<form action="/jspWeb/board/write" method="post">
			제목 : <input type="text" name="btitle"> <br>
			내용 : <input type="text" name="bcontent">	
			<input type="submit" value="쓰기">
		</form>
		 -->
	 	제목 : <input type="text" id="btitle"> <br>
		내용 : <input type="text" id="bcontent">
		파일 : <input type = "file">
		<button onclick="bwrite()">글 등록</button>		 
	</div>
	
	
	<script src="../js/board/write.js"></script>
</body>
</html>