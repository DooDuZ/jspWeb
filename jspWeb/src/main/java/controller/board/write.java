package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.WriteDao;

@WebServlet("/board/write")
public class write extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public write() {
        super();
        // TODO Auto-generated constructor stub
    }

	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { String btitle =
	 * request.getParameter("btitle"); String bcontent =
	 * request.getParameter("bcontent"); String bwriter = (String)
	 * request.getSession().getAttribute("mid");
	 * 
	 * boolean result = WriteDao.getInstance().addContent(btitle, bcontent,
	 * bwriter);
	 * 
	 * response.getWriter().print(result);
	 * 
	 * }
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 첨부 위해서 cos라이브러리 필요
			// 1. cos.jar build 추가
			// 2. HttpServletRequest는 첨부파일을 지원하지 않음 [ 문자열만 지원 ] 
			// 3. MultipartRequest : 첨부파일 지원 [ 대용량의 문자 가능 ]
		//1. 저장 경로 [프로젝트 저장]
		String uploadpath = "C:\\Users\\504\\git\\jspWeb\\jspWeb\\src\\main\\webapp\\upload";
		
		// MultipartRequest생성자 (요청방식, 파일경로, 최대용량, 인코딩타입, (선택)보안기능) 
			// new DefaultFileRenamePolicy() -> 업로드된 파일의 이름이 중복일 경우 자동이름 변경
		MultipartRequest multi = new MultipartRequest(request, uploadpath, 1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
		String mid = (String) request.getSession().getAttribute("mid");
		String btitle = multi.getParameter("btitle");	// request -> multi
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");

		// db 처리
		boolean result = WriteDao.getInstance().addContent(btitle, bcontent, mid, bfile);
		
		response.getWriter().print(result);
	}

}
