package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;


@WebServlet("/member/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public login() {
        super();        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ------------------- ajax --------------------- //
		String mid = request.getParameter("mid");
		String mpassword = request.getParameter("mpassword");
		
		int result = MemberDao.getInstance().login(mid, mpassword);
		response.getWriter().print(result);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//form 에서 사용
		
		/*
		 * String ID = request.getParameter("mid"); String PW =
		 * request.getParameter("mpassword"); boolean result =
		 * MemberDao.getInstance().login(ID, PW); if(result) {
		 * System.out.println("로그인 성공");
		 * response.sendRedirect("http://localhost:8080/jspWeb/index.jsp"); }else {
		 * System.out.println("로그인 실패");
		 * response.sendRedirect("http://localhost:8080/jspWeb/member/login.jsp"); }
		 */
	}

}
