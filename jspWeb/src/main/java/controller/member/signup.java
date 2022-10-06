package controller.member;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dto.MemberDto;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public signup() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Scanner input = new Scanner(System.in);
		/*
			[입력부] HTML로 변경
			System.out.println("ID : ");	// console 출력 함수
			String ID = input.next();
			System.out.println("PW : ");
			String PW = input.next();
			System.out.println("Name : ");
			String Name = input.next();
			System.out.println("Phone : ");
			String Phone = input.next();
		*/
		
		// ** 전송받은 변수를 요청하기
		String ID = request.getParameter("id");
		String PW = request.getParameter("pw");
		String Name = request.getParameter("name");
		String Phone = request.getParameter("phone");
		
			// 입력받은 변수 4개 DAO로 이동 [ 변수 4개 vs dto1개 vs 컬렉션프레임워크 vs JSON ]
		MemberDto dto = new MemberDto(ID, PW, Name, Phone);
			// 2. 테스트
		System.out.println(dto.toString());
			// 3. Dao
		boolean result = MemberDao.getInstance().signup(dto);
		if(result) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
