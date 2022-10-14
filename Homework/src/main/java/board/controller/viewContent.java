package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import board.model.dao.BoardDao;
import board.model.dto.contentDto;


@WebServlet("/board/viewContent")
public class viewContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public viewContent() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cNos = request.getParameter("cNo");
		int cNo = Integer.parseInt(cNos);
		
		contentDto dto = BoardDao.getInstance().getContent(cNo);		
		
		JSONObject object = new JSONObject();
		object.put("title", dto.getTitle());
		object.put("content", dto.getContent());
		
		response.setCharacterEncoding("UTF-8");		 		
		response.getWriter().print(object);			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
