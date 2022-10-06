package model.dao;

import model.dto.MemberDto;

public class MemberDao extends Dao{
	
	private static MemberDao mdao = new MemberDao();
	
	public static MemberDao getInstance() {
		return mdao;
	}
	
	// 1. 회원가입
	public boolean signup(MemberDto dto) {
		String sql = "insert into member(mid, mpw, mname, mphone, memail, maddr) values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
			ps.setString(3, dto.getMname());
			ps.setString(4, dto.getMphone());
			ps.setString(5, dto.getMemail());
			ps.setString(6, dto.getMaddr());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("회원가입DB 오류" + e);
		}		
		return false;
	}
	
	// 2. 로그인
	public boolean login(String ID, String PW) {
		String sql = "select * from member where mid = ? and mpw = ? ;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ID);
			ps.setString(2, PW);
			rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("메롱");
				return true;
			}
		} catch (Exception e) {
			System.out.println("로그인DB에러 " + e);
		}
		return false;
	}
	
}
