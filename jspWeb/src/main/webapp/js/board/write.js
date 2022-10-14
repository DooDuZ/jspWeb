/**
 * 
 */
 
 $(document).ready(function() {
  $('#summernote').summernote({
		placeholder : '내용 입력',	  
		maxHeight : null,
		minHeight : 300,
		lang : 'ko-KR'
	});  
});
 
 
/*
function bwrite(){
	let input = document.querySelectorAll('input');
	
	let object={	
		btitle : input[1].value ,	//header에 input 하나 있으므로 1번째 인덱스부터 시작
		bcontent : input[2].value
	}
	
	$.ajax({
		url : '/jspWeb/board/write',
		data : object,
		success : (result)=>{
			if(result==='true'){
				location.href = 'http://localhost:8080/jspWeb/board/list.jsp';
			}else{
				location.href = 'http://localhost:8080/jspWeb/member/login.jsp';
			}
		}		
	})	
}
*/
function bwrite(){
	let form = document.querySelector('form');
	
	let formdata = new FormData(form);

	$.ajax({
		url : '/jspWeb/board/write',
		data : formdata,
		//type~~ 세팅은 첨부파일 쓸 경우만 사용
		type : 'POST',	// 메소드 방식 -- 첨부파일은 post에서만 처리 가능
		contentType : false, // 전송할 데이터의 타입
		// 기본값 : application x-www-form-unlencoded; charset = UTF-8 : 대용량 지원 x
		// false : multipart/form-data 
		processData : false, // 전송시 사용되는 타입
		// 기본값 : 전송url 데이터 명시
		// false : 데이터 가려줌. 기본주소만 출력.		
		success : (result)=>{
			if(result==='true'){
				location.href = 'list.jsp';
			}else{
				location.reload();
			}
		}		
	})	
}