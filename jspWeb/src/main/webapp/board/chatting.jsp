<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="../css/chatting.css" rel="stylesheet">
</head>
<body>

	<%@ include file="../header.jsp" %>
	<!-- 로그인 변수 숨기기 -->
	<input type="hidden" class="mid" value="<%= loginID %>">
	
	<div class="container"> <!-- 부트스트랩 css에서 미리 만들어진 class 사용 -->
		<div class="col-sm-6 offset-3 chattingbox">
			<div class="row">
				<div class="col-sm-8"> <!-- 채팅창 -->
					<div class="contentbox my-3"></div>
				
					<textarea rows="" cols="" class="form-control msgbox" onkeyup="enterKey()"></textarea>
					<div class="row">
						<div class="col-sm-2">
							<button class="dropdown-toggle" type="button" id="emobutton" data-bs-toggle="dropdown">
								이모티콘
							</button>
							<ul style="width: 400px; height: 200px;" aria-labelledby="emobutton" class="dropdown-menu">
								<!-- 이모티콘 표시 구역 -->
							</ul>
						</div>
						<div class="col-sm-3 offset-7">
							<button class="form-control" type="button" onclick="send()">보내기</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="../js/board/chatting.js"></script>
</body>
</html>