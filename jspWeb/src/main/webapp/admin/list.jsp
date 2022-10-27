<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link href="../css/list.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<table class="list table"></table>
		
		<!-- 부트스트랩 모달 -->
		<!-- Button trigger modal -->
		<button style="display:none;" type="button" class="updatemodalbtn btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
		  Launch static backdrop modal
		</button>
		
		<!-- Modal -->
		<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h1 class="modal-title fs-5" id="staticBackdropLabel">제품 수정</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form class="updateForm">
		        	제품번호 : <input type="text" class="pno" name="pno" readonly = "readonly"><br>
					제품명 : <input type="text" name="pname" class="pname"><br>
					설명 : <textarea rows="" cols="" name="pcomment" class="pcomment"></textarea><br>
					가격 : <input type="text" name="pprice" class="pprice"><br>
					할인율 : <input type="text" name="pdiscount" class="pdiscount"><br>
					카테고리 : <div class="uppcategorybox"> <!-- 카테고리 목록 --></div>	
					<br>
					제품 상태 : 
						<input type="radio" name="action" value="0" class="paction"> 준비중
						<input type="radio" name="action" value="1" class="paction"> 판매중
						<input type="radio" name="action" value="2" class="paction"> 재고 없음 <br>
					상품대표이미지 : 
					<input type="file" id="pimg" name="pimg" class="pimg">
				</form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="upclosebtn btn btn-secondary" data-bs-dismiss="modal">닫기</button>
		        <button type="button" class="btn btn-primary" onclick="updateproduct()">수정</button>
		      </div>
		    </div>
		  </div>
		</div>
	</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script src="../js/admin/list.js"></script>
</body>
</html>