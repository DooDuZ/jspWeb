package model.dto;

public class writeDto {
	private int bNo;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private String bdate;
	private int bview;
	
	public writeDto() {
		// TODO Auto-generated constructor stub
	}

	public writeDto(int bNo, String btitle, String bcontent, String bwriter, String bdate, int bview) {
		super();
		this.bNo = bNo;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriter = bwriter;
		this.bdate = bdate;
		this.bview = bview;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
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

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
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

	@Override
	public String toString() {
		return "writeDto [bNo=" + bNo + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bwriter=" + bwriter
				+ ", bdate=" + bdate + ", bview=" + bview + "]";
	}
	
	
	
}
