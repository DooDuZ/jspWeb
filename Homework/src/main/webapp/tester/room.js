/**
 * 
 */



/* 
	Room Page 구현 중 대기 유저 슬롯 구현하느라 채팅에 필요한 기능이 일부 구현되어 있습니다.
	그러나 대부분 테스트 파일이니, 입맛대로 다 지우시던 활용하시던 갠춘합니다!!	
*/




// 20221030[지웅] userslot 출력
let m_id = document.querySelector('.H_idbox').innerHTML;
// 화면 공유를 위한 소캣 생성 [ 채팅 소켓과 사실상 동일할 수 있음 ]
let websocket =  null;
if(m_id !== 'null'){
	websocket = new WebSocket('ws://localhost:8080/mamin/room/RoomSocket/'+m_id);
	// 2에서 구현된 기능을 클라이언트 소켓에 대입
	websocket.onopen = (e) => {onopen(e)};
	websocket.onclose = (e) => {onclose(e)};
	websocket.onmessage = (e) => {onmessage(e)};
	websocket.onerror = (e)=>{onerror(e)};
}else{
	alert('로그인 후 이용해주세요.');
	location.href = '/mamin/view/login.jsp';
}

//20221029[지웅] websocket 기본 function에 대입할 기능 구현
function onopen(e){}
function onclose(){}
function onmessage(obj){
	let parsing = JSON.parse(obj.data);
	console.log(parsing);
}

function send(object){
	websocket.send(JSON.stringify(object));
}

// 20221029[지웅] 플레이어 입장 / 슬롯에 표시
function addPlayer(e){
	// OnOpen 에서서 입장한 유저 정보와 해당 유저의 slotNo response 받은 후 맞는 위치에 데이터 입력 
}

 
 // 20221029[지웅] chatdisplay test용 function 
function enterKey(){
	if(window.event.keyCode == 13){
		sendMessage();
	}
}
 function sendMessage(){
	document.querySelector('.chatDisplay').innerHTML += `<div>${document.querySelector('.c_inputbox').value}</div>`;
	document.querySelector('.c_inputbox').value = '';
	document.querySelector('.chatDisplay').scrollTop = document.querySelector('.chatDisplay').scrollHeight;	
}

//d