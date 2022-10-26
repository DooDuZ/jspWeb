/**
 * 
 */
 
 let nations = [ {n_no : 1,	n_name : 't1', n_price : 1000000 }, 
 				{n_no : 2,n_name : 't2',n_price : 1000000}, 
 				{n_no : 3,n_name : 't3',n_price : 1000000}, 
 				{n_no : 4,n_name : 't4',n_price : 1000000}, 
 				{n_no : 5,n_name : 't5',n_price : 1000000},
 				{n_no : 6,n_name : 't6',n_price : 1000000},
 				{n_no : 7,n_name : 't7',n_price : 1000000},
 				{n_no : 8,n_name : 't8',n_price : 1000000},
 				{n_no : 9,n_name : 't9',n_price : 1000000},
 				{n_no : 10,n_name : 't10',n_price : 1000000},
 				{n_no : 11,n_name : 't11',n_price : 1000000},
 				{n_no : 12,n_name : 't12',n_price : 1000000},
 				{n_no : 13,n_name : 't13',n_price : 1000000},
 				{n_no : 14,n_name : 't14',n_price : 1000000},
 				{n_no : 15,n_name : 't15',n_price : 1000000},
 				{n_no : 16,n_name : 't16',n_price : 1000000},
 				{n_no : 17,n_name : 't17',n_price : 1000000},
 				{n_no : 18,n_name : 't18',n_price : 1000000},
 				{n_no : 19,n_name : 't19',n_price : 1000000},
 				{n_no : 20,n_name : 't20',n_price : 1000000},
 				{n_no : 21,n_name : 't21',n_price : 1000000},
 				{n_no : 22,n_name : 't22',n_price : 1000000},
 				{n_no : 23,n_name : 't23',n_price : 1000000},
 				{n_no : 24,n_name : 't24',n_price : 1000000},
 				{n_no : 25,n_name : 't25',n_price : 1000000},
 				{n_no : 26,n_name : 't26',n_price : 1000000},
 				{n_no : 27,n_name : 't27',n_price : 1000000},
 				{n_no : 28,n_name : 't28',n_price : 1000000},
 				{n_no : 29,n_name : 't29',n_price : 1000000},
 				{n_no : 30,n_name : 't30',n_price : 1000000},
 				{n_no : 31,n_name : 't31',n_price : 1000000},
 				{n_no : 32,n_name : 't32',n_price : 1000000} ]

 function printboard(){
	let boardDisplay = document.getElementById('boardDisplay')
	let board = '';
	
	for(let i = 0 ; i<9 ; i++){
		let cols = '<tr>';
		for(let j = 0 ; j<9 ; j++){
			if(i==0){
				cols += `<td id="${j+1}">${nations[j].n_name}</td>`;
			}else if(i==8){
				cols += `<td id="${25-j}">${nations[24-j].n_name}</td>`;
			}else if(j==0){
				cols += `<td id="${32-j}">${nations[31-j].n_name}</td>`
			}else if(j==8){
				cols += `<td id="${j+9}">${nations[j+8].n_name}</td>`
			}		
			if(j==8){
				cols += `</tr>`;
			}
			board += cols;			
		}
	}
	boardDisplay.innerHTML = board;	
}
printboard();