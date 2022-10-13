package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.WriteDao;

@WebServlet("/board/write")
public class write extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public write() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bwriter = (String) request.getSession().getAttribute("mid");
		
		boolean result = WriteDao.getInstance().addContent(btitle, bcontent, bwriter);
		
		response.getWriter().print(result);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bwriter = (String) request.getSession().getAttribute("mid");
		
		boolean result = WriteDao.getInstance().addContent(btitle, bcontent, bwriter);
		
		if(result) {
			response.sendRedirect("http://localhost:8080/jspWeb/index.jsp");
		}else {
			response.sendRedirect("http://localhost:8080/jspWeb/member/login.jsp");
		}
	}

}
