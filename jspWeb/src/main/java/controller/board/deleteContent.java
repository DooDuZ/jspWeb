package controller.board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.WriteDao;
import model.dto.writeDto;

/**
 * Servlet implementation class checkuser
 */
@WebServlet("/board/deleteContent")
public class deleteContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deleteContent() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		int bno = Integer.parseInt(request.getParameter("bno"));
		writeDto dto = WriteDao.getInstance().getContent(bno);
		// DB 데이터 처리
		boolean result = WriteDao.getInstance().deleteContent(bno);
		if(result) {
			File file = new File(request.getSession().getServletContext().getRealPath("/upload/"+dto.getBfile()));
			if(file.exists()) {
				file.delete();
			}
		}
		response.getWriter().print(result);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
