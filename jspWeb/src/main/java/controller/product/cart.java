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
		int mno = MemberDao.getInstance().getMno( (String) request.getSession().getAttribute("mid"));
		
		ArrayList<CartDto> list = new ProductDao().getCart(mno);
		
		JSONArray array = new JSONArray();
		
		for(CartDto dto : list) {
			JSONObject object = new JSONObject();
			object.put("cartno", dto.getCartNo());
			object.put("pstno", dto.getPstno());
			object.put("pname", dto.getPname());
			object.put("pimg", dto.getPimg());
			object.put("pprice", dto.getPprice());
			object.put("pdiscount", dto.getPdiscount());
			object.put("pcolor", dto.getPcolor());
			object.put("psize", dto.getPsize());
			object.put("amount", dto.getAmount());
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
				// JSONParse 시 문자 = 문자열, 숫자 = Long 타입으로 들어옴
					// LONG과 String은 슈퍼클래스가 다름 -> 강제형변환 불가 -> valueOf 사용
				String pcolor = (String)object.get("pcolor");				
				
				boolean result = new ProductDao().setcart(pno, psize, amount, pcolor, mno);
				System.out.println(result);
				if(result == false) {
					response.getWriter().print(result);
					return;
				}
				response.getWriter().print(result);
			}			
		} catch (Exception e) {
			System.out.println("JSON 파싱 오류" + e);
		}		
		response.setCharacterEncoding("UTF-8");
	}

}
