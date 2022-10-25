<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style type="text/css">
	
	*{margin : 0 ; padding :0; box-sizing: border-box;}
	
	#tester{width : 500px; height : 500px; margin : 0 auto; border : 1px solid black;}
	
	.displayDice{display:flex; align-items: center; justify-content: center;}
	.dice1, .dice2{ width : 30px; height : 30px; margin : 20px; border : 1px solid black; font-size: 20px;}
		
	</style>

</head>
<body>
	<div id="tester">
		<button id="throwDice" onclick="throwdices()">주사위 던지기</button>
		<div class="displayDice">
			<span class="dice1"></span>
			<span class="dice2"></span>
		</div>
	</div>

	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="socketTest.js"></script>
</body>
</html>