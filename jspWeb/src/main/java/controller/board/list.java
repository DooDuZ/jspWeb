package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dao.WriteDao;
import model.dto.writeDto;

/**
 * Servlet implementation class list
 */
@WebServlet("/board/list")
public class list extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public list() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<writeDto> list = WriteDao.getInstance().getlist();
		
		JSONArray array = new JSONArray();
		
		for(int i = 0 ; i<list.size() ; i++) {
			JSONObject object = new JSONObject();
			object.put("bno", list.get(i).getBno());
			object.put("btitle", list.get(i).getBtitle());
			object.put("bdate", list.get(i).getBdate());
			object.put("bview", list.get(i).getBview());
			object.put("mno", list.get(i).getMno());
			
			array.add(object);
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);		
	}
}
