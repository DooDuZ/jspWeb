/**
 * 
 */
 
 function throwdices(){
	let dice1 = document.querySelector('.dice1');
	let dice2 = document.querySelector('.dice2');
	
	let diceNum = Math.floor(Math.random()*6)+1;
	let diceNum2 = Math.floor(Math.random()*6)+1;
	
	dice1.innerHTML = diceNum;
	dice2.innerHTML = diceNum2;
	
	let object = { 
		dice1 : diceNum,
		dice2 : diceNum2		
	}
	send(object);
}

 let websocket =  new WebSocket('ws://localhost:8080/Homework/test/SocketTest');
 
 // new WebSocket('ws://localhost:8080/Homework/test/SocketTest/');
 websocket.onopen = (e) =>{};
 websocket.onclose = (e) =>{};
 websocket.send = (e)=>{ send(e) };
 websocket.onmessage = (e) =>{}; 
 
 function onopen(){}
 function onclose(){}
 function send(object){}
 function onmessage(){}
 