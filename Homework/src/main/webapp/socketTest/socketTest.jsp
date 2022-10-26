<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



</head>
<body>

	<table id="boardDisplay">
	
	</table>

	<div id="tester">
		<button id="throwDice" onclick="throwdices()">주사위 던지기</button>
		<div class="displayDice">
			<span class="dice1"></span>
			<span class="dice2"></span>
		</div>
	</div>

	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="printBoard.js"></script>
	<script src="socketTest.js"></script>
</body>
</html>