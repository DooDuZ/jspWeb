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

@WebServlet("/board/list")
public class list extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public list() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String key = request.getParameter("key");
		String keyword = request.getParameter("keyword");
		
		
		int listsize = Integer.parseInt(request.getParameter("listsize"));
		
		// 전체 게시물 수
		int totalSize = WriteDao.getInstance().getTotalSize( key, keyword);
		// 페이지 수 저장
		int totalPage = totalSize/listsize;
		if(totalSize%listsize!=0) {
			totalPage++;
		}		
		
		//현재 페이지 수 
		int page = Integer.parseInt(request.getParameter("page"));
		
		int startRow = (page-1)*listsize;
		
		int btnsize = 5; // 버튼 5개씩 표시
		int startbtn = 5*(page/5)+1;
		int endbtn = startbtn+btnsize-1;
		
		if(endbtn > totalPage) {
			endbtn = totalPage;
		}
		
		ArrayList<writeDto> list = WriteDao.getInstance().getlist(startRow, listsize, key, keyword);
		
		
		
		
		JSONObject boards = new JSONObject();
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
		
		boards.put("totalPage", totalPage);
		boards.put("data", array);
		boards.put("startbtn", startbtn);
		boards.put("endbtn", endbtn);
		boards.put("totalsize", totalSize);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(boards);		
	}
}
