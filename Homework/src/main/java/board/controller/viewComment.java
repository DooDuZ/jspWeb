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
import board.model.dto.commentDto;


@WebServlet("/board/viewComment")
public class viewComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public viewComment() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bNo = Integer.parseInt(request.getParameter("cNo"));
		ArrayList<commentDto> list = BoardDao.getInstance().viewComment(bNo);
		
		JSONArray array = new JSONArray();
		
		for(int i = 0 ; i<list.size() ; i++) {
			JSONObject object = new JSONObject();
			object.put("cNo", list.get(i).getcNo());
			object.put("cWriter", list.get(i).getcWriter());
			object.put("cContent", list.get(i).getcContent());
			object.put("cDate", list.get(i).getcDate());
			object.put("bNo", list.get(i).getbNo());
			array.add(object);
		}
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
