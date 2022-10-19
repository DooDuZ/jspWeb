package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import model.dao.WriteDao;

/**
 * Servlet implementation class rlist
 */
@WebServlet("/reply/rlist")
public class rlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public rlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = (Integer) request.getSession().getAttribute("bno");
		int type = Integer.parseInt(request.getParameter("type"));
		JSONArray array;
		if(type==0) {
			array = WriteDao.getInstance().getrlist(bno);
		}else {
			int rno = Integer.parseInt(request.getParameter("rno"));
			array = WriteDao.getInstance().getrlist(bno, rno);
		}		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
