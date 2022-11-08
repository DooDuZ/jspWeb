/**
 * 
 */
 

function findPW(){
	let mid = document.querySelector('#mid').value;
	let memail = document.querySelector('#mmail').value;
	let findPWconfirmbox = document.querySelector('#findPWconfirmbox');
	
	$.ajax({
		url : '/jspWeb/member/findPW',
		data : {'mid' : mid, 'memail' : memail},
		success : (re)=>{
			if(re!==''){
				findPWconfirmbox.innerHTML = re ;
			}else{
				alert("비밀번호 찾기 실패");
			}			
		}
	})	 
}
 
 
 
