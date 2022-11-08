package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import model.dao.MemberDao;
import model.dao.ProductDao;
import model.dto.OrderDto;

@WebServlet("/product/order")
public class order extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public order() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test");
		request.setCharacterEncoding("UTF-8");
		String checkPlist = request.getParameter("data");
		String oinfo = request.getParameter("oinfo");
		int mno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("mid")); 
		
		System.out.println(checkPlist);
		System.out.println(oinfo);		
		try {
			JSONParser parser = new JSONParser();
			JSONObject object = (JSONObject) parser.parse(oinfo);
			JSONArray array = (JSONArray) parser.parse(checkPlist);
			
			ArrayList<OrderDto> list = new ArrayList<>();
			
			for(int i = 0 ; i<array.size(); i++) {
				JSONObject orderObj = (JSONObject) array.get(i);
				//받는 사람 정보
				String oname = String.valueOf(object.get("oname"));
				String ophone = String.valueOf(object.get("ophone"));
				String oaddress = String.valueOf(object.get("oaddress"));
				String oquest = String.valueOf(object.get("oquest"));
				
				//주문 상세 정보
				int odamount = Integer.parseInt(String.valueOf(orderObj.get("amount")));
				int pprice = Integer.parseInt(String.valueOf(orderObj.get("pprice")));
				float pdiscount = Float.parseFloat(String.valueOf(orderObj.get("pdiscount")));
				int pstno = Integer.parseInt(String.valueOf(orderObj.get("pstno")));
				int odprice = (int) (pprice * (1-pdiscount));
				
				//주문 dto 생성
				OrderDto dto = new OrderDto(0, oname, ophone, oaddress, oquest, null, mno, 0, odamount, odprice, 0, pstno);
				list.add(dto);
			}
			boolean result = new ProductDao().setOrder(list);
			response.getWriter().print(result);
			return;
		} catch (Exception e) {
			System.out.println("jsonparser 오류"+e);
		}
	}
}
