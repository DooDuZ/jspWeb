/**
 * 
 */ 

//지도 객체 생성
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
mapOption = {
    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
};  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

let datalist = null; // 전역 변수로 사용

function getdata(){	
	$.ajax({
		url : '/jspWeb/board/api',
		data : {},
		success : (result) => {
			let json = JSON.parse(result);
			datalist = json.data;
			dataprint();
		}
	})
}
getdata();
function mapview( i ){	
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	geocoder.addressSearch(datalist[i].주소, function(result, status) {
  		 // 정상적으로 검색이 완료됐으면 
	     if (status === kakao.maps.services.Status.OK) {
			//검색된 좌표 객체 생성
			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });
	        
	        kakao.maps.event.addListener(marker, 'click', ()=>{
				detailview(i);
			})
	        
	        
	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new kakao.maps.InfoWindow({
	            content: `<div style="width:150px;text-align:center;padding:6px 0;">${datalist[i].약국명}</div>`
	        });
	        infowindow.open(map, marker);
	        
	        
	
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);    
	    }
	});
}


function addrsearch(){
	let addr = document.querySelector('.addrinput').value;
	dataprint( addr );
}


function dataprint( addr ){	
	let html = '';
	if(addr !== undefined){
		let searchlist = [];
		for(let i = 0 ; i<datalist.length ; i++){
			let addrdata = datalist[i].주소; 
			
			if(addrdata.indexOf(addr)!=-1){
				searchlist.push(datalist[i]);
			}
		}
		datalist = searchlist;
	}
	for(let i = 0 ; i<datalist.length ; i++){
		let data = datalist[i];	
		html += `<tr onclick="mapview(${i})"><td>${data.약국명}</td><td>${data.대표전화}</td><td>${data.주소}</td></tr>`;
	}	
	document.querySelector('.table').innerHTML = html;
}


function detailview(i){
	let detailbox = document.querySelector('.detailbox');
	let html = `<div>${datalist[i].약국명}</div>
				<div>${datalist[i].주소}</div>
				<div>${datalist[i].대표전화}</div>
				<button>평점주기</button>
				<button>문의하기</button>`
	detailbox.innerHTML = html;	
}

function dealView(){
	let deallist = document.querySelector('.apart');	
	$.ajax({
		url : '/jspWeb/board/dealview',
		success : (result)=>{
			let adatalist = JSON.parse(result);
			console.log(adatalist);
			let html = `<tr><th>시군구</th><th>주소</th><th>단지명</th>
						<th>면적</th><th>계약일</th><th>거래금액</th>
						<th>층</th><th>건축년도</th><th>도로명</th>
						<th>해제발생일</th><th>거래유형</th><th>중개사소재지</th></tr>`;
			for(let i = 0 ; i< adatalist.length; i++){
				html += `<tr>
						<td>${adatalist[i].시군구}</td>
						<td>${adatalist[i].번지본번부번}</td>
						<td>${adatalist[i].단지명}</td>
						<td>${adatalist[i].면적}</td>
						<td>${adatalist[i].계약년월일}</td>
						<td>${adatalist[i].거래금액}</td>
						<td>${adatalist[i].층}</td>
						<td>${adatalist[i].건축년도}</td>
						<td>${adatalist[i].도로명}</td>
						<td>${adatalist[i].해제사유발생일}</td>
						<td>${adatalist[i].거래유형}</td>
						<td>${adatalist[i].중개사소재지}</td>
						</tr>`
			}
			deallist.innerHTML = html;
		}
	})	
}
dealView();



