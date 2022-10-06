package model.dto;

public class MemberDto {
	
	// class의 보편적 세팅
		// 1. 필드는 private
		// 2. 생성자 기본 2개 : 기본 + full
		// 3. get, set 메소드
		// 4. toString 오버라이드 하기
	
	
	private String ID;
	private String PW;
	private String Name;
	private String Phone;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	public MemberDto(String iD, String pW, String name, String phone) {
		super();
		ID = iD;
		PW = pW;
		Name = name;
		Phone = phone;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	@Override
	public String toString() {
		return "MemberDto [ID=" + ID + ", PW=" + PW + ", Name=" + Name + ", Phone=" + Phone + "]";
	}
	
	
	
}
