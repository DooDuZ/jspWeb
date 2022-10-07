



 
 function findID(){
	let mname = document.querySelector('#mname').value;
	let mmail = document.querySelector('#mmail').value;
	let findIDconfirmbox = document.querySelector('#findIDconfirmbox');
	
	$.ajax({
		url : '/jspWeb/member/findID' ,
		data : {'mname' : mname, 'mmail' : mmail },
		success : (re) => {
			if(re!==null){
				alert("ID는" + re + " 입니다.");
			}else{
				alert("ID찾기 실패");
			}
		}		
	})
}