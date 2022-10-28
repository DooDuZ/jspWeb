/**
 * 
 */
 M_getplist();
function M_getplist(){
	$.ajax({
		url : "/jspWeb/admin/regist",
		data : {'type' : 1, "option" : "pactive1"},
		success : (result)=>{
			let json = JSON.parse(result);
			let html = '';
			json.forEach( p=> {
				let disprice = Math.round(p.pprice / 10 * (1-p.pdiscount) * 10);
				html += `<div class="item">
							<div class="item_imgbox">
								<a href="#">
									<img src="/jspWeb/admin/pimg/${p.pimg}">
								</a>
							</div>
							<div class="item_info">
								<div class="item_title"> ${p.pname} </div>
								<div class="item_size"> ${p.pcomment} </div>
								<div class="item_price"> ${p.pprice} </div>
								<div>
									<span class="item_sale"> ${disprice.toLocaleString()} </span>
									<span class="item_discount"> ${p.pdiscount*100}% </span>
								</div>
								<div class="item_review">리뷰수 412</div>
								<span class="badge rounded-pill text-bg-success"> 주문 폭주 </span>
								<span class="badge rounded-pill text-bg-success"> 1+1 </span>
							</div>
						</div>`				
			})
			
			document.querySelector('.itemlist').innerHTML = html;
			
		}	
	})
}
