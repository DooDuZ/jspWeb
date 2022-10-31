package room;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
// import model.dao.RoomDao;

import javax.websocket.*;


@ServerEndpoint("/room/RoomSocket/{m_id}")
public class RoomSocket {
	
	
	/*
	public static Map<Session, String> clients = new Hashtable<>();
	
	@OnOpen
	public void OnOpen( Session session, @PathParam("m_id") String m_id ) throws IOException  {
		clients.put(session, m_id);
	}
	@OnClose
	public void OnClose( Session session ) throws IOException {
		RoomDao.getInstance().exitRoom(clients.get(session));
		clients.remove(session);
	}
	@OnMessage
	public void OnMessage( Session session, String object ) throws IOException{
		for(Session s : clients.keySet()) {
			s.getBasicRemote().sendText(object);
		}
	}
	*/
}