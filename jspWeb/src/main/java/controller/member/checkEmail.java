package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;

/**
 * Servlet implementation class checkEmail
 */
@WebServlet("/member/checkEmail")
public class checkEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public checkEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memail = request.getParameter("memail");
		boolean result = MemberDao.getInstance().checkEmail(memail);
		
		response.getWriter().print(result);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
