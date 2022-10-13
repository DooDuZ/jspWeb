/**
 * 
 */

 function getlist(){
	let boardlist = document.querySelector('#boardlist');
	let print = '<tr><th>글번호</th><th>글제목</th><th>작성자</th><th>등록일</th><th>조회수</th></tr>';
	
	$.ajax({
		url : '/jspWeb/board/list',
		success : (result)=>{
			let data = JSON.parse(result);
			
			console.log(data);
			for(let i = 0 ; i<data.length ; i++){
				print+= `<tr><td>${data[i].bno}</td>
						<td><a href="/jspWeb/board/page.jsp?bno=${data[i].bno}">${data[i].btitle}</a></td>
						<td>${data[i].bwriter}</td>
						<td>${data[i].bdate}</td>
						<td>${data[i].bview}</td></tr>`
			}			
			boardlist.innerHTML = print;
		}		
	})	
}

getlist();

/*
function viewContent(i){
	$.ajax({
		url : '/jspWeb/board/page',
		data : {"bno" : i},
		success : (result)=>{
			let content = JSON.parse(result);
		}		
	})
}
*/




/*  */