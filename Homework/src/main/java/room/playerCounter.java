package room;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/*
import model.dao.RoomDao;
import model.dto.MemberDto;
*/


/**
 * Servlet implementation class room
 */

/*
@WebServlet("/room/playerCounter")
public class playerCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public playerCounter() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 방에 참여한 ID인지 체크용
		String m_id = (String) request.getSession().getAttribute("m_id");
		
		int result = RoomDao.getInstance().enterRoom(m_id);
		
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
*/