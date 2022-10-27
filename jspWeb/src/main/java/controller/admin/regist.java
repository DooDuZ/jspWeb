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
import model.dto.PcategoryDto;
import model.dto.ProductDto;

@WebServlet("/admin/regist")
public class regist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public regist() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int type = Integer.parseInt(request.getParameter("type"));
		
		response.setCharacterEncoding("UTF-8");
		
		if(type==1) {
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
			response.getWriter().print(array);	
		}else if(type==2) {
			int pno = Integer.parseInt(request.getParameter("pno"));
			ProductDto dto = new ProductDao().getProduct(pno);
			JSONObject object = new JSONObject();
			object.put("pno", dto.getPno());
			object.put("pname", dto.getPname());
			object.put("pcomment", dto.getPcomment());
			object.put("pprice", dto.getPprice());
			object.put("pdiscount", dto.getPdiscount());
			object.put("paction", dto.getPactive());
			object.put("pimg", dto.getPimg());
			object.put("pdate", dto.getPdate());
			object.put("pcno", dto.getPcno());
			
			response.getWriter().print(object);
		}
		
			
	}

	
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
		do / get 외에 다른 매서드 쓸 때
		
		server - > server.xml -> 하단 source 클릭 / 대략 60~70번째 줄 사이
		원본 : <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443"/>
		/ 앞에 
		parseBodyMethods="GET,POST,추가할 메서드1,추가할 메서드2..."
		추가 하면 사용 가능
	*/
	
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
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
		int pcno = Integer.parseInt(multi.getParameter("pcno"));					System.out.println(pcno);
		byte paction = Byte.parseByte(multi.getParameter("action"));				System.out.println(paction);
		String pimg = multi.getFilesystemName("pimg");								System.out.println(pimg);
		int pno = Integer.parseInt(multi.getParameter("pno"));						System.out.println(pno);
				
		ProductDto dto = new ProductDto(pno, pname, pcomment, pprice, pdiscount, paction, pimg, null, pcno);
		boolean result = new ProductDao().updateproduct(dto);
		
		response.getWriter().print(result);
	}
	
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		boolean result = new ProductDao().deleteproduct(pno);
		response.getWriter().print(result);
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
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
