<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- include libraries(jQuery, bootstrap) -->
<!-- include summernote css/js -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">

</head>
<body>
	<%@ include file="../header.jsp" %>
	
	<% if(loginID==null){ response.sendRedirect("../member/login.jsp"); } %>
	
	<div class="">
		<h3>글쓰기</h3>
		<!--  
		<form action="/jspWeb/board/write" method="post">
			제목 : <input type="text" name="btitle"> <br>
			내용 : <input type="text" name="bcontent">
			<input type="submit" value="쓰기">
		</form>
		 -->
		<form>
		 	제목 : <input type="text" id="btitle" name="btitle"> <br>
			 <textarea id="summernote" name="bcontent"></textarea>
			파일 : <input type = "file" name="bfile">
			<button type="button" onclick="bwrite()">글 등록</button>
		</form>
	</div>
	
	<!-- 썸머노트API -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	<script src="lang/summernote-ko-KR.js"></script>
	
	<script src="../js/board/write.js"></script>
</body>
</html>