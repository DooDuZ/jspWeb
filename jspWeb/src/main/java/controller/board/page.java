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
		String no = request.getParameter("bno");
		int bno = Integer.parseInt(no);
		System.out.println(bno);
		writeDto dto = WriteDao.getInstance().getContent(bno);
		
		System.out.println(dto.getBtitle());
		System.out.println(dto.getBcontent());
		
		JSONObject object = new JSONObject();
		object.put("btitle", dto.getBtitle());
		object.put("bcontent", dto.getBcontent());
		
		response.setCharacterEncoding("UTF-8");
		response.sendRedirect("/jspWeb/board/page.jsp");
		response.getWriter().print(object);
	}
}
