package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.dao.MemberDao;
import model.dto.MemberDto;


@WebServlet("/member/info")
public class info extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public info() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청
		String mid = (String) request.getSession().getAttribute("mid");
		// db
		MemberDto dto = MemberDao.getInstance().getInfo(mid);
		
		
		// JS는 DTO사용 불가
			// 1. js가 이해할 수 있는 형식 [JSON]
			// DTO - > JSON 변경 [ 외부 라이브러리 필요 ]
		JSONObject object = new JSONObject();
		
		object.put("mno", dto.getMno());
		object.put("mid", dto.getMid());
		object.put("mname", dto.getMname());
		object.put("mphone", dto.getMphone());
		object.put("memail", dto.getMemail());
		object.put("maddr", dto.getMaddr());
		object.put("mdate", dto.getMdate());
		object.put("mpoint", dto.getMpoint());
			
		response.setCharacterEncoding("UTF-8");
		// 응답		
		response.getWriter().print(object);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
