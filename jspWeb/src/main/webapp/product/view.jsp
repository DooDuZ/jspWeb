<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="../css/view.css" rel="stylesheet">
</head>
<body>

	<%@include file = "../header.jsp" %>
	<input type="text" value=<%=loginID %> class="mid" style="display : none;">
	<%
		// 경로상의 pno를 request
			// get방식 개념 이해가 다시 필요할듯
		if(request.getParameter("pno") == null){
			response.sendRedirect("../index.jsp");
		}
		int pno = Integer.parseInt(request.getParameter("pno"));
	%>
	<input type="text" value="<%=pno %>" class="pno" style="display : none;">
	
	<div class="container"> <!-- 부트스트랩 container -->
	
		<div class="row">
			<!-- 대표 이미지 -->
			<div class="col-md-6"> <!-- 부트스트랩 12그리드중 6 -->
				<img src="../img/bc반팔.webp" class="pimg">
			</div>
		
			<!-- 상품 정보 -->
			<div class="col-md-6">
				<div class="infobox">
					<h4 class="pname"> 씸플뽀짝반팔티 </h4>
					<div class="pcomment"> 이렇게 쌀 줄 몰랐음니다 </div>
					<!-- 가격 -->
					<div class="pricebox"> <!-- 할인율이 있는 경우 -->
						<span class="pdiscount">30%</span>
						<span class="pprice">20,000원</span>
						<span class="psale">16,000원</span>
					</div>
					
					<!-- 사이즈 종류 -->
					<div class="sizebox">
						<span>[FREE, XL, L, M, S]</span>
					</div>
					
					<table class="table info_t"> <!-- 부트스트랩 테이블 -->
						<tr> <td> 배송구분 </td> <td> 2,500원(백마넌 이상 무료배송) </td> </tr>
						<tr> <td> 카드혜택 </td> <td> 무이자할부 </td> </tr>
						<tr> <td> 적립혜택 </td> <td> 3,000(1%) </td> </tr>
						<tr>
							<td>색상</td>
							<td>
								<select class="cselect">
									<option>[필수]색상 선택</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>사이즈</td>
							<td>
								<select class="sselect">
									<option>[필수]사이즈선택</option>
								</select>
							</td>
						</tr>
					</table>
					
					<!-- 선택된 제품 목록 -->
					<table class="table select_t">
						<tr> 
							<th width="60%;">삼품명/옵션</th>
							<th width="20%;">수량</th>
							<th width="20%;">가격</th>
						</tr>
						<tr>
							<td>
								<span>미라클 라이트 경량 퀄팀 점퍼</span> <br>
								<span>블랙 / Free</span>
							</td>
							<td>
								<div class="row g-0"> <!-- bootstrap g-0 하면 마진이나 패딩값이 다 지워진다함 -->
									<div class="col-md-6">
										<input class="form-control" value="1">
									</div>
									<div class="col-md-4">
										<button class="amount_btn"> ▲ </button>
										<button class="amount_btn"> ▼ </button>
									</div>
									<div class="col-md-2">
										<button class="cancel_btn"> X </button>
									</div>
								</div>
							</td>
							<td>
								<span> 20,000원 </span><br>
								<span class="pointbox"> (포인트)2,000 </span>
							</td>
						</tr>
					</table>
					<div class="row">
						<div class="col-md-6"> 총 상품금액 </div>
						<div class="col-md-6 totalprice"></div>
					</div>
					
					<!--  -->
					<div class="btnbox">
						<button id="btn1">바로 구매</button>
						<button id="btn2" class="btncart">장바구니 담기</button>
						<button id="btn3" class="btnlike"> 찜하기<span class="btnheart">♡</span> </button>
					</div>
				</div>			
			</div>
			
		</div>
		
	</div>
	<script src="../js/product/productview.js"></script>
</body>
</html>