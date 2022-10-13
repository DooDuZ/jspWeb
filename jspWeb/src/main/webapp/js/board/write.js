/**
 * 
 */
 
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