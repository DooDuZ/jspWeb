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
import model.dto.PcategoryDto;

@WebServlet("/admin/addcategory")
public class addcategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public addcategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<PcategoryDto> list = new ProductDao().getpcategory();
		JSONArray array = new JSONArray();
		for(int i = 0 ; i<list.size(); i++) {
			JSONObject object = new JSONObject();
			object.put("pcname", list.get(i).getPcname());
			array.add(object);
		}		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pcname = request.getParameter("pcname");
		
		boolean result = new ProductDao().setpcategory(pcname);
		
		response.getWriter().print(result);
	}

}
