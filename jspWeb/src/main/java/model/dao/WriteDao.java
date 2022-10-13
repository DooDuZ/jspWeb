package model.dao;

import java.util.ArrayList;

import model.dto.writeDto;

public class WriteDao extends Dao {
	
	private WriteDao() {}
	
	private static WriteDao wDao = new WriteDao();
	
	public static WriteDao getInstance() {
		return wDao;
	}
	
	public boolean addContent(String btitle, String bcontent, String bwriter) {
		String sql = "insert into board values( null, ?, ?, ?, now(), 0)";
		if(bwriter==null) {
			return false;
		}
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			ps.setString(3, bwriter);
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
				writeDto dto = new writeDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			System.out.println("글 출력 db 오류"+e);
		}
		return list;
	}
	
	public writeDto getContent(int bno) {
		writeDto dto = new writeDto();
		String sql = "select * from board where bno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto.setBtitle(rs.getString(2));
				dto.setBcontent(rs.getString(3));
			}
			return dto;
		} catch (Exception e) {
			System.out.println("글보기db오류"+e);
		}
		return dto;
	}
}
