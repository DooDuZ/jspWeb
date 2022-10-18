/**
 * 
 */
 

 function viewContent(){
	$.ajax({
		url : "/jspWeb/board/page",
		success : (result)=>{
			let data = JSON.parse(result);

			document.querySelector('#bnobox').innerHTML = data.bNo;
			
			document.querySelector('#idbox').innerHTML = data.mid;
			document.querySelector('#titlebox').innerHTML = data.btitle;
			document.querySelector('#textbox').innerHTML = data.bcontent;
			
			if(data.checkUser){
				document.querySelector('#delbox').innerHTML = `<button onclick="deleteContent(${data.bNo})">삭제하기</button>
															<button><a href="/jspWeb/board/update.jsp">수정하기</a></button>`;
			}
			if(data.bfile!==null){
				document.querySelector('#bfile').innerHTML = `<a href="/jspWeb/board/filedown?bfile=${data.bfile}">${data.bfile}</a>`;
			}else{
				document.querySelector('#bfile').innerHTML = '';
			}
		}		
	})
}

viewContent();

function deleteContent(i){
	console.log(i);
	$.ajax({
		url : '/jspWeb/board/deleteContent',
		data : {"bno" : i},
		success : (result)=>{
			if(result==='true'){
				location.href = 'list.jsp';
			}else{
				alert('[관리자문의]삭제 실패');
				location.href = 'list.jsp';
			}
		}		
	})
}