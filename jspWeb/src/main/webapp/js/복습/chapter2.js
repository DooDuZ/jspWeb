/**
 * 
 */
 
 console.log("어려운 문자열");
 
 let test = "어려운";
 let test2 = "문자열";
 
 console.log(test+test2);
 //ctrl + F5 슈퍼 새로고침!!!
 
 
 const pi = 3.141592;
 console.log(pi);
 // pi = 4;				--> 상수값을 변경하려 시도하기 때문에 에러 발생
 let pi2= 3.141592;
 console.log(pi2);
 pi2 = 4;
 console.log(Math.PI);
 
 
 /*
 	[형변환]
 	Number(data) : 숫자 반환
 	String(data) : 문자열 반환
 	boolean(data) : 불값 반환
 
 */
 
 // 문제1 : 지폐 세기
 
 let payment = Number(prompt("가격"));
 
 console.log( "십만원권 : " + Math.floor(payment/100000));			// math.floor 대신 pareInt(정수 변환) 가능
 console.log( "만원권 : " + Math.floor(payment/10000)%10);
 console.log( "천원권 : " + Math.floor(payment/1000)%10);
 console.log( "백원권 : " + Math.floor(payment/100)%10)
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 