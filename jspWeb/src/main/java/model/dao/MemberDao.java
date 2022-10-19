package model.dao;

import java.util.ArrayList;

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
	public int login(String ID, String PW) {
		String sql = "select * from member where mid = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ID);
			rs = ps.executeQuery();
			if(rs.next()) {
				sql = "select * from member where mid = ? and mpw = ? ;";
				ps = con.prepareStatement(sql);
				ps.setString(1, ID);
				ps.setString(2, PW);
				rs = ps.executeQuery();
				if(rs.next()) {
					return 1;
				}else {
					return 2;
				}
			}
		} catch (Exception e) {
			System.out.println("로그인DB에러 " + e);
			return 3;
		}
		return 0;
	}
	
	// ID 찾기
	public String findID(String mname, String mmail) {
		String sql = "select * from member where mname = ? and memail = ? ;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mname);
			ps.setString(2, mmail);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(2);
			}
		} catch (Exception e) {
			System.out.println("ID찾기 DB오류" + e);
		}
		return null;
	}
	
	// 비밀번호 찾기
	public boolean findPW(String mid, String memail) {
		String sql = " select * from member where mid = ? and memail = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, memail);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("pw찾기 db오류" + e);
		}
		return false;
	}
	
	// 임시 비밀번호 등록
	public void updatePW(String mid, String rand) {
		String sql = "update member set mpw = ? where mid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, rand);
			ps.setString(2, mid);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("임시비밀번호 등록 오류" + e);
		}
	}
	
	// getinfo
	public MemberDto getInfo(String mid) {
		MemberDto dto = null;
		String sql = "select * from member where mid = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemberDto();
				dto.setMno(rs.getInt(1));
				dto.setMid(rs.getString(2));
				dto.setMname(rs.getString(4));
				dto.setMphone(rs.getString(5));
				dto.setMemail(rs.getString(6));
				dto.setMaddr(rs.getString(7));
				dto.setMdate(rs.getString(8));
				dto.setMpoint(rs.getInt(9));
			}
			return dto;
		} catch (Exception e) {
			System.out.println("getInfo DB오류" + e);
		}
		return dto;
	}
	
	//getmNo
	public int getMno(String mid) {
		String sql = "select * from member where mid = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}			
		} catch (Exception e) {
			System.out.println("mno호출 db오류"+e);
		}
		return 0;
	}
	
	public ArrayList<MemberDto> getInfoList() {
		ArrayList<MemberDto> list = new ArrayList<>();
		String sql = "select * from member";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setMno(rs.getInt(1));
				dto.setMid(rs.getString(2));
				dto.setMname(rs.getString(4));
				dto.setMphone(rs.getString(5));
				dto.setMemail(rs.getString(6));
				dto.setMaddr(rs.getString(7));
				dto.setMdate(rs.getString(8));
				dto.setMpoint(rs.getInt(9));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			System.out.println("getInfo DB오류" + e);
		}
		return list;
	}
	
	public boolean mDelete(String mid, String mpassword) {
		System.out.println(mid);
		System.out.println(mpassword);
		String sql = "delete from member where mid = ? and mpw = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpassword);
			int count = ps.executeUpdate();
			if(count==1) {
				return true;
			}			
		} catch (Exception e) {
			System.out.println("회원삭제DB 오류" + e);
		}
		return false;
	}
	// id중복검사
	public boolean checkID(String mid) {
		String sql = "select * from member where mid = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(!rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("ID중복검사 오류"+e);
		}
		return false;
	}
	
	//email중복 체크
	public boolean checkEmail(String memail) {
		String sql = "select * from member where memail = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, memail);
			rs = ps.executeQuery();
			if(!rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("ID중복검사 오류"+e);
		}
		return false;
	}
	//update name
	public boolean updateName(String mid, String mname) {
		String sql = "update member set mname = ? where mid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mname);
			ps.setString(2, mid);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("이름변경 DB오류" + e);
		}
		return false;
	}
}
