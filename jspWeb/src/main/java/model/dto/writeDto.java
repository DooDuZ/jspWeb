package model.dto;

public class writeDto {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bdate;
	private int bview;
	private String bfile;    
	private int cno;
	private int mno;
	private String mid;
	
	public writeDto() {
		// TODO Auto-generated constructor stub
	}

	public writeDto(int bno, String btitle, String bdate, int bview, int mno) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bdate = bdate;
		this.bview = bview;
		this.mno = mno;
	}

	public writeDto(int bno, String btitle, String bcontent, String bdate, int bview, String bfile, int cno, int mno,
			String mid) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.bview = bview;
		this.bfile = bfile;
		this.cno = cno;
		this.mno = mno;
		this.mid = mid;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public int getBview() {
		return bview;
	}

	public void setBview(int bview) {
		this.bview = bview;
	}

	public String getBfile() {
		return bfile;
	}

	public void setBfile(String bfile) {
		this.bfile = bfile;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
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

	@Override
	public String toString() {
		return "writeDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bdate=" + bdate
				+ ", bview=" + bview + ", bfile=" + bfile + ", cno=" + cno + ", mno=" + mno + ", mid=" + mid + "]";
	}
}
