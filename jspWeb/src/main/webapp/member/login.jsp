<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href = "../css/login.css" rel="stylesheet">

</head>
<body>
	<%@ include file="../header.jsp" %>
	<div class="webbox">
		<div class="loginBox">
			<p>두두지 월드</p>
			<span>로그인 : <input type="text" id = "mid"> </span><br>
			<span>비밀번호 : <input type="password" id = "mpassword"></span> <br>
			<div id="loginconfirm"></div>
			<button onclick="clickBtn()">로그인</button>
		</div>
		
		<div>
			<ul>
				<li><a href="signup.jsp">회원가입</a></li>
				<li><a href="findID.jsp">ID 찾기</a></li>
				<li><a href="findPW.jsp">비밀번호 찾기</a></li>
			</ul>
		</div>
	</div>	
	<script src="../js/member/login.js"></script>
</body>
</html>