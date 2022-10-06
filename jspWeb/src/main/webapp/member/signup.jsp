<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>회원가입 페이지</h3>
	<!-- action = /프로젝트명/서블릿url -->
	<form action="/jspWeb/member/signup" method="post">		<!-- request객체가 name으로만 받음 -->
		아이디 : <input type="text" name="mid"><br>
		비밀번호 : <input type="password" name="mpw"><br>
		비밀번호 확인 : <input type="password" name="mpws"><br>
		이름 : <input type="text" name="mname"><br>
		연락처 : <input type="text" name="mphone"><br>
		이메일 : <input type="email" name="memail"><br>
		<input type="text" id="sample4_postcode" placeholder="우편번호" name="address1">
		<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
		<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="address2">
		<input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="address3">
		<span id="guide" style="color:#999;display:none"></span>
		<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="address4">
		<input type="submit" value="회원가입">			
	</form>
	

	
	<!-- 
		get				vs				post
		변수URL표시						URL표시X
		보안 낮음							보안 높음[회원가입 / 로그인]
		캐시(기록)있음						캐시 없음
		다음 접속 시 속도 빠름				접속 속도 동일
		[보안이 필요없는 페이지]				[보안 필요 ex)회원가입, 로그인]
	
	 -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="../js/member/signUp.js"></script>
</body>
</html>