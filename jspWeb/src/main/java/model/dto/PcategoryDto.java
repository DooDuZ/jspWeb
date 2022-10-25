package model.dto;

public class PcategoryDto {
	private int pcno;
	private String pcname;
	
	public PcategoryDto() {
		// TODO Auto-generated constructor stub
	}

	public PcategoryDto(int pcno, String pcname) {
		super();
		this.pcno = pcno;
		this.pcname = pcname;
	}

	public int getPcno() {
		return pcno;
	}

	public void setPcno(int pcno) {
		this.pcno = pcno;
	}

	public String getPcname() {
		return pcname;
	}

	public void setPcname(String pcname) {
		this.pcname = pcname;
	}

	@Override
	public String toString() {
		return "product [pcno=" + pcno + ", pcname=" + pcname + "]";
	}	
}
