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
			document.querySelector("#mdate").innerHTML = member.mdate;
			document.querySelector("#mpoint").innerHTML = member.mpoint;
			
			document.querySelector("#mid").value = member.mid;
			document.querySelector("#mname").value = member.mname;
			document.querySelector("#mphone").value = member.mphone;
			document.querySelector("#memail").value = member.memail;			
			
			document.querySelector("#sample4_postcode").value = member.maddr.split(',')[0];
			document.querySelector("#sample4_roadAddress").value = member.maddr.split(',')[1];
			document.querySelector("#sample4_jibunAddress").value = member.maddr.split(',')[2];
			document.querySelector("#sample4_detailAddress").value = member.maddr.split(',')[3];			
			// getMemberList(); 잠시 미사용
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


let buttons = document.querySelectorAll('button');

function updateAction(){
	let mname = document.querySelector('#mname');
	if(buttons[1].innerHTML === '확인'){
		$.ajax({
			url : '/jspWeb/member/update' ,
			data : {'mname' : mname.value} ,
			success : (result)=>{
				if(result==='true'){
					alert('수정 성공');
				}else{
					alert('수정 실패')
				}
			}			
		})
		buttons[1].innerHTML = '수정';
		mname.readOnly = true;
		location.reload;
	}else{
		mname.readOnly = false;
		alert('수정후 확인 버튼 클릭시 수정이 완료됩니다.');
		buttons[1].innerHTML = '확인';
	}
}























// 카카오 api

function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample4_postcode').value = data.zonecode;
            document.getElementById("sample4_roadAddress").value = roadAddr;
            document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
            
            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== ''){
                document.getElementById("sample4_extraAddress").value = extraRoadAddr;
            } else {
                document.getElementById("sample4_extraAddress").value = '';
            }

            var guideTextBox = document.getElementById("guide");
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                guideTextBox.style.display = 'block';

            } else if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
                guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                guideTextBox.style.display = 'block';
            } else {
                guideTextBox.innerHTML = '';
                guideTextBox.style.display = 'none';
            }
        }
    }).open();
}    