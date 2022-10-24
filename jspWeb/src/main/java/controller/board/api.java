package controller.board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/api")
public class api extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public api() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		URL url = new URL("https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?page=1&perPage=292&serviceKey=jov7qLvdT9iNBBBCCpKgmHdMzIHOtO9jVXODRlh%2FvjKA6wk%2BVRjl%2B3hFHQrdAJvVRUu7YhbU2ZJn%2FD63981rSw%3D%3D");
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		String result = br.readLine();
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
