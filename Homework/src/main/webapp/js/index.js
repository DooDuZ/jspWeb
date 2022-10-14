/**
 * 
 */
 

printboard();

function addCon(){
	let title = document.getElementById('cTitle').value;
	let content = document.getElementById('cContent').value;
	let writer = document.querySelector('#cWriter').value;
	let password = document.querySelector('#cPassword').value;

	$.ajax({
		url : "/Homework/board/addContent",
		data : {"title" : title, "content" : content , "writer" : writer , "password" : password},
		success : (result)=>{
			if(result==='true'){
				alert('글 등록 성공')
				location.href = "/Homework/view/index.jsp";
			}else{
				alert('글 등록 실패')
			}
		}
	})	
}


function printboard(){
	$.ajax({
		url : '/Homework/board/PrintBoard',
		data : '',
		success : (result)=>{
			let contentList = JSON.parse(result);
			
			let boardlist = document.getElementById('boardlist');
			let board = `<tr><th>글 번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th><th>비고</th></tr>`
			for(let i = 0 ; i<contentList.length ; i++){
				board += `<tr id=${contentList[i].cNo}><td>${contentList[i].cNo}</td>
						<td onclick="viewContent(${contentList[i].cNo})">${contentList[i].Title}</td>
						<td>${contentList[i].Writer}</td>
						<td>${contentList[i].Date}</td>
						<td>${contentList[i].view}</td>
						<td class="del_${contentList[i].cNo}"><button onclick="viewDelete(${contentList[i].cNo})">삭제하기</button></td>
						</tr>`
			}
			boardlist.innerHTML = board;
		}		
	})	
}


function viewDelete(i){
	let delbox = document.querySelector(`.del_${i}`);
	delbox.innerHTML = `<input type = password class=delInput> <br> <button onclick="deleteContent(${i})">삭제</button>`;
}



function deleteContent(i){
	let password = document.querySelector('.delInput').value;
	// let password = prompt('비밀번호 입력');	
	$.ajax({
		url : '/Homework/board/deleteContent',
		data : {'cNo' : i, 'password' : password},
		success : (result)=>{
			if(result==='true'){
				alert('삭제 성공')
				printboard();
			}else{
				alert('[관리자문의]삭제 실패');
			}
		}
	})
}

function viewContent(i){
	let contitle = document.querySelector('.contitle');
	let viewer = document.querySelector('.viewer');
	$.ajax({
		url : '/Homework/board/viewContent',
		data : {'cNo' : i},
		success : (result)=>{
			let data = JSON.parse(result);
			contitle.innerHTML = data.title;
			viewer.innerHTML = data.content;
			viewComment(i);
			printboard();
		}
	})	
}


function viewComment(i){
	let bNo = i;
	let commentbox = document.querySelector('#commentbox');
	$.ajax({
		url : '/Homework/board/viewComment',
		data : { 'cNo' : i },
		success : (result)=>{
			let input = `<h3>댓글</h3>
							작성자 : <input type="text" id="comWriter">
							비밀번호 : <input type="password" id="comPw">
							내용 : <input type="text" id="comText">
							<button onclick="addComment(${i})">댓글 등록</button>`;
			document.getElementById('inputcomment').innerHTML = input;
			let output = `<tr><th>댓글 번호</th><th>작성자</th><th>내용</th><th>작성일</th><th>비고</th></tr>`; 
			let list = JSON.parse(result);
			for(let i = 0 ; i<list.length ; i++){
				output += `<tr id="row_${list[i].cNo}"><td>${i+1}</td>
							<td onclick="commentextends(${list[i].cNo}, ${bNo})">${list[i].cWriter}</td>
							<td>${list[i].cContent}</td>
							<td>${list[i].cDate}</td>
							<td>비밀번호 : <input type="password" id="del_${list[i].cNo}"><button onclick="delComment(${list[i].cNo},${bNo})">삭제</button></td>
							</tr>`
			}			
			commentbox.innerHTML = output;
		}
	})
}


function addComment(i){
	let comWriter = document.querySelector('#comWriter').value;
	let comPw = document.querySelector('#comPw').value;
	let comText = document.querySelector('#comText').value;
	$.ajax({
		url : '/Homework/board/addComment',
		data : {'bNo' : i ,  'comWriter' : comWriter, 'comPw' : comPw, 'comText' : comText},
		success : (result)=>{
			if(result==='true'){
				viewComment(i);
			}else{
				alert('댓글 등록 실패');
			}
		}	
	})	
}


function delComment(i, bNo){
	let pw = document.querySelector(`#del_${i}`).value;
	$.ajax({
		url : '/Homework/board/delComment',
		data : {'cNo' : i, 'cPassword' : pw},
		success : (result)=>{
			if(result==='true'){
				viewComment(bNo);
			}else{
				alert('삭제 실패');
			}			
		}		
	})
}

function commentextends(i, bNo){
	let extendsrow = document.querySelector(`#row_${i}`);
	console.log(extendsrow)
	extendsrow.innerHTML += `</tr><tr id="row_${i}_child">
					<td>작성자<input type="text"></td>
					<td>비밀번호<input type="password"></td>
					<td>내용<input type="text"></td>
					<td></td><td></td>`;
}

