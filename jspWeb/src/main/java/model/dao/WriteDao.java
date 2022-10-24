package model.dao;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dto.writeDto;

public class WriteDao extends Dao {
	
	private WriteDao() {}
	
	private static WriteDao wDao = new WriteDao();
	
	public static WriteDao getInstance() {
		return wDao;
	}
	
	public boolean addContent(String btitle, String bcontent, String bwriter, String bfile) {
		String sql = "select mno from member where mid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, bwriter);
			rs = ps.executeQuery();
			int mno = 0;
			if(rs.next()) {
				mno = rs.getInt(1);
			}else {			
				return false;
			}
			sql = "insert into board values( null, ? , ? , now(), 0, ?, 1, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			ps.setString(3, bfile);
			ps.setInt(4, mno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("글등록DB오류" + e);
		}
		return false;
	}
	
	// 글 출력 
	public ArrayList<writeDto> getlist(int startRow, int listSize, String key, String keyword) {
		ArrayList<writeDto> list = new ArrayList<>();
		String sql;
		if(!key.equals("") && !keyword.equals("")) {
			sql = "select b.*, m.mid from member m, board b where m.mno = b.mno and "+ key +" like '%"+ keyword +"%' order by b.bdate desc limit ?,?;";
		}else {
			sql = "select b.*, m.mid from member m, board b where m.mno = b.mno order by b.bdate desc limit ?,?;";
		}
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, startRow);
			ps.setInt(2, listSize);			
			rs=ps.executeQuery();
			while(rs.next()) {
				writeDto dto = new writeDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8), null);
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			System.out.println("글 출력 db 오류"+e);
		}
		return list;
	}
	
	// 글 보기
	public writeDto getContent(int bno) {
		writeDto dto = new writeDto();
		String sql ="select b.* , m.mid from member m , board b where m.mno = b.mno and bno = ?";
		try {			
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto.setBno(rs.getInt(1));
				dto.setBtitle(rs.getString(2));
				dto.setBcontent(rs.getString(3));
				dto.setBfile(rs.getString(6));
				dto.setMid(rs.getString(9));
			}
			sql = "update board set bview = bview+1 where bno=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			ps.executeUpdate();
			return dto;
		} catch (Exception e) {
			System.out.println("글보기db오류"+e);
		}
		return dto;
	}
	
	public boolean deleteContent(int bno) {
		String sql = "delete from board where bno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			if(ps.executeUpdate()>=1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("삭제DB오류"+e);
		}		
		return false;
	}
	
	public boolean bfiledelete(int bno) {
		String sql = "update board set bfile = null where bno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("파일수정 DB오류" + e);
		}		
		return false;
	}
	
	public boolean bupdate(int bNo, String btitle, String bcontent, String bfile) {
		String sql = "update board set btitle = ? , bcontent = ?, bfile=? where bno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			ps.setString(3, bfile);
			ps.setInt(4, bNo);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("글 수정 등록 DB오류" + e);
		}
		
		return false;
	}
	
	// 게시물 전체 개수 리턴
	public int getTotalSize(String key, String keyword) {
		String sql;
		
		if(!key.equals("") && !keyword.equals("")) {
			// 검색 있음
			sql = "select count(*) from board where "+ key +" like '%"+keyword+"%';";
		}else {
			// 검색 없음
			sql = "select count(*) from board";
		}
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("게시물 전체 카운트 DB오류" + e);
		}		
		return 0;
	}
	
	// 댓글등록
	public boolean rwrite(String rcontent, int mno, int bno) {
		String sql = "insert into reply ( rcontent, mno, bno ) values( ? , ? , ?);";
		try {
			ps= con.prepareStatement(sql);
			ps.setString(1, rcontent);
			ps.setInt(2, mno);
			ps.setInt(3, bno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("댓글등록 db 오류"+e);
		}		
		return false;
	}
	// 댓글등록 오버로딩 -> servlet에서 type변수를 통해 댓글/대댓글판단 후 실행
	public boolean rwrite(String rcontent, int mno, int bno, int rno) {
		String sql = "insert into reply ( rcontent, mno, bno, rindex ) values( ? , ? , ?, ? );";
		try {
			ps= con.prepareStatement(sql);
			ps.setString(1, rcontent);
			ps.setInt(2, mno);
			ps.setInt(3, bno);
			ps.setInt(4, rno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("댓글등록 db 오류"+e);
		}		
		return false;
	}
	
	// 댓글 출력
	public JSONArray getrlist(int bno) {
		JSONArray array = new JSONArray();
		String sql = "select reply.rcontent, reply.rdate, member.mid, reply.rno, reply.rindex from reply, "
				+ "member where reply.mno = member.mno and bno = ? and reply.rindex = 0 order by reply.rdate desc;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			while(rs.next()) {
				JSONObject object = new JSONObject();
				object.put("rcontent", rs.getString(1));
				object.put("rdate", rs.getString(2));
				object.put("mid", rs.getString(3));
				object.put("rno", rs.getInt(4));
				object.put("rindex", rs.getInt(5));
				array.add(object);
			}
		} catch (Exception e) {
			System.out.println("댓글 불러오기 DB 오류"+e);
		}		
		return array;
	}
	public JSONArray getrlist(int bno, int rindex) {
		JSONArray array = new JSONArray();
		String sql = "select reply.rcontent, reply.rdate, member.mid, reply.rno, reply.rindex from reply, "
				+ "member where reply.mno = member.mno and bno = ? and reply.rindex = ? order by reply.rdate desc;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			ps.setInt(2, rindex);
			rs = ps.executeQuery();
			while(rs.next()) {
				JSONObject object = new JSONObject();
				object.put("rcontent", rs.getString(1));
				object.put("rdate", rs.getString(2));
				object.put("mid", rs.getString(3));
				object.put("rno", rs.getInt(4));
				object.put("rindex", rs.getInt(5));
				array.add(object);
			}
		} catch (Exception e) {
			System.out.println("댓글 불러오기 DB 오류"+e);
		}		
		return array;
	}
	
	public JSONArray getalist() {
		JSONArray array = new JSONArray();
		String sql = "select * from 아파트매매실거래가 where 시군구 like '%경기도 안산%';";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				JSONObject object = new JSONObject();
				object.put("시군구", rs.getString(1));
				object.put("번지본번부번", rs.getInt(2)+"/"+rs.getInt(3)+"/"+rs.getInt(4));
				object.put("단지명", rs.getString(5));
				object.put("면적", rs.getDouble(6));
				object.put("계약년월일", rs.getInt(7)+"."+rs.getInt(8));
				object.put("거래금액", rs.getString(9));
				object.put("층", rs.getInt(10));
				object.put("건축년도", rs.getInt(11));
				object.put("도로명", rs.getString(12));
				object.put("해제사유발생일", rs.getString(13));
				object.put("거래유형", rs.getString(14));
				object.put("중개사소재지", rs.getString(15));				
				array.add(object);
			}
		} catch (Exception e) {
			System.out.println("거래 출력 DB오류"+e);
		}
		return array;
	}	
}
