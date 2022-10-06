package model.dao;

import model.dto.MemberDto;

public class MemberDao extends Dao{
	
	private static MemberDao mdao = new MemberDao();
	
	public static MemberDao getInstance() {
		return mdao;
	}
	
	// 1. 회원가입
	public boolean signup(MemberDto dto) {
		String sql = "insert into member values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getID());
			ps.setString(2, dto.getPW());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getPhone());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("회원가입DB 오류" + e);
		}		
		return false;
	}
	
}
