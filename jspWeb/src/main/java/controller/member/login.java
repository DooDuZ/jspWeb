package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;


@WebServlet("/member/logIn")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public login() {
        super();        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ID = request.getParameter("ID");
		String PW = request.getParameter("PW");
		System.out.println("뭔데");
		boolean result = MemberDao.getInstance().login(ID, PW);
		System.out.println(result);
		if(result) {
			System.out.println("로그인 성공");
			response.sendRedirect("http://localhost:8080/jspWeb/index.jsp");
		}else {
			System.out.println("로그인 실패");
			response.sendRedirect("hhttp://localhost:8080/jspWeb/member/login.jsp");
		}
	}

}
