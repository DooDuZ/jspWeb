package controller.board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.WriteDao;


@WebServlet("/board/bupdate")
public class bupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public bupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bNo = (Integer) request.getSession().getAttribute("bno");
		
		// 서버 내 업로드 폴더 경로 찾기
		String uploadpath = request.getSession().getServletContext().getRealPath("/upload");
		// MultipartRequest 객체 생성
		MultipartRequest multi = new MultipartRequest(
				request,
				uploadpath,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy() );
		// 요청
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		
		System.out.println(btitle);
		System.out.println(bfile);
		
		String oldfile = WriteDao.getInstance().getContent(bNo).getBfile();
		
		
		boolean checkChange = true;
		if(bfile==null) {
			bfile = oldfile;
			checkChange = !checkChange;
		}
		
		boolean result = WriteDao.getInstance().bupdate(bNo, btitle, bcontent, bfile);
		if(result && checkChange) {
			String deletepath = request.getSession().getServletContext().getRealPath("/upload/" + oldfile);
			File file = new File(deletepath);
			if(file.exists()) {
				file.delete();
			}
		}
		System.out.println("test");
		
		response.getWriter().print(result);
	}

}
