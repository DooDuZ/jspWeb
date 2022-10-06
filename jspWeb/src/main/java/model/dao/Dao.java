package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	// 서블렛에는 반드시 필요함
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jspweb",
					"root", 
					"1234");
			System.out.println("DB연동 성공");
		} catch (Exception e) {
			System.out.println("DB연결 오류" + e);
		}
	}
}


/*
 	필요한 서버
 		1. 웹서버  [아파치 톰캣9]		포트 : 8080
 		2. DB서버 [ MYSQL ]		포트 : 3306
 			* 포트확인 : CMD -> netstat -ano
 			* IP : 내 PC 식별번호						[PC로 접근하는 식별 번호]
 			* 포트 : 내PC의 프로그램[프로세스]접근 번호		[프로그램에 접근하는 식별 번호]
 			
 	
 	
 	[자바 설치]
 	
 	
	서버 설치 [ 아파치 톰캣 ]
	
	1. 32-bit/64-bit Windows Service Installer
	2. 포트번호 확인
	3. 자바[JRE폴더]가 설치된 위치 설정
	* 확인 : 윈도우 시작표시줄 우측에 톰캣 아이콘 확인
			- startup type : disabled
			- service status : stop -> 켜놓은 상태로 두면 컴퓨터 느려짐
			- 톰캣 아이콘 우클릭 -> exit
			- 윈도우 검색 -> service 꺼졌는지 확인

	Server [ 이클립스 ]
		1. 서버 타입 : 아파치 톰캣9.0
		2. 서버에 프로젝트 오른쪽 add
		3. 톰캣 포트 설정 : 8081
	
	
	Dynamic Web Project
	
		1. 프로젝트 build path [라이브러리 설정]		: 개발에 필요한 라이브러리
			1. javaSe-1.8
			2. 아파치


*/