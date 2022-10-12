<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="../css/signup.css" rel="stylesheet">

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
		
		<!-- action = /프로젝트명/서블릿url -->
		
		<form action="/jspWeb/member/signup" method="post" class="signupForm">		<!-- request객체가 name으로만 받음 -->
			<h3 class="pagetitle">회원정보</h3>
			<h3 class="parttitle">기본정보</h3>
			<table class="signuptable">
			
			
				<tr>
					<td class="col1">회원번호 : </td>
					<td class="col2" id="mno"></td>
				</tr>
				<tr>
					<td class="col1">가입일 : </td>
					<td class="col2" id="mdate"></td>
				</tr>
				<tr>
					<td class="col1">포인트 : </td>
					<td class="col2" id="mpoint"></td>
				</tr>
				<tr>
					<td class="col1">아이디 : </td>
					<td class="col2"><input readonly="readonly" type="text" id="mid"></td>
				</tr>
				<tr>
					<td class="col1">비밀번호 : </td>
					<td class="col2"><input readonly="readonly" type="password" id="mpw"></td>
					<td class="col3"><button type="button" onclick="updateAction()">수정</button></td>
				</tr>
				<tr>
					<td class="col1">이름 : </td>
					<td class="col2"><input readonly="readonly" type="text" id="mname"></td>
					<td class="col3"><button type="button" onclick="updateAction()">수정</button></td>
				</tr>
				<tr>
					<td class="col1">연락처 : </td>
					<td class="col2"><input readonly="readonly" type="text" id="mphone"></td>
					<td class="col3"><button type="button" onclick="updateAction()">수정</button></td>
				</tr>
				<tr>
					<td class="col1">이메일 : </td>
					<td class="col2"><input readonly="readonly" type="text" id="memail"></td>
					<td class="col3"><button type="button" onclick="updateAction()">수정</button></td>
				</tr>
				<tr>
					<td class="col1" rowspan="2"> 주소 : </td>
					<td class="col2" colspan="2">
						<span>
							<input readonly="readonly" type="text" id="sample4_postcode" placeholder="우편번호" name="address1">
							<input readonly="readonly" type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
						</span>
						<span>
							<input readonly="readonly" type="text" id="sample4_roadAddress" placeholder="도로명주소" name="address2">
							<input readonly="readonly" type="text" id="sample4_jibunAddress" placeholder="지번주소" name="address3">
						</span>
					</td>					
				</tr>
				<tr>
					<td class="col2"><input type="text" id="sample4_detailAddress" placeholder="상세주소" name="address4"></td>
					<td class="col3"><button type="button" onclick="updateAction()">수정</button></td>
				</tr>				
			</table>
			<div class="signupbtnbox">
				<button type="button">회원탈퇴</button>
			</div>
		</form>		
	</div>
	

	
	<!-- 
		get				vs				post
		변수URL표시						URL표시X
		보안 낮음							보안 높음[회원가입 / 로그인]
		캐시(기록)있음						캐시 없음
		다음 접속 시 속도 빠름				접속 속도 동일
		[보안이 필요없는 페이지]				[보안 필요 ex)회원가입, 로그인]
	
	 -->	
	
	<!--
	<div class="webbox">
		<h3>회원 리스트</h3>
		<table id = "memberListTable">		
		</table>
	</div>
	-->
	<script src="../js/member/info.js"></script>
	
</body>
</html>