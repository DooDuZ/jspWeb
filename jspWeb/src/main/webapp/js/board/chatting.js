/**
 * 
 */
 
/*
	port : 같은 pc내부의 프로그램 식별
	ip(internet protocol) : 네트워크에서 기기 식별
	
	
	[socket]
	
	* 컴퓨터 네트워크를 경유하는 프로세스 간 통신의 종착점
	* 소켓에 접속한 IP를 저장 / 접속한 PC간 실시간 통신
	* js에서 Client Socket 생성 / 서버 소켓(java)과 통신
	
	* 소켓 생성
		new WebSocket('ws://IP주소/프로젝트명/서버경로')
	
	
*/

let mid = document.querySelector('.mid').value;

// 전송방식 : 1.보내기버튼 2. 엔터키

function enterKey(){
	if(window.event.keyCode == 13){
		send();
	}
}


// 1. JS에서 지원하는 클라이언트 웹소캣 클래스 [ new WebSocket ]
	// 
let websocket = null; 
if(mid !== 'null'){
	websocket = new WebSocket('ws://192.168.17.70:8080/jspWeb/chatting/'+mid);
	// 2에서 구현된 기능을 클라이언트 소켓에 대입
	websocket.onopen = (e) => {onopen(e)};
	websocket.onclose = (e) => {onclose(e)};
	websocket.onmessage = (e) => {onmessage(e)};
	websocket.onerror = (e)=>{onerror(e)};
}else{
	alert('로그인 후 이용해주세요.');
	location.href = '../member/login.jsp';
}

// 2. 기능 구현 [ 1.서버 접속 2.연결 끊기 3.메시지 전송 4.메시지 받기]
function onopen(e){}
function onclose(e){}
function send(){
	let msg = {
		type : 'msg' ,
		content : document.querySelector('.msgbox').value,
		mid : mid,
		date : new Date().toLocaleTimeString(),
		img : '아가양.jpg'
	}
	websocket.send(JSON.stringify(msg));
	document.querySelector('.msgbox').value = '';
		// WebSocket 클래스의 함수 활용
}

function emosend( emoNo ){
	let msg = {
		type : 'emo' ,
		content : emoNo,
		mid : mid,
		date : new Date().toLocaleTimeString(),
		img : '아가양.jpg'
	}
	websocket.send(JSON.stringify(msg));
}



function onerror(e){
	alert(e);
}

function onmessage(e){
	let msg = JSON.parse(e.data);
	
	if(msg.type==='msg'){
		if(msg.mid === mid){ // 본인 글이면
			let html = document.querySelector('.contentbox').innerHTML;
			html += `<div class="secontent my-3">
						<span class="date">${msg.date}</span>
						<span class="content">${msg.content}</span>
						</div>`;
			document.querySelector('.contentbox').innerHTML = html;
		}else{ // 본인 글 아니면
			let html = document.querySelector('.contentbox').innerHTML;
			html += `<div class="row g-0 my-3">
						<div class="col-sm-1 mx-2">
							<img width="100%;" class="rounded-circle" alt="" src="/jspWeb/img/${msg.img}">
						</div>
						<div class="col-sm-9">
							<div class="recontent">
								<div class="name">${msg.mid}</div>
								<span class="content">${msg.content}</span>
								<span class="date">${msg.date}</span>
							</div>
						</div>
					</div>`;
			document.querySelector('.contentbox').innerHTML = html
		}
	}else if(msg.type==='emo'){
		if(msg.mid === mid){ // 본인 글이면
			let html = document.querySelector('.contentbox').innerHTML;
			html += `<div class="secontent my-3">
						<span class="date">${msg.date}</span>
						<img src="/jspWeb/img/imoji/emo${msg.content}.gif" width="90px;">
						</div>`;
			document.querySelector('.contentbox').innerHTML = html;
		}else{
			let html = document.querySelector('.contentbox').innerHTML;
			html += `<div class="row g-0 my-3">
						<div class="col-sm-1 mx-2">
							<img width="100%;" class="rounded-circle" alt="" src="/jspWeb/img/${msg.img}">
						</div>
						<div class="col-sm-9">
							<div class="recontent">
								<div class="name">${msg.mid}</div>
								<img src="/jspWeb/img/imoji/emo${msg.content}.gif" width="90px;">
								<span class="date">${msg.date}</span>
							</div>
						</div>
					</div>`;
			document.querySelector('.contentbox').innerHTML = html
		}
	}else if(msg.type==='alarm'){
		let html = document.querySelector('.contentbox').innerHTML;
		html += `<div class="alarm"><span>${msg.content}</span></div>`;
		document.querySelector('.contentbox').innerHTML = html;
	}
	
	// 스크롤 조작
	document.querySelector('.contentbox').scrollTop = document.querySelector('.contentbox').scrollHeight;	
}

emoview() // 이모티콘 호출 
function emoview(){ // 이모티콘 호출 함수 
	let html ='';
	for( let i = 1 ; i<=43 ; i++ ){
		html +=  `<img src="/jspWeb/img/imoji/emo${i}.gif" width="70px" onclick="emosend(${i})">`;
	}
	document.querySelector('.dropdown-menu').innerHTML = html;
}