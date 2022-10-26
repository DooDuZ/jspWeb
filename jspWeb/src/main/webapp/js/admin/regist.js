/**
 * 
 */
 
 function regist(){	
	let form = document.querySelector('form');
	let formdata = new FormData(form);
	$.ajax({
		url : '/jspWeb/admin/regist',
		data : formdata,
		// form 전송인 경우 아래 3가지 필수!!! -> 멀티파트 전송
		type : 'POST',
		processData : false,
		contentType : false,
		success : ( result )=>{
			if(result==='true'){
				alert('등록 성공');
			}else{
				alert('등록 실패');
			}
		}
	})
}

// 이벤트 추가
let pimg = document.querySelector('#pimg');
pimg.addEventListener('change', (e)=>{
	let file = new FileReader();
	file.readAsDataURL(e.target.files[0]);
	file.onload = (e)=>{
		document.querySelector('#pimgpre').src = e.target.result;
	}
})

//카테고리 추가버튼 view 함수
function pcategoryview(){
	document.querySelector('.pcategoryaddbox').innerHTML = `<input type="text" id="pcname" name="pcname">
												<button type="button" onclick="pcategoryadd()"> 카테고리 등록 </button>`
}

// 카테고리 추가 함수
function pcategoryadd(){	
	let pcname = document.querySelector('#pcname').value;	
	$.ajax({
		url : '/jspWeb/admin/addcategory',
		data : {"pcname" : pcname},
		type : 'POST',
		success : (result)=>{
			if(result==='true'){
				pcname.value = '';
				getpcategory();
			}			
		}		
	})	
}

// 카테고리 출력 함수
getpcategory();
function getpcategory(){
	let pcategorybox = document.querySelector('.pcategorybox')
	$.ajax({
		url : '/jspWeb/admin/addcategory',
		success : (result)=>{
			let datalist = JSON.parse(result);
			let html = '';
			for(let i = 0 ; i<datalist.length ; i++){
				html += `<input type="radio" name="pcno" value="${datalist[i].pcno}">${datalist[i].pcname}`;
			}
			pcategorybox.innerHTML = html;
		}
	})
}
