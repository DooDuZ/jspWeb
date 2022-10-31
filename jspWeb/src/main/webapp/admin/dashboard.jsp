<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<link href="../css/dashboard.css" rel="stylesheet">	
</head>
<body>
	<!--  관리자 페이지  -->
	<% 
		String mid = (String) session.getAttribute("mid");
		if(mid == null || !mid.equals("admin")){
			response.sendRedirect("/jspWeb/member/login.jsp");
		}
	%>
	<!-- marquee : 텍스트 슬라이드(전광판) / 속성 : scrollamount : 슬라이드 속도 -->
	<marquee scrollamount="10">
		공지 표시 위치
	</marquee>
	
	<!-- 사이드바 -->
	<div class="sidebar" onclick="displayMenu()">
		<h1>관리자 메뉴</h1>
		<ul class="side_menu">
			<li class="side_item"><span onclick="pagechange('regist.jsp')">제품 등록</span></li>
			<li class="side_item"><span onclick="pagechange('list.jsp')">제품 목록</span></li>
			<li class="side_item"><span onclick="pagechange('stock.jsp')">재고 관리</span></li>
			<li class="side_item"><span onclick="">주문 관리</span></li>
			<li class="side_item"><span onclick="">매출 관리</span></li>
			<li class="side_item"><span onclick="">회원 목록</span></li>
			<li class="side_item"><span onclick="">배송 관리</span></li>
		</ul>
	</div>
	
	<div id="mainbox">
	
	
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="../js/admin/dashboard.js"></script>
</body>
</html>