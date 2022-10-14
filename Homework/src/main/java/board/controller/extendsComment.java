package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.dao.BoardDao;
import board.model.dto.commentDto;

/**
 * Servlet implementation class extendsComment
 */
@WebServlet("/board/extendsComment")
public class extendsComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public extendsComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cWriter = request.getParameter("cWriter");
		String cPassword = request.getParameter("cPassword");
		String cContent = request.getParameter("cContent");
		int cNo = Integer.parseInt(request.getParameter("cNo"));
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		
		commentDto dto = new commentDto();
		dto.setcNo(cNo);
		dto.setcWriter(cWriter);
		dto.setcPassword(cPassword);
		dto.setcContent(cContent);
		dto.setbNo(bNo);
		
		boolean result = BoardDao.getInstance().extendsComment(dto);
		
		response.getWriter().print(result);		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
