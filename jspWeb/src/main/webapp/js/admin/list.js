/**
 * 
 */
 
function getproduct(){
	let productlist = document.querySelector('.list')
	$.ajax({
		url : '/jspWeb/admin/regist',
		success : (result)=>{
			let datalist = JSON.parse(result);
			let html = `<tr>
						<th>상품 번호</th><th>상품 이미지</th>
						<th>상품명</th><th>상품 설명</th>
						<th>가격</th><th>할인율</th><th>판매가</th><th>제품 상태</th>
						<th>등록일</th><th>상품 유형</th>
						</tr>`;
			for(let i = 0 ; i<datalist.length ; i++){
				let pricelast = Math.floor(datalist[i].pprice * (1-datalist[i].pdiscount));				
				html += `<tr>
						<td>${datalist[i].pno}</td>
						<td><img src="/jspWeb/admin/pimg/${datalist[i].pimg}"></td>			
						<td>${datalist[i].pname}</td>
						<td>${datalist[i].pcomment}</td>
						<td>${datalist[i].pprice}</td>
						<td>${datalist[i].pdiscount*100}%</td>
						<td>${pricelast}</td>
						<td>${datalist[i].paction}</td>
						<td>${datalist[i].pdate}</td>
						<td>${datalist[i].pcno}</td>
						</tr>`;
			}			
			productlist.innerHTML = html;
		}
	})	
}
getproduct();