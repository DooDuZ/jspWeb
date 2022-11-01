package model.dto;

public class StockDto {
	private int psno;
	private String psize;
	private int pno;
	private int pstno;
	private String pcolor;
	private int pstock;
	
	public StockDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public StockDto(int psno, String psize, int pstno, String pcolor, int pstock) {
		super();
		this.psno = psno;
		this.psize = psize;
		this.pstno = pstno;
		this.pcolor = pcolor;
		this.pstock = pstock;
	}


	public StockDto(int psno, String psize, int pno, int pstno, String pcolor, int pstock) {
		super();
		this.psno = psno;
		this.psize = psize;
		this.pno = pno;
		this.pstno = pstno;
		this.pcolor = pcolor;
		this.pstock = pstock;
	}

	public int getPsno() {
		return psno;
	}

	public void setPsno(int psno) {
		this.psno = psno;
	}

	public String getPsize() {
		return psize;
	}

	public void setPsize(String psize) {
		this.psize = psize;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public int getPstno() {
		return pstno;
	}

	public void setPstno(int pstno) {
		this.pstno = pstno;
	}

	public String getPcolor() {
		return pcolor;
	}

	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}

	public int getPstock() {
		return pstock;
	}

	public void setPstock(int pstock) {
		this.pstock = pstock;
	}

	@Override
	public String toString() {
		return "StockDto [psno=" + psno + ", psize=" + psize + ", pno=" + pno + ", pstno=" + pstno + ", pcolor="
				+ pcolor + ", pstock=" + pstock + "]";
	}
	
	
}
