<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="css/index.css" rel="stylesheet">
</head>
<body>
	<%@ include file="header.jsp" %> <!-- file="jsp파일 주소" -->
	<!-- 
		<img src="img/s아가댕.jpg" width="100%">
			
		<div class="webbox">
			<h3>메인페이지</h3>
		</div>
	 -->
	<!-- 캐러셀 -->
	<div class="webbox">
		<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img src="/jspWeb/img/도시_밤.png" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="/jspWeb/img/기린_아프리카.png" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="/jspWeb/img/해질녘플라맹구.png" class="d-block w-100" alt="...">
		    </div>
		  </div>
		  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="visually-hidden">Previous</span>
		  </button>
		  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="visually-hidden">Next</span>
		  </button>
		</div>
	</div>
	<!-- 제품 출력 -->
	<div class="container">
		<h6 class="box_title"> CATEGORY BEST </h6>
		<div class="itemlist">			
		</div>
	</div>
	
	<script src="/jspWeb/js/index.js"></script>
</body>
</html>