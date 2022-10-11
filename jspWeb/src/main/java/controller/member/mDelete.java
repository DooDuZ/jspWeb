package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;

/**
 * Servlet implementation class mDelete
 */
@WebServlet("/member/mDelete")
public class mDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public mDelete() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String mpassword = request.getParameter("mpassword");
		String mid = (String) request.getSession().getAttribute("mid");
		
		boolean result = MemberDao.getInstance().mDelete(mid, mpassword);
		
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
