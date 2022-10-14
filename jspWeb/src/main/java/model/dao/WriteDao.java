package model.dao;

import java.util.ArrayList;

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
	public ArrayList<writeDto> getlist() {
		ArrayList<writeDto> list = new ArrayList<>();
		String sql = "select * from board";
		try {
			ps=con.prepareStatement(sql);
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
}
