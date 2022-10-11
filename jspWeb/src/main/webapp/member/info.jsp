<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 헤더 페이지 호출 -->
	<%@include file="../header.jsp" %>
	
	<%
		if(loginID==null){
			response.sendRedirect("login.jsp");
		}
	%>
	
	<div class="webbox">
		<h3> 회원 정보 </h3>
		<button onclick="viewDelete()">회원 탈퇴</button>
		<div id = "deletebox">
		</div>
		<table>
			<tr>
				<td> 회원번호 </td> <td id="mno"> <%= loginID %> </td>
			</tr>
			<tr>
				<td> 아이디 </td> <td id="mid"> <%= loginID %> </td>
			</tr>	
			<tr>
				<td> 이름 </td> <td id="mname"> <%= loginID %> </td>
			</tr>	
			<tr>
				<td> 전화번호 </td> <td id="mphone"> <%= loginID %> </td>
			</tr>	
			<tr>
				<td> 이메일 </td> <td id="memail"> <%= loginID %> </td>
			</tr>	
			<tr>
				<td> 주소 </td> <td id="maddr"> <%= loginID %> </td>
			</tr>
			<tr>
				<td> 가입일 </td> <td id="mdate"> <%= loginID %> </td>
			</tr>	
			<tr>
				<td> 포인트 </td> <td id="mpoint"> <%= loginID %> </td>
			</tr>		
		</table>
	</div>
	
	
	<div class="webbox">
		<h3>회원 리스트</h3>
		<table id = "memberListTable">		
		</table>
	</div>
	
	<script src="../js/member/info.js"></script>
	
</body>
</html>