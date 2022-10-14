<%@page import="model.dao.WriteDao"%>
<%@page import="model.dto.writeDto"%>
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
	
	<%-- <% 
		int bno = Integer.parseInt(request.getParameter("bno"));
		writeDto dto = WriteDao.getInstance().getContent(bno);	
	%>
	
	<div class="webbox">	
		<div id = "contentbox">
			<h3 id = "titlebox"> <%= dto.getBtitle() %> </h3>
			<div id= "textbox"> <%= dto.getBcontent() %></div>
		</div>	
	</div> --%>
	
	<div class="webbox">
		<h3>글 조회</h3>
		<div id = "contentbox">
			<h3 id = "titlebox"> </h3>
			<div id = "bnobox" ></div>
			<div id = "idbox"></div>
			<div id = "textbox"> </div>
			<div id = "bfile">첨부파일</div>
			<div id = "delbox"></div>
		</div>	
	</div>
	
	<script src="../js/board/page.js"></script>
</body>
</html>