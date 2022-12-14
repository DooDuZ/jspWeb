package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.parser.*;

import model.dao.MemberDao;
import model.dao.ProductDao;
import model.dto.CartDto;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/product/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("mid"));
		
		ArrayList<CartDto> list = new ProductDao().getCart(mno);
		JSONArray array = new JSONArray();
		for(int i = 0 ; i<list.size() ; i++) {
			JSONObject object = new JSONObject();
			object.put("cartNo", list.get(i).getCartNo());
			object.put("pstno", list.get(i).getPstno());
			object.put("pname", list.get(i).getPname());
			object.put("pimg", list.get(i).getPimg());
			object.put("pprice", list.get(i).getPprice());
			object.put("pdiscount", list.get(i).getPdiscount());
			object.put("pcolor", list.get(i).getPcolor());
			object.put("psize", list.get(i).getPsize());
			object.put("amount", list.get(i).getAmount());			
			array.add(object);
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int pno = Integer.parseInt(request.getParameter("pno"));
		int mno = (Integer) MemberDao.getInstance().getMno((String)request.getSession().getAttribute("mid"));
		String data = request.getParameter("data");
		try {
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(data);			
			for(int i = 0 ; i<array.size();i++) {
				JSONObject object = (JSONObject) array.get(i);
				String psize = (String)object.get("psize");

				int amount = Integer.parseInt(String.valueOf(object.get("amount")));
				// JSONParse ??? ?????? = ?????????, ?????? = Long ???????????? ?????????
					// LONG??? String??? ?????????????????? ?????? -> ??????????????? ?????? -> valueOf ??????
				String pcolor = (String)object.get("pcolor");
				
				boolean result = new ProductDao().setcart(pno, psize, amount, pcolor, mno);
				if(result == false) {
					response.getWriter().print(result);
					return;
				}
			}			
		} catch (Exception e) {
			System.out.println("JSON ?????? ??????" + e);
		}		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(true);
	}

}
