/**
 * 
 */
 
 let checkPlist = JSON.parse(localStorage.getItem('checkPlist'));
let checkbtn = document.querySelector('.checkbtn');

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


checkbtn.addEventListener('click', (e)=>{
	if(e.currentTarget.checked == true){
		document.querySelector('.oname').value = member.mname;
		document.querySelector('.ophone').value = member.mphone;
		document.querySelector('.oaddress').value = member.maddr;
	}else{
		document.querySelector('.oname').value = '';
		document.querySelector('.ophone').value = '';
		document.querySelector('.oaddress').value = '';
	}
	
})
 
 
 let pmethod;
 
 function paymethod(payM){
	pmethod = payM;
	alert(pmethod);
}
 
 function requestPay() {
	
	let totalprice = 0;
	for(let i = 0 ; i<checkPlist.length ; i++){
		totalprice += checkPlist[i].pprice * (1-checkPlist[i].pdiscount)*checkPlist[i].amount; 
	}
	
	console.log(totalprice);
	
	var IMP = window.IMP; 
	IMP.init("imp14103839"); // [본인]관리자 식별코드 [ 관리자 계정마다 다름 ] 
 	IMP.request_pay({
                pg : 'kcp',
                pay_method : pmethod,
                merchant_uid: "57008833-33004", 
                name : checkPlist[0].pname + `외 ${checkPlist.length-1}개`,
                amount : totalprice,
                buyer_email : 'Iamport@chai.finance',
                buyer_name : member.mname,
                buyer_tel : member.mphone,
                buyer_addr : member.maddr,
                buyer_postcode : '123-456'
            }, function (rsp) { // callback
                if (rsp.success) {
                    console.log(rsp);
                    setorder();
                } else {
                    console.log(rsp);
                    setorder();
                }
            });
}

function setorder(){
	let oinfo = {
		oname : document.querySelector('.oname').value,
		ophone : document.querySelector('.ophone').value,
		oaddress : document.querySelector('.oaddress').value
	}	
	$.ajax({
		url : '/jspWeb/product/order',
		data : {"data" : JSON.stringify(checkPlist), "oinfo" : JSON.stringify(oinfo)},
		type : 'post',
		success : (result) =>{
			if(result == 'true'){
				alert('주문 완료');
				localStorage.removeItem('.checkPlist');
				location.href = "/jspWeb/product/ordersuccess.jsp";
			}else{
				alert('주문실패[관리자 문의]');
			}
		}
		
	})
}