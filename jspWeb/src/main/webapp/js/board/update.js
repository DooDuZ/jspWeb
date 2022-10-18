/**
 * 
 */
function bView(){
	$.ajax({
		url : '/jspWeb/board/page',
		success : (result) =>{
			let board = JSON.parse(result);
			
			document.querySelector('.btitle').value = board.btitle;
			document.querySelector('.bcontent').value = board.bcontent;
			if(board.file !== null){
				let filedelete = board.bfile+`<button type="button" onclick="bfileDelete()">삭제</button>`
				document.querySelector('.oldbfilebox').innerHTML = filedelete;
			}
			
			$(document).ready(function() {
			$('#summernote').summernote({
					placeholder : '내용 입력',	  
					maxHeight : null,
					minHeight : 300,
					lang : 'ko-KR'
				});  
			});			
		}		
	})
}

bView();

function bfileDelete(){
	if(confirm('[복구불가]삭제 하시겠습니까?')){
		$.ajax({
			url : '/jspWeb/board/bfiledelete',
			success : (result)=>{
				if(result==='true'){
					document.querySelector('oldbfilebox').innerHTML = '';
					// location.reload(); 전체 새로고침 시 수정한 내용 날아감. 버튼 하나만 새로고침 필요
					$("#oldfilebox").load(location.href+'#oldfilebox');
				}else{
					alert('첨부파일 삭제 실패');
				}			
			}		
		})
	}	
}


function bupdate(){
	let form = document.querySelector('form');
	let formdata = new FormData(form);
	console.log(formdata);
	$.ajax({
		url : '/jspWeb/board/bupdate',
		data : formdata,
		// 첨부파일시
		type : "POST",
		contentType : false,
		processData : false,
		success : (result)=>{
			console.log(result);
			if(result==='true'){
				location.href = '/jspWeb/board/page.jsp';
			}else{
				alert('수정실패');
				location.href = '/jspWeb/board/list.jsp';
			}
		}	
	})	
}
















