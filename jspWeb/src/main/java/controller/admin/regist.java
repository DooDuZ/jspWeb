package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dto.ProductDto;

@WebServlet("/admin/regist")
public class regist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public regist() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		ProductDto dto = new ProductDto(0, pname, pcomment, pprice, pdiscount, (byte) 0, pimg, null, 0);
		System.out.println(dto);
	}
}
