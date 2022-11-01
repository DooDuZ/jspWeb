package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dao.ProductDao;
import model.dto.StockDto;


@WebServlet("/admin/stock")
public class stock extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public stock() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    // 재고 출력 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt(request.getParameter("pno"));
		System.out.println(pno);
		ArrayList<StockDto> list = new ProductDao().getstock(pno);
		
		JSONArray array = new JSONArray();
		
		for( StockDto dto : list) {
			JSONObject object = new JSONObject();
			object.put("psno", dto.getPsno());
			object.put("psize", dto.getPsize());
			object.put("pstno", dto.getPstno());
			object.put("pcolor", dto.getPcolor());
			object.put("pstock", dto.getPstock());
			array.add(object);
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
	}
	
	// 재고 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String psize = request.getParameter("psize");
		int pno = Integer.parseInt(request.getParameter("pno"));
		System.out.println(pno);
		String pcolor = request.getParameter("pcolor");
		int pstock = Integer.parseInt(request.getParameter("pstock"));
		
		boolean result = new ProductDao().setstock(psize, pno, pcolor, pstock);
		response.getWriter().print(result);
	}
}
