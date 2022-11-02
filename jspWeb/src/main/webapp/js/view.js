/**
 * 
 */
 
 
 let pno = document.querySelector('.pno').value;
 let stockinfo;
 viewPage();
 function viewPage(){
	$.ajax({
		url : "/jspWeb/admin/regist",
		type : "get",
		data : {type : 2, pno : pno},
		success : (result) =>{
			let json = JSON.parse(result);
			
			document.querySelector('.pimg').src = `/jspWeb/admin/pimg/${json.pimg}`;
			document.querySelector('.pname').innerHTML = json.pname;
			document.querySelector('.pcomment').innerHTML = json.pcomment;
			
			let phtml = '';
			
			if(json.discount == 0){
				phtml += `<span class="psale">${json.pprice.toLocaleString}</span>`;
			}else{
				let discount = Math.floor((json.pprice * (1-json.pdiscount))/10)*10;
				
				phtml += `<span class="pdiscount">${json.pdiscount*100}%</span>
						<span class="pprice">${json.pprice}</span>
						<span class="psale">${discount}원</span>`
			}
			document.querySelector('.pricebox').innerHTML = phtml;
			

			
			$.ajax({
				url : '/jspWeb/admin/stock',
				data : {pno : pno},
				type : 'get',
				async : false,
				success : (result)=>{
					stockinfo = JSON.parse(result);
				}				
			})
			
			
			let selhtml = `<option>[필수]색상 선택</option>`;
			
			
			let colorlist = [];
			stockinfo.forEach( c =>{
				colorlist.push(c.pcolor);
			})
			let colorset = new Set(colorlist);
			
			colorset.forEach( c => {
				selhtml += `<option value="${c}">${c}</option>`
			})
			
			/*
			for(let i = 0 ; i<stockinfo.length ; i++){
				selhtml += `<option>${stockinfo[i].pcolor}</option>`
			}
			*/			
			document.querySelector('.sel_color').innerHTML = selhtml;
					
			/*
			
			for(let i = 0 ; i<stockinfo.length ; i++){
				selsize += `<option>${stockinfo[i].psize}</option>`
			}
			*/
			
			
		}	
	})
}

// 컬러 선택시 해당 사이즈 옵션 추가
document.querySelector('.sel_color').addEventListener('change', (e)=>{
	let color = e.currentTarget.value;
	let selsize = `<option>[필수]사이즈선택</option>`;	
	stockinfo.forEach( s=>{
		if(s.pcolor == color){
			selsize += `<option value="${s.psize}">${s.psize}</option>`
		}	
	})
	document.querySelector('.sel_size').innerHTML = selsize;
})
 
 
 
 // 사이즈 선택 시 상품 하단에 추가
 let itemlist = [];
 document.querySelector('.sel_size').addEventListener('change', (e) => {	
	let item = {
		pcolor : document.querySelector('.sel_color').value,
		psize : e.currentTarget.value,
		amount : 1
	}
	itemlist.push(item);
	print()
})

function print(){
	
	let ihtml = `<tr> 
					<th width="60%;">삼품명/옵션</th>
					<th width="20%;">수량</th>
					<th width="20%;">가격</th>
				</tr>`;
	
	for(let i = 0 ; i<itemlist.length ; i++){
		ihtml += `<tr>
					<td>
						<span>${document.querySelector('.pname').innerHTML}</span> <br>
						<span> ${itemlist[i].pcolor} / ${itemlist[i].psize}</span>
					</td>
					<td>
						<div class="row g-0">
							<div class="col-md-6">
								<input class="form-control" value="${itemlist[i].amount}">
							</div>
							<div class="col-md-4">
								<button class="amount_btn" onclick="addAmount()"> ▲ </button>
								<button class="amount_btn" onclick="minusAmount()"> ▼ </button>
							</div>
							<div class="col-md-2">
								<button class="cancel_btn" onclick="clearItem()"> X </button>
							</div>
						</div>
					</td>
					<td>
						<span> ${document.querySelector('.psale').toLocaleString * itemlist[i].amount} 원</span><br>
						<span class="pointbox"> (포인트)2,000 </span>
					</td>
				</tr>`
	}
	document.querySelector('.select_t').innerHTML = ihtml;
}


