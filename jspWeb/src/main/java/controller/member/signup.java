package controller.member;

import java.io.IOException;

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
@WebServlet("/member/signup") // 실질적인 mapping URL 설정
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public signup() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
			[입력부] HTML로 변경
			Scanner input = new Scanner(System.in);
		
			
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
		String ID = request.getParameter("mid");
		String PW = request.getParameter("mpw");
		String PWs = request.getParameter("mpws");
		String Name = request.getParameter("mname");
		String Phone = request.getParameter("mphone");
		String Email = request.getParameter("memail");
		
		// 분할 주소
		String adress1 = request.getParameter("address1");
		String adress2 = request.getParameter("address2");
		String adress3 = request.getParameter("address3");
		String adress4 = request.getParameter("address4");
		
		String Adress = adress1 +","+ adress2 + "," + adress3 +"," + adress4;
		
			// 입력받은 변수 4개 DAO로 이동 [ 변수 4개 vs dto1개 vs 컬렉션프레임워크 vs JSON ]
		MemberDto dto = new MemberDto(ID, PW, Name, Phone, Email, Adress);
			// 3. Dao
		boolean result ;
		if(PW.equals(PWs)) {
			result = MemberDao.getInstance().signup(dto);
		}else {
			result = false;
		}		
		if(result) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String ID = request.getParameter("mid");
		String PW = request.getParameter("mpw");
		String PWs = request.getParameter("mpws");
		String Name = request.getParameter("mname");
		String Phone = request.getParameter("mphone");
		String Email = request.getParameter("memail");
		
		// 분할 주소
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String address3 = request.getParameter("address3");
		String address4 = request.getParameter("address4");
		String Address = address1 +","+ address2 + "," + address3 +"," + address4;
		MemberDto dto = new MemberDto(ID, PW, Name, Phone, Email, Address);
		
		boolean result = MemberDao.getInstance().signup(dto);
		if(result) {
			System.out.println("회원가입 성공");
			// response.sendRedirect("URL") --> 페이지 응답
			response.sendRedirect("http://localhost:8080/jspWeb/member/login.jsp"); 
		}else {
			System.out.println("회원가입 실패");
		}
	}
}
