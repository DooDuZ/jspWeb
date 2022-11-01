/**
 * 
 */
 
 
 let productlist = null;
 let cselect = document.querySelector('.cselect');
 let pselect = document.querySelector('.pselect');
 let rows = document.querySelectorAll('.rows');
 
 
 getcategory();
 function getcategory(){
	$.ajax({
		url : '/jspWeb/admin/addcategory',
		type : 'get',
		success : (result) =>{
			let json = JSON.parse(result);
			let html = '';
			json.forEach( p => {
				html += `<option value="${p.pcno}"> ${p.pcname} </option>`
			})
			cselect.innerHTML += html;
		}
	})
}
 
 cselect.addEventListener('change', (e) =>{
	let pcno = e.currentTarget.value;
	getproduct(pcno);
})

getproduct();

 function getproduct( pcno ){
	$.ajax({
		url : '/jspWeb/admin/regist',
		type : 'get',
		data : {'type' : 1, 'option' : 'all' },
		success : (result) =>{
			productlist = JSON.parse(result);
			let html = '';
			productlist.forEach( p => {
				if(p.pcno == pcno){
					html += `<option value="${p.pno}"> ${p.pname} </option>`
				}				
			})
			pselect.innerHTML = html;
		}
	})	
}

pselect.addEventListener( 'click', (e)=>{
	let pno = e.currentTarget.value;
	productlist.forEach( p => {
		if(p.pno == pno){
			rows[0].innerHTML = p.pcno;
			rows[1].innerHTML = p.pno;
			rows[2].innerHTML = p.pname;
			getstock();
		}
	})
});

function setstock(){
	let info = {
		psize : document.querySelector('.psize').value,
		pcolor : document.querySelector('.pcolor').value, 
		pstock : document.querySelector('.pstock').value, 
		pno : rows[1].innerHTML
	}	
	$.ajax({
		url : "/jspWeb/admin/stock",
		type : 'post',
		data : info,
		success : (result)=>{
			if(result==='true'){
				alert('등록 성공')
				getstock();
			}else{
				alert('등록 실패');
			}
			
		}
	})
}

getstock();
function getstock(){
	$.ajax({
		url : '/jspWeb/admin/stock',
		type : 'get',
		data : {"pno" : rows[1].innerHTML},
		success : (result) =>{
			let json = JSON.parse(result);
			let html = `<tr><th>사이즈</th><th>색상</th><th>재고</th><th>비고</th></tr>`
			for(let i = 0 ; i<json.length ; i++){
				html += `<tr>
					<td>${json[i].psize}</td><td>${json[i].pcolor}</td><td>${json[i].pstock}</td><td>-</td>
				</tr>`
			}
			document.querySelector('#p_list').innerHTML = html;
		}
		
	})
	
}

