<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="../css/signup.css" rel="stylesheet">
</head>
<body>
	<%@ include file="../header.jsp" %>>
	
	<div class="webbox">
		
		<!-- action = /프로젝트명/서블릿url -->
		
		<form action="/jspWeb/member/signup" method="post" class="signupForm">		<!-- request객체가 name으로만 받음 -->
			<h3 class="pagetitle">회원가입</h3>
			<h3 class="parttitle">기본정보</h3>
			<table class="signuptable">
				<tr>
					<td class="col1">아이디 : </td>
					<td class="col2"><input type="text" name="mid" id="mid" onchange="midEvent()"></td>
					<td class="col3" id="midtd"></td>
				</tr>
				<tr>
					<td class="col1">비밀번호 : </td>
					<td class="col2"><input type="password" name="mpw" id="mpw" onchange="mpwEvent()"></td>
					<td class="col3"></td>
				</tr>
				<tr>
					<td class="col1">비밀번호 확인 : </td>
					<td class="col2"><input type="password" name="mpws" id="mpws" onchange="mpwsEvent()"></td>
					<td class="col3"></td>
				</tr>
				<tr>
					<td class="col1">이름 : </td>
					<td class="col2"><input type="text" name="mname" id="mname"  onchange="mnameEvent()"></td>
					<td class="col3"></td>
				</tr>
				<tr>
					<td class="col1">연락처 : </td>
					<td class="col2"><input type="text" name="mphone" id="mphone" onchange="mphoneEvent()"></td>
					<td class="col3"></td>
				</tr>
				<tr>
					<td class="col1">이메일 : </td>
					<td class="col2"><input type="text" name="memail" id="memail" onchange="memailEvent()"></td>
					<td class="col3"></td>
				</tr>
				<tr>
					<td class="col1" rowspan="2"> 주소 : </td>
					<td class="col2" colspan="2">
						<span>
							<input type="text" id="sample4_postcode" placeholder="우편번호" name="address1">
							<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
						</span>
						<span>
							<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="address2">
							<input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="address3">
						</span>
					</td>					
				</tr>
				<tr>
					<td class="col2"><input type="text" id="sample4_detailAddress" placeholder="상세주소" name="address4"></td>
					<td class="col3">test</td>
				</tr>
				
			</table>
			<h3 class="parttitle">이용약관</h3>			
			<span class="confimrbox">
				<textarea readonly="readonly">
					두두지월드에선 두두지가 왕입니다.
				</textarea>
				<input type="checkbox" id="confirm1"><span>[필수] 이용약관 동의</span>
				<textarea readonly="readonly">
					두두지신부 모집중
				</textarea>
				<input type="checkbox" id="confirm2"><span>[필수] 개인정보 수집 및 이용 동의 </span>			
			</span>
			
			<div class="signupbtnbox">
				<button type="reset">취소하기</button>
				<button type="button" onclick="formsubmit()">회원가입</button>
			</div>
		</form>		
	</div>
	

	
	<!-- 
		get				vs				post
		변수URL표시						URL표시X
		보안 낮음							보안 높음[회원가입 / 로그인]
		캐시(기록)있음						캐시 없음
		다음 접속 시 속도 빠름				접속 속도 동일
		[보안이 필요없는 페이지]				[보안 필요 ex)회원가입, 로그인]
	
	 -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="../js/member/signUp.js"></script>
</body>
</html>