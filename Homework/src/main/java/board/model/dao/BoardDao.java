package board.model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import board.model.dto.commentDto;
import board.model.dto.contentDto;

public class BoardDao extends Dao{
	
	private static BoardDao wDao = new BoardDao();
	
	public static BoardDao getInstance() {
		return wDao;
	}
	
	public boolean addContent(contentDto dto) {
		String sql = "insert into board values ( null, ?, ?, ?, ?, now(),0 );";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getContent());
			ps.setString(3, dto.getWriter());
			ps.setString(4, dto.getPassword());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("글 등록 DB오류 " + e);
		}
		return false;
	}
	
	public ArrayList<contentDto> printBoard(){
		ArrayList<contentDto> list = new ArrayList<>();
		String sql = "select * from board";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				contentDto dto = new contentDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			System.out.println("보드출력 DB 오류" + e);
		}
		return list;		
	}
	
	public boolean deleteContent(int cNo, String password) {
		String sql = "delete from board where cNo=? and password = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cNo);
			ps.setString(2, password);
			int check = ps.executeUpdate();
			if(check==1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("삭제DB오류"+e);
		}
		return false;
	}
	
	public contentDto getContent(int cNo) {
		contentDto dto = new contentDto();
		String sql = "update board set view = view+1 where cNo = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cNo);
			ps.executeUpdate();
			sql = "select * from board where cNo = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString(3));
			}
			return dto;
		} catch (Exception e) {
			System.out.println("글보기 DB오류"+e);
		}
		return null;
	}
	
	// 댓글 가져오기
	public ArrayList<commentDto> viewComment(int bNo){
		ArrayList<commentDto> list = new ArrayList<>();
		String sql = "select * from comment where bNo = ?";
		ResultSet rs2;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bNo);
			rs2 = ps.executeQuery();
			while(rs2.next()) {
				commentDto dto = new commentDto();
				dto.setcNo(rs2.getInt(1));
				dto.setcWriter(rs2.getString(2));
				dto.setcContent(rs2.getString(4));
				dto.setcDate(rs2.getString(5));
				dto.setbNo(rs2.getInt(6));
				dto.setDepth(rs2.getInt(7));
				dto.setRefer(rs2.getInt(8));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			System.out.println("댓글 불러오기 DB 오류"+e);
		}		
		return null;
	}
	
	// 댓글 등록
	public boolean addComment(String comWriter, String comPw, String comText, int bNo) {
		String sql = "insert into comment values(null, ?,?,?, now(),?, 1, 0)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, comWriter);
			ps.setString(2, comPw);
			ps.setString(3, comText);
			ps.setInt(4, bNo);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("댓글 등록 DB오류"+e);
		}		
		return false;
	}
	
	// 댓글 삭제
	public boolean delCommonet(int cNo, String cPassword) {
		String sql = "delete from comment where cNo = ? and cPassword = ?";
		System.out.println(cNo);
		System.out.println(cPassword);
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cNo);
			ps.setString(2, cPassword);
			if(ps.executeUpdate()>=1) {
				return true;
			}			
		} catch (Exception e) {
			System.out.println("댓글 삭제 db오류" + e);
		}		
		return false;
	}
	
	public boolean extendsComment(commentDto dto) {
		int depth;
		String sql = "select * from comment where cNo=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, dto.getcNo());
			rs = ps.executeQuery();
			if(rs.next()) {
				depth = rs.getInt(7) + 1;
			}else {
				depth = 1;
			}
			sql = "insert into comment values(null, ?, ? ,? , now(), ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getcWriter());
			ps.setString(2, dto.getcPassword());
			ps.setString(3, dto.getcContent());
			ps.setInt(4, dto.getbNo());
			ps.setInt(5, depth);
			ps.setInt(6, dto.getcNo());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("대댓글 등록 DB오류"+e);
		}		
		return false;
	}
	
	public boolean checkSelf(int cNo) {
		String sql = "select * from comment where refer = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("참조댓글 확인 db오류");
		}		
		return false;
	}
}
