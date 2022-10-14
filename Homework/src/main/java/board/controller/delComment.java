package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.dao.BoardDao;


@WebServlet("/board/delComment")
public class delComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public delComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int cNo = Integer.parseInt(request.getParameter("cNo"));
		String cPassword = request.getParameter("cPassword");
		
		boolean result = BoardDao.getInstance().delCommonet(cNo, cPassword);
		
		response.getWriter().print(result);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
