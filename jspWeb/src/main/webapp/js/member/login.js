/**
 * 
 */
 
 // HTML과 서블릿 통신
 
 // html 입력된 데이터 가져오기 [ dom ]


function clickBtn(){
	// html의 데이터 가져오기
	let mid = document.querySelector('#mid').value;
 	let mpassword = document.querySelector('#mpassword').value;
 	let loginconfirm = document.querySelector('#loginconfirm');
	
	// 서블릿으로 데이터 보내기
		// 1. JQEURY 라이브러리 포함
		// 2. AJAX (비동기 통신 기법)
	// $.ajax({ 속성명 = 값, 속성명 = 값 , 속성명 = 값})
		// url : 서블릿 URL ,
		// data : 전송할 데이터 { 키 : 값 , 키 : 값 ...} ,
		// success : function(매개변수아무거나){}
		
		//ajax의 기본 통신 : get
	// async : 동기화 관련 명령어
	$.ajax({
		url : "/jspWeb/member/login" , 
		data : {"mid" : mid, "mpassword" : mpassword},
		success : function(re){
			console.log(re);
			if(re==='1'){
				alert('로그인 성공')
				location.href= '/jspWeb/index.jsp'; // js하이퍼링크
			}else if(re==='0'){
				loginconfirm.innerHTML = '존재하지 않는 ID';
			}else if(re==='2'){
				alert('로그인 실패')
				loginconfirm.innerHTML = '비밀번호 불일치';
			}else if(re==='3'){
				loginconfirm.innerHTML = '서버오류';
			}
		}
	});
}



 
 
 
 
 
