/**
 * 
 */
 
// 검색 처리
let pageinfo = {
	listsize : document.querySelector('.listsize').value,
	page : 1,
	key : '',
	keyword : ''
};


function bsearch(){
	pageinfo.key = document.querySelector('.key').value;
	pageinfo.keyword = document.querySelector('.keyword').value;
	getlist(1);
}
 
function blistsize(){
	pageinfo.listsize = document.querySelector('.listsize').value
	getlist( 1 );
}

getlist(1);
 function getlist( i ){
	let boardlist = document.querySelector('#boardlist');
	let print = '<tr><th>글번호</th><th>글제목</th><th>등록일</th><th>조회수</th><th>작성자</th></tr>';	
	
	pageinfo.page = i;
	
	$.ajax({
		url : '/jspWeb/board/list',
		data : pageinfo,
		success : (result)=>{
			console.log(result);
			let json = JSON.parse(result);
			let totalPage = json.totalPage;
			let data = json.data
			document.querySelector('.totalsize').innerHTML = json.totalsize;
			let today = new Date().toISOString();
			for(let i = 0 ; i<data.length ; i++){
				if(data[i].bdate.substring(0,10) == today.substring(0,10)){
					data[i].bdate = data[i].bdate.substring(11, 16); 
				}else{
					data[i].bdate = data[i].bdate.substring(0,10);
				}
			}
			
			for(let i = 0 ; i<data.length ; i++){
				print+= `<tr><td>${data[i].bno}</td>
						<td onclick="viewload(${data[i].bno})">${data[i].btitle}</td>
						<td>${data[i].bdate}</td>
						<td>${data[i].bview}</td>
						<td>${data[i].bno}</td></tr>`
			}			
			boardlist.innerHTML = print;
			
			let pagehtml = '';
			if(pageinfo.page <= 1){
				pagehtml += `<button type="button" onclick="getlist(${pageinfo.page})">이전</button>`;
			}else{
				pagehtml += `<button type="button" onclick="getlist(${pageinfo.page-1})">이전</button>`;
			}
			
			
			//번호버튼 
			for(let i = 1; i<=totalPage; i++){
				pagehtml += `<button type="button" onclick="getlist(${i})">${i}</button>`;
			}
			
			if(pageinfo.page>=totalPage){
				pagehtml += `<button type="button" onclick="getlist(${pageinfo.page})">다음</button>`;
			}else{
				pagehtml += `<button type="button" onclick="getlist(${pageinfo.page+1})">다음</button>`;
			}
			document.querySelector('.pagebox').innerHTML = pagehtml;
		}
	})	
}


function viewload(i){
	$.ajax({
		url : '/jspWeb/board/pageLoad',
		data : { "bno" : i },
		success :()=>{
			location.href = 'page.jsp';
		}		
	})
}
