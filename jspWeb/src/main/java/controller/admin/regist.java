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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.ProductDao;
import model.dto.ProductDto;

@WebServlet("/admin/regist")
public class regist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public regist() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<ProductDto> list = new ProductDao().getproductlist();
		JSONArray array = new JSONArray();
		for(int i = 0 ; i<list.size() ; i++) {
			JSONObject object = new JSONObject();
			object.put("pno", list.get(i).getPno());
			object.put("pname", list.get(i).getPname());
			object.put("pcomment", list.get(i).getPcomment());
			object.put("pprice", list.get(i).getPprice());
			object.put("pdiscount", list.get(i).getPdiscount());
			object.put("paction", list.get(i).getPactive());
			object.put("pimg", list.get(i).getPimg());
			object.put("pdate", list.get(i).getPdate());
			object.put("pcno", list.get(i).getPcno());
			array.add(object);
		}		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uploadpath = request.getSession().getServletContext().getRealPath("/admin/pimg");
		
		MultipartRequest multi = new MultipartRequest(request, 
									uploadpath,
									1024*1024*10,
									"UTF-8",
									new DefaultFileRenamePolicy());
		
		String pname = multi.getParameter("pname");									System.out.println(pname);
		String pcomment = multi.getParameter("pcomment");							System.out.println(pcomment);
		int pprice = Integer.parseInt(multi.getParameter("pprice"));				System.out.println(pprice);
		float pdiscount = Float.parseFloat(multi.getParameter("pdiscount"));		System.out.println(pdiscount);
		String pimg = multi.getFilesystemName("pimg");								System.out.println(pimg);
		int pcno = Integer.parseInt(multi.getParameter("pcno"));					System.out.println(pcno);
		
		ProductDto dto = new ProductDto(0, pname, pcomment, pprice, pdiscount, (byte) 0, pimg, null, pcno);
		boolean result = new ProductDao().setproduct(dto);
		
		response.getWriter().print(result);
		
	}
}
