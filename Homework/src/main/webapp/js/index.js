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
			
			/*
			
			
			
			let checkPrint = [];				//object 사용 여부 체크 배열
			let extendslist = [];				//출력 전 정렬용 배열
			for(let i = 0; i<list.length ;i++){
				checkPrint[i] = false;			//인덱스에 맞춰 사용여부 저장
			}
			for(let i = 0 ; i<list.length ; i ++){
				if(!checkPrint[i]){				// 가져온 리스트에서 사용되지 않은 object이면
					extendslist.push(list[i]);	// 정렬용 배열에 push
					checkPrint[i] = true;		// 사용했다고 체크배열에 표시
					let referExtends = [];		// 같은 값을 참조하는 object를 저장할 배열
					for(let j = 0 ; j<list.length; j++){	// 전체검사... 비효율적이지만 일단 동작부터 시키자
						if(list[j].refer === list[i].cNo){	// 전체검사에서 나온 참조값이 위에서 저장한 i번째 인덱스의 코멘트넘버와 같으면
							referExtends.push(list[j]);		// 같은 값 참조 배열에 push
							checkPrint[j] = true;			// 사용한 인덱스 저장
						}
					}
					referExtends.sort((a, b)=>{
						return a.depth-b.depth;			// 가져온 값들을 통해 오름차순 정렬
					})
					for(let j = 0 ; j<referExtends.length ; j++){
						extendslist.push(referExtends[j]);	// 정렬된 값 순차적으로 push
					}
				}
			}			
			console.log(extendslist);
			
			
				---- 주석 풀거면 아래 반복문에 list~~ 이부분 바꿔야함
				
				
			*/
			
			let extendslist = [];
			
			for(let i = 0 ; i<list.length ; i++){		// 저장된 object를 순차적으로 출력
				let blank ='';
				for(let j = 0 ; j<list[i].depth; j++){
					blank += '*';
				}
				output += `<ul id="row_${list[i].cNo}"><li>
							<span>${blank}</span>
							<div>${i+1}</div>
							<div onclick="commentextends(${list[i].cNo}, ${bNo})">${list[i].cWriter}</div>
							<div>${list[i].cContent}</div>
							<div>${list[i].cDate}</div>
							<div>비밀번호 : <input type="password" id="del_${list[i].cNo}"><button onclick="delComment(${extendslist[i].cNo},${bNo})">삭제</button></div>
							</li></ul>`
			}			
			commentbox.innerHTML = output;
		}
	})
}


function checkSelf(i){
	$.ajax({
		url : '/Homework/board/checkSelf',
		data : {'cNo' : i},
		success : (result)=>{
			
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
			if(result==='true'){
				inputbox[0].value='';
				inputbox[1].value='';
				inputbox[2].value='';
				viewComment(bNo);
			}
		}
	})
}