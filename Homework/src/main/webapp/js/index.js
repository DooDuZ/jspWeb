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
			let output = `<ul><li><div>댓글 번호</div><div>작성자</div><div>내용</div><div>작성일</div><div>비고</div></li></ul>`; 
			let list = JSON.parse(result);
			for(let i = 0 ; i<list.length ; i++){
				output += `<ul id="row_${list[i].cNo}"><li>
							<div>${i+1}</div>
							<div onclick="commentextends(${list[i].cNo}, ${bNo})">${list[i].cWriter}</div>
							<div>${list[i].cContent}</div>
							<div>${list[i].cDate}</div>
							<div>비밀번호 : <input type="password" id="del_${list[i].cNo}"><button onclick="delComment(${list[i].cNo},${bNo})">삭제</button></div>
							</li></ul>`
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
	extendsrow.innerHTML += `<li id="row_${i}_child">
					<div>작성자<input type="text" class="exadd"></div>
					<div>비밀번호<input type="password" class="exadd"></div>
					<div>내용<input type="text" class="exadd"></div>
					<div><button onclick="addEx_comment(${i}, ${bNo})">등록</button></div>
					</li>`;
}

function addEx_comment(cNo, bNo){
	let inputbox = document.querySelectorAll('.exadd');
	let object = {'cWriter' : inputbox[0].value,
					'cPassword' : inputbox[1].value,
					'cContent' : inputbox[2].value,
					'cNo' : cNo,
					'bNo' : bNo
				}
	
	$.ajax({
		url : '/Homework/board/extendsComment',
		data : object,
		success : (result)=>{
			
		}
	})
}
