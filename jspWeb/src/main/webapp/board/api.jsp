<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="../header.jsp" %>
	
	
	
	<div class="container">
	<!-- 지도를 표시할 div 입니다 -->
		<div id="map" style="width:100%;height:350px;"></div>
		
		<table class="apart">
					
		</table>
		
		
		<!-- 약국 상세정보 -->
		<div class="detailbox">
		
		</div>
		
		<div class="row">
			<div class= "col-sm-3">
				<input type="text" class="form-control addrinput">
			</div>
			<div class="col-sm-1">
				<button type="button" class="btn" onclick="addrsearch()">검색</button>
			</div>
		</div>	
		<table class="table">
			<tr>
				<th> 약국명 </th><th> 전화번호 </th> <th> 주소 </th>
			</tr>
		</table>
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a44e9405fc0cd60bd0100fdf445379c0&libraries=services"></script>
	<script src="../js/board/api.js"></script>
</body>
</html>