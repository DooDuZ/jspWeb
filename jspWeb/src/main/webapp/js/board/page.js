/**
 * 
 */
 

 function viewContent(){
	$.ajax({
		url : "/jspWeb/board/page",
		async : false, // 동기화
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
	rlist();
	
}

viewContent();

function deleteContent(i){
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


function rwrite(){
	let rcontent = document.querySelector('.rcontent').value;
	$.ajax({
		url : '/jspWeb/board/rwrite',
		data : {'rcontent' : rcontent, 'type' : 0},
		type : 'POST',
		success : (result)=>{			
			if(result==='1'){
				alert('댓글 작성 성공');
				rlist();
			}else if(result==='2'){
				alert('로그인 후 이용해주세요.');
				location.href='../member/login.jsp';
			}else{
				alert('[등록 실패] 관리자 문의');
			}
		}
	})	
}



function rlist(){
	$.ajax({
		url : "/jspWeb/reply/rlist",
		data : {"type" : 0},
		success : (result)=>{
			let replylist = JSON.parse(result);
			let html = '';
			for(let i = 0 ; i<replylist.length ; i++){
				let reply = replylist[i];
				
				$.ajax({
					url : "/jspWeb/reply/rlist",
					data : {"type" : 1, "rno" : reply.rno},
					async : false,
					success :(result)=>{
						let rereplylist = JSON.parse(result);
						
						html += `<div><span>${reply.mid}</span><span>${reply.rcontent}</span><span>${reply.rdate}</span>
						<button type="button" onclick="rereplyview(${reply.rno})">답글</button>
						<div id="reply${reply.rno}"></div>`;
						for(let j = 0 ; j<rereplylist.length; j++){
							let rereply = rereplylist[j];
							html += `<div class="rereplybox" style="display:none;" id="replybox${reply.rno}"><span>${rereply.mid}</span><span>${rereply.rcontent}</span><span>${rereply.rdate}</span></div>`;
						}						
						html += `</div>`;
					}
				})												
			}			
			document.querySelector('.replylist').innerHTML = html;
		}
	})
}

function rereplyview(rno){
	document.getElementById(`reply${rno}`).innerHTML = `<input type="text" id="reinput${rno}">
														<button type="button" onclick="rereplywrite(${rno})">답글 등록</button>`;
	if(document.getElementById(`reply${rno}`).style.display=='block'){
		document.getElementById(`reply${rno}`).style.display='none';
		if(document.getElementById(`replybox${rno}`)!=undefined){
			document.getElementById(`replybox${rno}`).style.display='none';
		}		
	}else{		
		document.getElementById(`reply${rno}`).style.display='block';
		if(document.getElementById(`replybox${rno}`) != undefined){
			document.getElementById(`replybox${rno}`).style.display='block';
		}		
	}
}


function rereplywrite(rno){
	let comment = document.querySelector(`#reinput${rno}`).value;
	$.ajax({
		url : '/jspWeb/board/rwrite',
		data : {'rcontent' : comment, "rno" : rno, 'type' : 1},
		type : 'POST',
		success : (result)=>{
			if(result==='1'){
				rlist();
			}else{
				alert('답글 등록 실패');
			}			
		}		
	})
}