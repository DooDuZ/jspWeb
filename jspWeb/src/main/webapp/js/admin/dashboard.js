/**
 * 
 */

let sidebar = document.querySelector('.sidebar')
let mainbox = document.querySelector('#mainbox')

 let check = false;
 function displayMenu(){
	check = !check;
	if(check){
		sidebar.style.left = 0;
	}
	/*
	else{
		sidebar.style.left = '-150px';
	}
	*/
}

mainbox.addEventListener('click', ()=>{
	sidebar.style.left = '-150px';
})


function pagechange(page){
	$('#mainbox').load(page);
}