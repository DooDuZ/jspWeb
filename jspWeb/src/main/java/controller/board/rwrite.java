package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dao.WriteDao;

@WebServlet("/board/rwrite")
public class rwrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public rwrite() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int type = Integer.parseInt(request.getParameter("type"));
		String mid = (String) request.getSession().getAttribute("mid"); 
		String rcontent = (String) request.getParameter("rcontent");
		int mno = MemberDao.getInstance().getMno(mid);
		int bno = (Integer) request.getSession().getAttribute("bno");
		
		if(mno==0) {
			response.getWriter().print(0);
			return;
		}
		
		boolean result;
		if(type==0) {
			result = WriteDao.getInstance().rwrite(rcontent, mno, bno);
		}else {
			int rno = Integer.parseInt(request.getParameter("rno"));
			result = WriteDao.getInstance().rwrite(rcontent, mno, bno, rno);
		}
		
		if(result) {
			response.getWriter().print(1);
		}else {
			response.getWriter().print(2);
		}		
	}
}
