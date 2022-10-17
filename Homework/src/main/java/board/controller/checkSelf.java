package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.dao.BoardDao;

@WebServlet("/board/checkSelf")
public class checkSelf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public checkSelf() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cNo = request.getParameter("cNo");
		
		
		boolean result = BoardDao.getInstance().checkSelf(Integer.parseInt(cNo));
		
		response.getWriter().print(result);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
