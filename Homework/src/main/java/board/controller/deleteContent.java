package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.dao.BoardDao;

/**
 * Servlet implementation class deleteContent
 */
@WebServlet("/board/deleteContent")
public class deleteContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deleteContent() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String scNo = request.getParameter("cNo");
		String password = request.getParameter("password");
		int cNo = Integer.parseInt(scNo);		
		
		boolean result = BoardDao.getInstance().deleteContent(cNo, password);
		
		response.getWriter().print(result);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
