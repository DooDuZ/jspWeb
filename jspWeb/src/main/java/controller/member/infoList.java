package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dao.MemberDao;
import model.dto.MemberDto;


@WebServlet("/member/infoList")
public class infoList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public infoList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<MemberDto> list = MemberDao.getInstance().getInfoList();
		
		JSONArray array = new JSONArray();
		for(MemberDto dto : list) {
			JSONObject object = new JSONObject();
			object.put("mno", dto.getMno());
			object.put("mid", dto.getMid());
			object.put("mname", dto.getMname());
			object.put("mphone", dto.getMphone());
			object.put("memail", dto.getMemail());
			object.put("maddr", dto.getMaddr());
			object.put("mdate", dto.getMdate());
			object.put("mpoint", dto.getMpoint());
			array.add(object);
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
