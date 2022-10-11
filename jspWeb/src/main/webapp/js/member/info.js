/**
 * 
 */
 
 
/* 회원정보 호출 */
getMember();

function getMember(){
	$.ajax({
		url : "/jspWeb/member/info",
		data : "",
		success : (result)=>{
			// 통신된 json 형식의 문자 타입을 JSON타입으로 형 변환
			let member = JSON.parse(result);
			
			document.querySelector("#mno").innerHTML = member.mno;
			document.querySelector("#mid").innerHTML = member.mid;
			document.querySelector("#mname").innerHTML = member.mname;
			document.querySelector("#mphone").innerHTML = member.mphone;
			document.querySelector("#memail").innerHTML = member.memail;
			document.querySelector("#maddr").innerHTML = member.maddr;
			document.querySelector("#mdate").innerHTML = member.mdate;
			document.querySelector("#mpoint").innerHTML = member.mpoint;
			getMemberList();
		}	
	})
}

// 모든 회원 호출

function getMemberList(){	
	$.ajax({
		url : "/jspWeb/member/infoList",
		data : "",
		success : (result) => {
			let memberList = JSON.parse(result);
			let table = document.querySelector("#memberListTable");
			
			let output = '<tr><th>회원번호</th><th>id</th><th>이름</th><th>전화번호</th><th>이메일</th><th>주소</th><th>가입일</th><th>포인트</th></tr>';
			for(let i = 0 ; i<memberList.length ; i++){
				output += `<tr> <td>${memberList[i].mno}</td>
									<td>${memberList[i].mid}</td>
									<td>${memberList[i].mname}</td>
									<td>${memberList[i].mphone}</td>
									<td>${memberList[i].memail}</td>
									<td>${memberList[i].maddr}</td>
									<td>${memberList[i].mdate}</td>
									<td>${memberList[i].mpoint}</td>
									 </tr>`
			}
			table.innerHTML = output;		
		}
	})
}


function viewDelete(){
	let delbox = document.querySelector('#deletebox')
	let tag = `<span>!정말 탈퇴 하시겠습니까?</span><input type="password" id="mpassword"><button onclick='mDelete()'>확인</button>`;
	delbox.innerHTML = tag;
}

function mDelete(){
	let mpassword = document.getElementById('mpassword').value;
	$.ajax({
		url : "/jspWeb/member/mDelete" ,
		data : {"mpassword" : mpassword} ,
		success : (result)=>{
			if(result==='true'){
				alert('탈퇴 성공');
				location.href = '/jspWeb/member/logout.jsp';
			}else{
				alert('비밀번호 불일치');
			}
		}		
	})
}

