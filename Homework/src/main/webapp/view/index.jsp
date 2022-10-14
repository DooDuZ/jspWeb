<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 뷰포트 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	<!-- 폰트어썸 -->

	<link href = "../css/index.css" rel="stylesheet">
</head>
<body>

	<%@ include file="../header.jsp" %>
	<div class = "section_write">
		<h3>글 작성 페이지 </h3>
		<div>
			제목 : <input type="text" id="cTitle"><br>
			내용 : <textarea id="cContent"></textarea><br>
			작성자 : <input type="text" id="cWriter"><br>
			비밀번호 :  <input type="password" id="cPassword">
			<button onclick="addCon()"> 글 등록 </button>
		</div>
	</div>
	
	<section>
		<table id = "boardlist">
		</table>
	</section>
	<div id="contentbox">
		<h3 class="contitle"></h3>
		<div class="viewer"></div>
	</div>
	<div id="commentwrap">
		<div id="inputcomment">
			<h3>댓글</h3>
			<input type="text" id="comWriter">
			<input type="text" id="comPw">
			<input type="text" id="comText">
			<button onclick="addComment()">댓글 등록</button>
		</div>
		<div>
			<div id="commentbox">
			</div>
		</div>
	</div>
	<script src="../js/index.js"></script>
</body>
</html>