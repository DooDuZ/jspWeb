/**
 * 
 */
 
function getproduct(){
	let productlist = document.querySelector('.list')
	$.ajax({
		url : '/jspWeb/admin/regist',
		data : {"type" : 1}, // 모든 제품 호출 타입 1
		success : (result)=>{
			let datalist = JSON.parse(result);
			let html = `<tr>
						<th>상품 번호</th><th>상품 이미지</th>
						<th>상품명</th><th>상품 설명</th>
						<th>가격</th><th>할인율</th><th>판매가</th><th>제품 상태</th>
						<th>등록일</th><th>상품 유형</th><th>비고</th>
						</tr>`;
			for(let i = 0 ; i<datalist.length ; i++){
				let pricelast = Math.floor(datalist[i].pprice * (1-datalist[i].pdiscount));				
				html += `<tr>
						<td>${datalist[i].pno}</td>
						<td class="pimg${datalist[i].pno}"><img src="/jspWeb/admin/pimg/${datalist[i].pimg}"></td>
						<td class="pname${datalist[i].pno}">${datalist[i].pname}</td>
						<td class="pcomment${datalist[i].pno}">${datalist[i].pcomment}</td>
						<td class="pprice${datalist[i].pno}">${datalist[i].pprice}</td>
						<td class="pdiscount${datalist[i].pno}">${datalist[i].pdiscount*100}%</td>
						<td>${pricelast}</td>
						<td class="paction${datalist[i].pno}">${datalist[i].paction}</td>
						<td>${datalist[i].pdate}</td>
						<td class="pcno${datalist[i].pno}">${datalist[i].pcno}</td>
						<td>
							<button onclick="updatemodal(${datalist[i].pno})">수정</button>
							<button onclick="deleteproduct(${datalist[i].pno})">삭제</button>
						</td>
						</tr>`;
			}			
			productlist.innerHTML = html;
		}
	})	
}
getproduct();

function deleteproduct(pno){
	if(!confirm('정말 삭제하시겠습니까?')){
		return;
	}
	$.ajax({
		url : '/jspWeb/admin/regist',
		data : {'pno' : pno},
		type : 'delete',
		success : (result)=>{
			if(result==='true'){
				alert('삭제 성공');
				pagechange('list.jsp');
			}
		}
	})
}


let categorylist = null;
getpcategory2();
function getpcategory2(){
	$.ajax({
		url : '/jspWeb/admin/addcategory',
		success : (result) =>{
			categorylist = JSON.parse(result);
		}	
	})
}

function updatemodal( pno ){
	document.querySelector('.updatemodalbtn').click();
	/*	
	ajax없이도 댄다..!
	
	document.querySelector('.pname').value = document.querySelector(`.pname${pno}`).innerHTML;
	document.querySelector('.pcomment').value = document.querySelector(`.pcomment${pno}`).innerHTML;
	document.querySelector('.pprice').value = document.querySelector(`.pprice${pno}`).innerHTML;
	document.querySelector('.pdiscount').value = document.querySelector(`.pdiscount${pno}`).innerHTML;
	document.querySelector('.imgbox').innerHTML = document.querySelector(`.pimg${pno}`).innerHTML;	
	*/
	
	getpcategory2();
	$.ajax({
		url : '/jspWeb/admin/regist',
		data : {"type" : 2, "pno" : pno}, // 모든 제품 호출 타입 1
		success : (result)=>{
			let json = JSON.parse(result);
			document.querySelector('.pno').value = pno;
			document.querySelector('.pname').value = json.pname;
			document.querySelector('.pcomment').value = json.pcomment;
			document.querySelector('.pprice').value = json.pprice;	
			let html = '';
			for(let i = 0 ; i<categorylist.length ; i++){
				html += `<input type="radio" name="pcno" value = "${categorylist[i].pcno}">${categorylist[i].pcname}`
			}
			document.querySelector('.uppcategorybox').innerHTML = html;
			document.querySelector('.pdiscount').value = json.pdiscount;
		}		
	})
}


function updateproduct(){
	let form = document.querySelector('.updateForm');
	let formdata = new FormData(form);
		// formdata에 데이터 추가 -> formdata.set('키': 값)
	$.ajax({
		url : '/jspWeb/admin/regist',
		data : formdata,
		type : 'put',
		processData : false,
		contentType : false,
		success : (result) =>{
			if(result==='true'){
				document.querySelector('.upclosebtn').click();
				pagechange('list.jsp');
			}
		}		
	})
}