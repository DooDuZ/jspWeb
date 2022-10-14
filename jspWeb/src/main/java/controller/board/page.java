package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.dao.WriteDao;
import model.dto.writeDto;

@WebServlet("/board/page")
public class page extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public page() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = (Integer)request.getSession().getAttribute("bno");
		String mid = (String) request.getSession().getAttribute("mid");
		writeDto dto = WriteDao.getInstance().getContent(bno);
		
		JSONObject object = new JSONObject();
		object.put("mid", mid);
		object.put("bNo", bno);
		object.put("btitle", dto.getBtitle());
		object.put("bcontent", dto.getBcontent());
		object.put("bfile", dto.getBfile());
		
		if( mid!=null && mid.equals(dto.getMid())) {
			object.put("checkUser", true);
		}else {
			object.put("checkUser", false);
		}
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(object);
	}
}
