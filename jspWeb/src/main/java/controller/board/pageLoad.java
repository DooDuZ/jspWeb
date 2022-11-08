package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/board/pageLoad")
public class pageLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public pageLoad() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
			[Session 생명 주기]
			세션 호출 : request.getSession();
			세션 데이터 저장 : request.getSession().setAttribute("세션명", 데이터);
			세션 데이터 호출 : request.getSession().getAttribute("세션명");
			생명주기 : 
				1. reqeust.getSession.invalidate() : 모든 세션 초기화
				2. reqeust.getSession.invalidate() : 모든 세션 초기화
				3. reqeust.getSession.invalidate() : 모든 세션 초기화
				4. reqeust.getSession.invalidate() : 모든 세션 초기화
			
		*/		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("들오냐?");
		int bno = Integer.parseInt(request.getParameter("bno"));
		request.getSession().setAttribute("bno", bno);
		response.getWriter().print(true);
	}
}
