package board.model.dto;

public class contentDto {
	
	int cNo;
	String Title;
	String Writer;
    String password;    
    String content;
    String Date;
    int view;
    
    public contentDto() {
		// TODO Auto-generated constructor stub
	}

    
    
    
	public contentDto(String content) {
		this.content = content;
	}




	public contentDto(String writer, String password, String title, String content) {
		super();
		Writer = writer;
		this.password = password;
		Title = title;
		this.content = content;
	}




	public contentDto(int cNo, String writer, String password, String title, String content, String date, int view) {
		super();
		this.cNo = cNo;
		Writer = writer;
		this.password = password;
		Title = title;
		this.content = content;
		Date = date;
		this.view = view;
	}

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public String getWriter() {
		return Writer;
	}

	public void setWriter(String writer) {
		Writer = writer;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	@Override
	public String toString() {
		return "contentDto [cNo=" + cNo + ", Writer=" + Writer + ", password=" + password + ", Title=" + Title
				+ ", content=" + content + ", Date=" + Date + ", view=" + view + "]";
	}
}