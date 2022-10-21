<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>듀듀지월드</title>
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 뷰포트 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<!-- 부트스트랩 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	<!-- 폰트어썸 -->
	<link href="/jspWeb/css/header.css" rel = "stylesheet">
	<!-- 헤더는 모든 페이지에서 사용하므로 상대경로X, 절대 경로로 지정 -->

</head>
<body>
	
	<div class="webbox">
		<div class="hd_top">
			<div class="logo">
				<span class="hd_title">
					<a href="/jspWeb/index.jsp">두두지월드</a>
				</span>
			</div>
			<div class="menu_top">
			
				<!-- 세션 호출 [ JSP 방식 = 템플릿마다 다름 ( JSP vs react ) -->
				
				<% // JSP 스크립트 태그(태그 안에 java문법 작성 가능)
					// jsp 세션 객체 제공
					String loginID = (String) session.getAttribute("mid");
				%>
			
				<ul class="hd_sub">
				<% if(loginID==null){	%>
					<li><a href="/jspWeb/member/login.jsp">로그인</a></li>
					<li><a href="/jspWeb/member/signup.jsp">회원가입</a></li>
				<%	}else{	%>
					<li><%= loginID %></li>
					<li><a href="/jspWeb/member/logout.jsp">로그아웃</a></li>
				<%	} %>					
					<li><a href="/jspWeb/member/info.jsp">마이쇼핑</a></li>
					<li><a href="/jspWeb/board/list.jsp">고객센터</a></li>
				</ul>
			</div>
		</div>
		
		<ul class="hd_menu">
			<li><a href="#"> BIG SIZE! </a></li>
			<li><a href="#"> 아우터 </a></li>
			<li><a href="#"> 상의 </a></li>
			<li><a href="#"> 하의 </a></li>
			<li><a href="#"> 슈즈 </a></li>
			<li><a href="#"> 악세사리 </a></li>
			<li><a href="#"> 1+1 이벤트 </a></li>
			<li><a href="board/chatting.jsp"> 채팅방 </a></li>
			<li class="searchbox">
				<span>
					<input type="text">
					<a href=""><i class="fas fa-search"></i></a>
				</span>
				<a href=""><i class="fas fa-shopping-cart"></i></a>
			</li>
			
		</ul>
	</div>
<!-- 부트스트랩 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<!-- JQUERY 라이브러리 -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>