package room;

public class RoomDao extends Dao{
	/*
	static RoomDao dao = new RoomDao();
	public static RoomDao getInstance() {
		return dao;
	}
	
	// 지웅[] 유저 방 입장 메서드
		// return 0 : 빈자리 없음, return -1 : 방에 같은 아이디의 유저 있음(이미 다른 브라우저로 참여한 아이디)
		// return 1~4 : 리턴하는 번호의 슬롯으로 입장
	public int enterRoom(String m_id) {
		String sql = "select * from room where m_id = ?";
		int slotNum = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, m_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				return -1;
			}
			sql = "select * from room where slot = false";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {				// 첫번째 레코드의 슬롯 번호 반환
				slotNum = rs.getInt(1);
			}
			sql = "update room set slot = true, m_id = ? where s_No = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, m_id);
			ps.setInt(2, slotNum);
			ps.executeUpdate();
			return slotNum;
		} catch (Exception e) {
			System.out.println("방 입장 DB오류" + e);
		}
		return 0;
	}
	
	public boolean exitRoom(String m_id) {
		String sql = "update room set slot = false, m_id = null where m_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, m_id);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("방 나가기 DB오류"+e);
		}
		return false;
	}
	*/
}
