package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.dao.BoardDao;

@WebServlet("/board/addComment")
public class addComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public addComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comWriter = request.getParameter("comWriter");
		String comPw = request.getParameter("comPw");
		String comText = request.getParameter("comText");
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		
		boolean result = BoardDao.getInstance().addComment(comWriter,comPw,comText,bNo);
		
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
