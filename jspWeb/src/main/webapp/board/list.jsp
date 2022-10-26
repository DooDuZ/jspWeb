<%@page import="model.dto.writeDto"%>
<%@page import="model.dao.WriteDao"%>
<%@page import="javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="../css/page.css" rel = "stylesheet">
</head>
<body>
	<%@ include file="../header.jsp" %>
	
	<div class="webbox">
		<a href="write.jsp">글쓰기</a>
		<%-- <table>
			<tr>
				<th>글번호</th><th>글제목</th><th>작성자</th><th>등록일</th><th>조회수</th>
			</tr>
				<%
					ArrayList<writeDto> list = WriteDao.getInstance().getlist();
					
					for( int i = 0 ; i<list.size(); i++){		
				%>
					<tr>
						<td><%=list.get(i).getbNo() %></td>
						<td><%=list.get(i).getBtitle() %></td>
						<td><%=list.get(i).getBwriter() %></td>
						<td><%=list.get(i).getBdate() %></td>
						<td><%=list.get(i).getBview() %></td>
					</tr>
				<%	
					}				
				%>				
		</table> --%>
		
		<div>게시물 수 : <span class="totalsize"></span></div>
		<div>
			<select class="listsize" onchange="blistsize()">
				<option value="5">5</option>
				<option value="10">10</option>
				<option value="15">15</option>
				<option value="20">20</option>
			</select>
		</div>
		
		<table id="boardlist" class="table">
		</table>
		
		<div class="pagebox"></div>
		
		
		
		<div>
			<select class="key">
				<option value="btitle"> 제목 </option>
				<option value="bcontent"> 내용 </option>
				<option value="bwriter"> 작성자 </option>
			</select>
			<input type="text" placeholder="검색어" class="keyword">
			<button type="button" onclick="bsearch()">검색</button>
		</div>
		
		
	</div>	
	
	
	
	
	<script src="../js/board/list.js"></script>
</body>
</html>