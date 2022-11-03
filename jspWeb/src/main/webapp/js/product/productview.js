/**
 * 
 */
 let stock = null // 재고목록  
let product = null // 제품 
let color = null; /// 선택된 색상 
let productlist = [] // 선택된 제품옵션 [색상,사이즈,개수] 리스트/목록 선언 
let psale = [];
// *. 현재 페이지내 제품번호[ a href="링크?pno=제품번호" ]를 가지고 와서 ajax로 해당 제품번호의 모든 제품정보를 가져오자 
let pno = document.querySelector('.pno').value
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////// 이벤트 /////////////////////////////////////////////////
// **색상 select 박스를 체인지 했을때 이벤트 
document.querySelector('.cselect').addEventListener('change' , (e)=>{
	color = e.currentTarget.value	// 이벤트를 발생한 객체[cselect]의 담겨져있는 값 
	// 8. 색상 select 에서 선택된 색상 의 사이즈 select 구성 
	let shtml = '<option>-[필수] 사이즈 선택</option>'
	stock.forEach( s => {
		if( s.pcolor == color ){	// 재고목록중 색상 과 선택된 색상 같으면 해당 사이즈 html 구성
			shtml += '<option value='+s.psize+'> '+s.psize+' </option>'
		}
	})
	document.querySelector('.sselect').innerHTML = shtml
})

// **사이즈 select 박스를 체인지 했을때 이벤트
document.querySelector('.sselect').addEventListener('change' , (e)=>{
	let size = e.currentTarget.value;
	if(size == '[필수]사이즈선택'){
		return;
	}
	for(p of productlist){
		if(p.pcolor == color && p.psize == size){
			p.amount++;
			print();
			return;
		}
	}
	// 선택된 제품정보와 옵션을 객체 만든다.
	let sproduct = {
		pcolor : color , 	// 색상
		psize : size , 		// 사이즈 
		amount : 1			// 수량
	}
	productlist.push( sproduct ) // 리스트에 담는다.
	print() // 리스트에 존재하는 객체를 출력한다. 
})


// ** 찜하기 버튼 함수

document.querySelector('.btnlike').addEventListener('click' , (e) => {
	let h_idbox = document.querySelector('.h_idbox').innerHTML;
	if(h_idbox == 'null'){
		alert('로그인 후 이용해주세요');
		location.href = '../member/login.jsp';
		return;
	}
	$.ajax({
		url : '/jspWeb/product/plike',
		data : {"pno" : pno},
		type : 'post',
		success : (result) =>{
			console.log(result);
			if(result==='1'){
				document.querySelector('.btnheart').innerHTML = '♥';
			}else if(result==='0'){
				document.querySelector('.btnheart').innerHTML = '♡';
			}else if(result==='3'){
				alert('서버 오류');
			}
		}
		
	})
	
})

// 장바구니 버튼을 눌렀을 때
document.querySelector('.btncart').addEventListener('click', (e)=>{
	if(productlist.length == 0){
		alert('최소 1개 이상의 옵션을 선택해주세요.');
	}
	if(document.querySelector('.mid').value == 'null'){
		alert('로그인 후 이용 가능');
	}
	$.ajax({
		url: '/jspWeb/product/cart',
		type : 'post',
		data : {"data" : JSON.stringify(productlist), "pno" : pno},
		success : (result) => {
			alert(result);
		}
	})
})


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// js 열람시 최초로 함수 1번 실행 

getproduct( pno ) 	// 제품 정보 호출 [ pno ]
getstock( pno )		// 제품 재고 호출 [ pno ]
sethtmlprint()		// *위 메소드 안에 있는 ajax가 모두 실행된 후에 print 실행
// 1. 해당 제품 번호의 제품정보 호출 
function getproduct( pno ){
	$.ajax({	// 결과와 상관없이 다음코드가 진행 [ async : true 결과를대기X VS async : false 결과를대기O  ]
		url : "/jspWeb/admin/regist" ,	
		type : "get" , 
		async : false , 	// 결과가 있을때까지 대기 상태
		data : { "type" : 2 , "pno" : pno } ,
		success : re => { product = JSON.parse( re );  }
	})
}
// 2. 해당 제품의 정보를 HTML 대입 메소드 
function sethtmlprint(){
		document.querySelector('.pimg').src ='/jspWeb/admin/pimg/'+product.pimg // 1.제품사진 대입
		document.querySelector('.pname').innerHTML = product.pname// 2.제품명 대입
		document.querySelector('.pcomment').innerHTML = product.pcomment // 3.제품설명 대입
		let phtml = '' // 4.가격 대입
		if( product.pdiscount == 0 ){ // 2. 할인이 없을때	[ 천단위 쉼표 함수 : 데이터.toLocaleString() ]
			phtml += '<span class="psale">'+(product.pprice.toLocaleString() )+'원</span>'
		}else{ // 1. 할인이 있을때						[ 반올림(소수점버리고 반올림) : Math.round( 데이터 ) ]
			phtml +=
				'<span class="pdiscount">'+ Math.round( product.pdiscount * 100 )+'%</span>'+
				'<span class="pprice">'+( product.pprice.toLocaleString() )+'원</span>'+
				'<span class="psale">'+ ( product.pprice -( product.pprice * product.pdiscount ) ).toLocaleString() +'원</span>'
		}
		document.querySelector('.pricebox').innerHTML = phtml 
		
		let sizelist = [ ]						// 1. 중복이 있는 사이즈 배열 선언
		stock.forEach( s => {  sizelist.push( s.psize ) })	// 2.리스트에 담기 
		let sizeset = new Set( sizelist ) 		// 2. 사이즈 리스트 => set 목록 변경 [중복제거]
			console.log( sizeset ) 				// 3. 확인
		
			// 중복이 없는 사이즈목록 html 구성
		let shtml = '<span> [ '
		sizeset.forEach( s => { 
			shtml += " " + s +" "
		})
		shtml += ' ] </span>'
		
		document.querySelector('.sizebox').innerHTML = shtml
		
		// 7. 색상 select 구성  // 색상 목록 중복제거	[ set , includes , filter 등 ]
		let colorlist = []
		stock.forEach( s => {  colorlist.push( s.pcolor ) })
		let colorset = new Set( colorlist )
			console.log( colorset )			// 3. 확인
		
		let chtml = '<option>-[필수] 색상 선택</option>'
		colorset.forEach( c => { 
			chtml += '<option value='+c+'>'+c+'</option>'
		})
		document.querySelector('.cselect').innerHTML = chtml
}
// 3. 재고 가져오는 함수 메소드 
function getstock( pno ){ // 5. 현재 제품의 재고목록 호출 [ ajax ]
	$.ajax({
		url : "/jspWeb/admin/stock" ,
		type : "get" , 
		async : false , 
		data : { "pno" : pno },
		success : (re) => { stock = JSON.parse( re ) }
	});
}
// 4. 선택된 제품옵션 리스트를 출력하는 함수 [ 1. 사이즈선택 했을때 2.옵션 제거 했을때 마다 실행]



function print(){
	let ohtml = '<tr> <th width="60%">상품명/옵션 </th>  <th width="25%">수량</th>  <th width="15%"> 가격 </th>  </tr>';
	let psale = product.pprice * (1-product.pdiscount);
	
	let totalprice = 0;
	let totalamount = 0;
	
	productlist.forEach( (p, i) => {				
		let priceAmount = psale * p.amount;
		let tpoint = Math.round(priceAmount * 0.01);
		
		totalprice += priceAmount;
		totalamount += p.amount;
		
		ohtml +=  `<tr>
					<td>
						<span>${document.querySelector('.pname').innerHTML}</span> <br>
						<span> ${p.pcolor} / ${p.psize}</span>
					</td>
					<td>
						<div class="row g-0">
							<div class="col-md-6">
								<input readonly class="form-control" value="${p.amount}">
							</div>
							<div class="col-md-4">
								<button class="amount_btn" onclick="addAmount(${i})"> ▲ </button>
								<button class="amount_btn" onclick="minusAmount(${i})"> ▼ </button>
							</div>
							<div class="col-md-2">
								<button class="cancel_btn" onclick="clearItem()"> X </button>
							</div>
						</div>
					</td>
					<td>
						<span> ${priceAmount.toLocaleString()}원</span><br>
						<span class="pointbox"> (포인트) ${tpoint} </span>
					</td>
				</tr>`
	}) // for end
	document.querySelector('.select_t').innerHTML = ohtml;
	let tohtml = `${totalprice.toLocaleString()}원(${totalamount}개)`;
	document.querySelector('.totalprice').innerHTML = tohtml;
}

function addAmount(i){
	let maxstock = 0;
	stock.forEach( s=>{
		if(s.pcolor == productlist[i].pcolor && s.psize == productlist[i].psize){
			maxstock = s.pstock;
		}
	})
	
	if(productlist[i].amount >= maxstock){
		alert('재고가 부족합니다.');
		return;
	}	
	productlist[i].amount++;
	print();
}
function minusAmount(i){
	if(productlist[i].amount<=1){
		return;
	}	
	productlist[i].amount--;
	print();
}


function pcancel(i){
	productlist.splice(i, 1);
	print();
}