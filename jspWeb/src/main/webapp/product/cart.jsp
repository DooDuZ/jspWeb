<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file = "../header.jsp" %>
	
	<div class="container">
		<table class="table cart_t">
					
		</table>
		<button>선택 삭제</button>
		<button>전체 삭제</button>
		<button>쇼핑하기</button>
		<button onclick="payload()" type="button">결제하기</button>
	</div>
	
	
	
	<script src="../js/product/cart.js"></script>
</body>
</html>