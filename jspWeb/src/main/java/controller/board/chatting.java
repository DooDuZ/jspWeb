package controller.board;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.json.simple.JSONObject;

import javax.websocket.*;

// @WebServlet("/board/chatting")
@ServerEndpoint("/chatting/{mid}")	// 웹 서버에 웹소켓 URL 만들기  URL/{변수명}
public class chatting{
	// 서버 소켓에 들어온 클라이언트 소켓 명단 저장
	public static Map<Session, String> clients = new Hashtable<>(); // 동기화 위해 ArrayList 대신 Vector 사용 -> hashtable로 변경

	public JSONObject jsonAlarm(String content) throws IOException{
		JSONObject object = new JSONObject();
		object.put("type", "alarm");
		object.put("content", content);
		return object;
	}
	public void sendmsg(JSONObject object) throws IOException {
		for(Session s : clients.keySet()) {	// Map.keyset()메서드 : 맵에 저장된 모든 key 빼오기
			s.getBasicRemote().sendText(object.toString());
		}
	}
	
	@OnOpen
	public void OnOpen( Session session, @PathParam("mid") String mid ) throws IOException { // @PathParam(경로상의 변수명) : 경로상의 변수 호출
		// Session -> js에서 생성된 웹소캣의 메모리 주소값
			// new 연산자를 통해 페이지가 열릴 때마다 생성되기 때문에, 들어올 때마다 주소값이 다르다.		
			// 그래서 @pathparam을 통해 주소에 변수로mid를 넘긴 후, @serverendpoint에 {}로 지정한 변수를 가져와서 식별값으로 hashtable에 저장한다 
		sendmsg(jsonAlarm(mid + "님이 들어왔습니다."));
		clients.put(session, mid);
	}
	
	@OnClose	// 서버 소켓이 꺼지거나, 클라이언트 소켓이 닫기 요청 했을 때
	public void OnClose( Session session ) throws IOException {
		// 종료된 세션을 리스트에서 제거
		JSONObject object =jsonAlarm(clients.get(session)+" 님이 나갔습니다.");
		clients.remove(session);
		sendmsg(object);		
	}
	@OnMessage
	public void OnMessage( Session session, String msg ) throws IOException{
		// 접속된 클라이언트 소켓을 하나씩 호출
		for(Session s : clients.keySet()) {
			s.getBasicRemote().sendText(msg);
		}
	}
}
