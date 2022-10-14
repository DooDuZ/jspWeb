/**
 * 
 */

let title = document.getElementsByName('cTitle').value;
let cContent = document.getElementsByName('cContent').value;
let cwriter = document.getElementsByName('cWriter').value;
let cPassword = document.getElementsByName('cPassword').value;
 
const addContent = document.querySelector('.addContent');  // 글 등록 버튼 컨트롤 객체

let count = 0;

function addCon(){
	count++;
	let con = `<tr data-key = ${count}><td> 제목 : ${title} </td><td>작성자 : ${cwriter} </td><td> 본문 : ${cContent} </td></tr>`;
	
	document.getElementById('conBox').innerHTML += con;
}



