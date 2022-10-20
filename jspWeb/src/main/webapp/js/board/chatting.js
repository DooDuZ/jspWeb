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
		new WebSocket('ws'://IP주소/프로젝트명/서버경로)
	

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
	websocket = new WebSocket('ws://localhost:8080/jspWeb/chatting/'+mid);	
	// 2에서 구현된 기능을 클라이언트 소켓에 대입
	websocket.onopen = (e) => {onopen(e)};
	websocket.onclose = (e) => {onclose(e)};
	websocket.onmessage = (e) => {onmessage(e)};
	websocket.onerror = (e)=>{onerror(e)}
}else{
	alert('로그인 후 이용해주세요.');
	location.href = '../member/login.jsp';
}

// 2. 기능 구현 [ 1.서버 접속 2.연결 끊기 3.메시지 전송 4.메시지 받기]
function onopen(e){alert('채팅방에 들어왔습니다.' + e);}
function onclose(e){alert('채팅방을 나갑니다.' + e);}
function send(){
	let msg = {
		content : document.querySelector('.msgbox').value,
		from : mid,
		date : new Date().toLocaleTimeString()
	}
	websocket.send(JSON.stringify(msg));
	document.querySelector('.msgbox').value = '';
		// WebSocket 클래스의 함수 활용
}
function onerror(e){
	alert(e);
}

function onmessage(e){
	let contentbox = document.querySelector('.contentbox')	
	
	let msg = JSON.parse(e.data);
	
	contentbox.innerHTML += `<div>${mid} : ${msg.content}<span class="timestamp">${msg.date}</span></div>`;
}
















