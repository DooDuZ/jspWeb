package controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;

@WebServlet("/member/findPW")
public class findPW extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public findPW() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		String memail = request.getParameter("memail");
		
		boolean result = MemberDao.getInstance().findPW(mid, memail);
		String randstr = "";
		if(result) {
			Random rand = new Random();
			for(int i = 0 ; i<15 ; i++) {
				randstr += (char) (rand.nextInt(26) + 97);				
			}
			response.getWriter().print(randstr);
		}else {
			response.getWriter().print("");
		}		
		MemberDao.getInstance().updatePW(mid , randstr);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
