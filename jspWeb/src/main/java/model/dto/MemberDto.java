package model.dto;

public class MemberDto {
	
	// class의 보편적 세팅
		// 1. 필드는 private
		// 2. 생성자 기본 2개 : 기본 + full
		// 3. get, set 메소드
		// 4. toString 오버라이드 하기
	
	private int mno;
	private String mid;
	private String mpw;
	private String mname;
	private String mphone;
	private String memail;
	private String maddr;
	private String mdate;
	private String mpoint;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	
	
	public MemberDto(String mid, String mpw, String mname, String mphone, String memail, String maddr) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mphone = mphone;
		this.memail = memail;
		this.maddr = maddr;
	}



	public MemberDto(int mno, String mid, String mpw, String mname, String mphone, String memail, String maddr,
			String mdate, String mpoint) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mphone = mphone;
		this.memail = memail;
		this.maddr = maddr;
		this.mdate = mdate;
		this.mpoint = mpoint;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMaddr() {
		return maddr;
	}

	public void setMaddr(String maddr) {
		this.maddr = maddr;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public String getMpoint() {
		return mpoint;
	}

	public void setMpoint(String mpoint) {
		this.mpoint = mpoint;
	}

	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mphone=" + mphone
				+ ", memail=" + memail + ", maddr=" + maddr + ", mdate=" + mdate + ", mpoint=" + mpoint + "]";
	}	
}
