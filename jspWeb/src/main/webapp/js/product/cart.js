/*

	데이터 저장용 storage [ JS얘기임. Java 서버 세션이랑 다름...! ]
		ㄴ JS 새로고침해도 유지
		
	1. session
		저장 : sessionstorage.setitem('key', value)
		호출 :  sessionstorage.getitem('key')
		생명주기 : 1. 모든 메모리 삭제 sessionstorage.clear() 2. 특정 메모리 삭제 sessionstorage.removeitem('key') 
	
	2. localstorage
		저장 : localstorage.setitem('key', value)
		호출 : localstorage.getitem('key')
		생명주기 : 1. 모든 메모리삭제 localstorage.clear() 2. 특정 메모리 삭제 localstorage.removeitem('key')
		
		
	세션 : JS[sessionstorage]
			- 모든 브라우저 닫을 때 삭제
			- 열려있는 브라우저끼리 데이터 공유[x]
			-
	쿠키 : JS[localstorage]
			- 브라우저 닫고 다시 열었을때 유지 [ 클라이언트 pc ]
			- 열려있는 브라우저끼리 데이터 공유[O]
			- 재방문시 다시 사용 가능[속도 증가]
		
*/
 let cartlist;
 let totalprice;
 let checkbtnlist; // 1. 모든 체크박스 가져오기
 getcart(); 
 function getcart(){
	console.log('test')
	$.ajax({
		url : '/jspWeb/product/cart',
		type : 'get',
		success : (result)=>{
			console.log('test')
			cartlist = JSON.parse(result);
			console.log(cartlist);
			let html = '<tr><th><input type="checkbox" class="checkbox"></th><th>이미지</th><th>상품정보</th><th>수량</th><th>가격</th><th>비고</th></tr>';
			for(let i = 0 ; i<cartlist.length ; i++){
				let lastprice = Math.floor((cartlist[i].pprice * (1-cartlist[i].pdiscount))/100)*100;
				console.log(lastprice);
				totalprice += lastprice*cartlist[i].amount;
				html += `<tr width="5%"><td><input type="checkbox" class="checkbox"></td>
						<td><img width="30%" src="/jspWeb/admin/pimg/${cartlist[i].pimg}"></td>
						<td>${cartlist[i].pname} + ${cartlist[i].pcolor} + ${cartlist[i].psize}</td>
						<td>${lastprice*cartlist[i].amount}원</td>
						<td>${cartlist[i].amount}</td><td><button>삭제</button></td></tr>`
			}			
			document.querySelector('.cart_t').innerHTML = html;
			checkbtnlist = document.querySelectorAll('.checkbox');
			console.log(checkbtnlist);
			checkbtnlist[0].addEventListener('click', (e)=>{
				if(e.currentTarget.checked == true){
					checkbtnlist.forEach( c => {c.checked = true;})
				}else{
					checkbtnlist.forEach( c => {c.checked = false;})
				}
			})
		}		
	})
}

let checkPlist = [];

function payload(){
	checkbtnlist.forEach( (c , i) =>{
		if(i!=0 && c.checked == true){
			checkPlist.push(cartlist[i-1]); 
		}
	})
	if(checkPlist.length == 0){
		alert('1개 이상 선택해주세요')
		return;
	}
	localStorage.removeItem('checkPlist');
	localStorage.setItem('checkPlist', JSON.stringify(checkPlist));
	location.href = '/jspWeb/product/pay.jsp';
}



let member;
getmember();
function getmember(){
	$.ajax({
		url : "/jspWeb/member/info",
		success : (result)=>{
			member = JSON.parse(result);
			console.log(member);
		}
	})
}

