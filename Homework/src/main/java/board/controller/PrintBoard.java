package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import board.model.dao.BoardDao;
import board.model.dto.contentDto;

/**
 * Servlet implementation class PrintBoard
 */
@WebServlet("/board/PrintBoard")
public class PrintBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PrintBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<contentDto> list = new ArrayList<>();
		list = BoardDao.getInstance().printBoard();
		
		JSONArray array = new JSONArray();
		
		for(contentDto dto : list) {
			JSONObject object = new JSONObject();
			object.put("cNo", dto.getcNo());
			object.put("Title", dto.getTitle());
			object.put("Writer", dto.getWriter());
			object.put("content", dto.getContent());
			object.put("Date", dto.getDate());
			object.put("view", dto.getView());
			array.add(object);
		}
		
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
