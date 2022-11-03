/**
 * 
 */
 
 let cartlist;
 let totalprice;
 getcart(); 
 function getcart(){
	$.ajax({
		url : '/jspWeb/product/cart',
		type : 'get',
		success : (result)=>{
			cartlist = JSON.parse(result);
			console.log(cartlist);			
			let html = '<tr><th><input type="checkbox"></th><th>이미지</th><th>상품정보</th><th>수량</th><th>가격</th><th>비고</th></tr>';
			for(let i = 0 ; i<cartlist.length ; i++){
				let lastprice = Math.floor((cartlist[i].pprice * (1-cartlist[i].pdiscount))/100)*100;
				console.log(lastprice);
				totalprice += lastprice*cartlist[i].amount;
				html += `<tr width="5%"><td><input type="checkbox"></td>
						<td><img width="80%" src="/jspWeb/admin/pimg/${cartlist[i].pimg}"></td>
						<td>${cartlist[i].pname} + ${cartlist[i].pcolor} + ${cartlist[i].psize}</td>
						<td>${lastprice*cartlist[i].amount}원</td>
						<td>${cartlist[i].amount}</td><td><button>삭제</button></td></tr>`
			}			
			document.querySelector('.cart_t').innerHTML = html;
		}		
	})
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

function requestPay() {
	var IMP = window.IMP; 
	IMP.init("imp14103839"); // [본인]관리자 식별코드 [ 관리자 계정마다 다름 ] 
 	IMP.request_pay({
                pg : 'kcp',
                pay_method : 'card',
                merchant_uid: "57008833-33004", 
                name : '당근 10kg',
                amount : 1004,
                buyer_email : 'Iamport@chai.finance',
                buyer_name : '아임포트 기술지원팀',
                buyer_tel : '010-1234-5678',
                buyer_addr : '서울특별시 강남구 삼성동',
                buyer_postcode : '123-456'
            }, function (rsp) { // callback
                if (rsp.success) {
                    console.log(rsp);
                } else {
                    console.log(rsp);
                }
            });
}