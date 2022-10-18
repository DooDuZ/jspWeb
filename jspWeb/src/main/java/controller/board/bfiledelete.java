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

@WebServlet("/board/bfiledelete")
public class bfiledelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public bfiledelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = (Integer) request.getSession().getAttribute("bno");
		
		writeDto dto = WriteDao.getInstance().getContent(bno);
		
		boolean result = WriteDao.getInstance().bfiledelete(bno);
		if(result) {
			String deletepath = request.getSession().getServletContext().getRealPath("/upload/"+dto.getBfile());
			File file = new File(deletepath);
			if(file.exists()) {
				file.delete();
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
