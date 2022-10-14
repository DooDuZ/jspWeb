package controller.board;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/filedown")
public class filedown extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public filedown() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String bfile = request.getParameter("bfile");
		String uploadpath = "C:\\Users\\504\\git\\jspWeb\\jspWeb\\src\\main\\webapp\\upload\\"+bfile;
		// 해당 경로의 파일을 객체화
		File file = new File(uploadpath);
		
		// HTTP에서 지원하는 다운로드 메소드
		response.setHeader("Content-Disposition", "attatchment;filename=" + URLEncoder.encode(bfile, "UTF-8"));	

		// 파일 전송 [바이트] -> 데이터의 교환 = stream
			// 1. 파일의 내용물을 바이트로 모두 읽어온다.
		BufferedInputStream fi = new BufferedInputStream(new FileInputStream(file));
		
		byte[] bytes = new byte[(int)file.length()];
		fi.read(bytes);	

		BufferedOutputStream fout = new BufferedOutputStream(response.getOutputStream());
		fout.write(bytes);

		// 입출력 스트림 닫기
		fout.flush();		// 출력 스트림 버퍼 초기화
		fi.close();			// 입력 스트림 닫기
		fout.close();		// 출력스트림 닫기
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
