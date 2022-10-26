<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="../css/regist.css" rel="stylesheet">

</head>
<body>

	<div class="container">
		<div class="formbox">
			<h3>제품 등록</h3>
			<form>
				제품명 : <input type="text" name="pname"><br>
				설명 : <textarea rows="" cols="" name="pcomment"></textarea><br>
				가격 : <input type="text" name="pprice"><br>
				할인율 : <input type="text" name="pdiscount"><br>
				카테고리 : <button type="button" onclick="pcategoryview()">카테고리 추가</button><br>
					<span class="pcategoryaddbox"></span> <br> <!--  카테고리 추가  -->
					<div class="pcategorybox"> <!-- 카테고리 목록 --></div>	
				상품대표이미지 : <input type="file" id="pimg" name="pimg">
				<button type="reset">취소</button><button type="button" onclick="regist()">등록</button>
			</form>
			<div> <!-- 등록된 첨부파일[이미지만 가능] 미리보기 -->
				<img alt="" src="" id="pimgpre">
			</div>
		</div>
		<div class="productlist"></div>
		
	</div>
	
	<script src="../js/admin/regist.js"></script>
</body>
</html>