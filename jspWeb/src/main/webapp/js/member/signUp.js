//유효성 검사

/* 
	[정규표현식]
	
	/^ : 정규표현식 시작
	$/ : 정규표현식 끝
	[a-z] : 소문자 패턴
	[A-Z] : 대문자 패턴
	[0-9] : 숫자 패턴
	{최소길이, 최대길이} : 문자열 길이 패턴
	
	검사 : 정규표현식.test(데이터)  ---> true false 반환
	
*/

let col = document.querySelectorAll('.col3');

//아이콘
let sicon = '<i class="fas fa-check-circle"></i>';
let bicon = '<i class="fas fa-ban"></i>';


//아이디
function midEvent(){
	let mid = document.querySelector('#mid').value;
	let midj = /^[a-z0-9]{5,20}$/;
	if(midj.test(mid)){
		$.ajax({
			url : '/jspWeb/member/idcheck',
			data : {"mid" : mid},
			success : (result)=>{
				if(result==='true'){
					col[0].innerHTML = sicon;
				}else if(result==='false'){
					col[0].getElementById('midtd').innerHTML = bicon + '이미 사용중인 ID입니다.';
				}
			}		
		})
	}else{
		document.getElementById('midtd').innerHTML = bicon+'알파벳 소문자/숫자를 사용하여 5-20자 사이로 입력해주세요.';
	}
}


//비밀번호
function mpwEvent(){
	let mpw = document.querySelector('#mpw').value;
	let mpwj = /^[a-zA-z0-9]{10,20}$/;
	if(mpwj.test(mpw)){
		col[1].innerHTML = sicon;
		mpwsEvent();
	}else{
		col[1].innerHTML = bicon+'알파벳 대/소문자, 숫자를 포함한 10-20자 사이로 입력해주세요.';
	}	
}

//비밀번호 확인
function mpwsEvent(){
	let mpw = document.querySelector('#mpw').value;
	let mpws = document.querySelector('#mpws').value;
	if(mpw==mpws){
		col[2].innerHTML = sicon;
	}else{
		col[2].innerHTML = bicon + '비밀번호 불일치';
	}
}
//이름
function mnameEvent(){
	let mname = document.querySelector('#mname').value;
	let mnamej = /^[가-힣]{2,10}$/;
	if(mnamej.test(mname)){
		col[3].innerHTML = sicon;
	}else{
		col[3].innerHTML = bicon;
	}
}
//전화번호
function mphoneEvent(){
	let mphone = document.querySelector('#mphone').value;
	let mphonej = /^([0-9]{2,3})-([0-9]{3,4})-([0-9]{4})$/;
	if(mphonej.test(mphone)){
		col[4].innerHTML = sicon;
	}else{
		col[4].innerHTML = bicon + 'xxx-xxxx-xxxx 형식이 아닙니다.';
	}
}
//이메일
function memailEvent(){
	let memail = document.querySelector('#memail').value;
	let memailj = /^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-]+$/;
	
	if(memailj.test(memail)){
		$.ajax({
			url : '/jspWeb/member/checkEmail',
			data : {'memail' : memail},
			success : (result) => {
				if(result==='true'){
					col[5].innerHTML = sicon;
				}else{
					col[5].innerHTML = bicon + '이미 가입된 email입니다.';
				}
			}			
		})		
		
	}else{
		col[5].innerHTML = bicon + '이메일 형식이 아닙니다.';
	}
}
//주소
let postcode = document.querySelector('#sample4_postcode');
let roadAddress = document.querySelector('#sample4_roadAddress');
let jibunAddress = document.querySelector('#sample4_jibunAddress');
let detailAddress = document.querySelector('#sample4_detailAddress');

function adresscheck(e){
	let value = e.target.value;
	if(value.indexOf(',')!=-1){
		col[6].innerHTML = bicon + '주소에 , 입력 불가능';
	}else{
		col[6].innerHTML = sicon;
	}
}

postcode.addEventListener('change', adresscheck);
roadAddress.addEventListener('change', adresscheck);
jibunAddress.addEventListener('change', adresscheck);
detailAddress.addEventListener('change', adresscheck);

//회원가입 전송 확인
function formsubmit(){
	// 아이디~주소 유효성검사 결과 검토
	
	for(let i = 0 ; i<=6 ; i++){
		if(col[i].innerHTML !== sicon){
			alert('정보 재입력 필요');
			return false;
		}
	}	
	// 이용약관 체크박스 검토
	if(!document.querySelector('#confirm1').checked){
		alert('이용약관 동의 필요');
		return false;
	}else if(!document.querySelector('#confirm2').checked){
		alert('개인정보 수집 동의 필요');
		return false;
	}
	document.querySelector('.signupForm').submit();
}





   
   
   //카카오 우편 api
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
    // 카카오 우편 api end
    
    
    