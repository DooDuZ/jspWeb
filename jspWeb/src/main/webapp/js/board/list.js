/**
 * 
 */

 function getlist(){
	let boardlist = document.querySelector('#boardlist');
	let print = '<tr><th>글번호</th><th>글제목</th><th>등록일</th><th>조회수</th><th>작성자</th></tr>';
	
	$.ajax({
		url : '/jspWeb/board/list',
		success : (result)=>{
			let data = JSON.parse(result);	
			console.log(data);
			for(let i = 0 ; i<data.length ; i++){
				print+= `<tr><td>${data[i].bno}</td>
						<td onclick="viewload(${data[i].bno})">${data[i].btitle}</td>
						<td>${data[i].bdate}</td>
						<td>${data[i].bview}</td>
						<td>${data[i].bno}</td></tr>`
			}			
			boardlist.innerHTML = print;
		}
	})	
}

getlist();

function viewload(i){
	$.ajax({
		url : '/jspWeb/board/pageLoad',
		data : { "bno" : i },
		success :()=>{
			location.href = 'page.jsp';
		}		
	})
}
