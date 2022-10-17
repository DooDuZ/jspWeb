package board.model.dto;

public class commentDto {
	int cNo;
    String cWriter; 
    String cPassword;
    String cContent;
    String cDate;
    int bNo;
    int depth;
    int refer;
    String referName;
    
    public commentDto() {
		// TODO Auto-generated constructor stub
	}

    
    
	public commentDto(int cNo, String cWriter, String cContent, String cDate) {
		super();
		this.cNo = cNo;
		this.cWriter = cWriter;
		this.cContent = cContent;
		this.cDate = cDate;
	}



	public commentDto(int cNo, String cWriter, String cPassword, String cContent, String cDate, int bNo) {
		super();
		this.cNo = cNo;
		this.cWriter = cWriter;
		this.cPassword = cPassword;
		this.cContent = cContent;
		this.cDate = cDate;
		this.bNo = bNo;
	}



	public commentDto(int cNo, String cWriter, String cPassword, String cContent, String cDate, int bNo, int depth,
			int refer, String referName) {
		super();
		this.cNo = cNo;
		this.cWriter = cWriter;
		this.cPassword = cPassword;
		this.cContent = cContent;
		this.cDate = cDate;
		this.bNo = bNo;
		this.depth = depth;
		this.refer = refer;
		this.referName = referName;
	}



	public int getcNo() {
		return cNo;
	}



	public void setcNo(int cNo) {
		this.cNo = cNo;
	}



	public String getcWriter() {
		return cWriter;
	}



	public void setcWriter(String cWriter) {
		this.cWriter = cWriter;
	}



	public String getcPassword() {
		return cPassword;
	}



	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}



	public String getcContent() {
		return cContent;
	}



	public void setcContent(String cContent) {
		this.cContent = cContent;
	}



	public String getcDate() {
		return cDate;
	}



	public void setcDate(String cDate) {
		this.cDate = cDate;
	}



	public int getbNo() {
		return bNo;
	}



	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	
	
	public int getDepth() {
		return depth;
	}



	public void setDepth(int depth) {
		this.depth = depth;
	}



	public int getRefer() {
		return refer;
	}



	public void setRefer(int refer) {
		this.refer = refer;
	}



	public String getReferName() {
		return referName;
	}



	public void setReferName(String referName) {
		this.referName = referName;
	}



	@Override
	public String toString() {
		return "commentDto [cNo=" + cNo + ", cWriter=" + cWriter + ", cPassword=" + cPassword + ", cContent=" + cContent
				+ ", cDate=" + cDate + ", bNo=" + bNo + ", depth=" + depth + ", refer=" + refer + ", referName="
				+ referName + "]";
	}
	
}
