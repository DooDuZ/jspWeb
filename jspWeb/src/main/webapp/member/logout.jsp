<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<%@ include file="../header.jsp" %>
	<%
		// 모든 세션 제거
		// session.invalidate();
		
		//특정 세션만 제거
		session.setAttribute("mid", null);
		
		
		// 페이지 전환
		response.sendRedirect("/jspWeb/index.jsp");
	%>
	
	<div class="webbox">
		<h3>로그아웃이 되었습니다.</h3>
		<a href="../index.jsp">메인</a>		
	</div>

</body>
</html>