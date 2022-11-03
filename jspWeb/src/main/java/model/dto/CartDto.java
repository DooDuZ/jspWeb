package model.dto;

public class CartDto {
	private int cartNo;
	private String pname;
	private int pprice;
	private String pcolor;
	private int amount;
	private int pstno;
	private String pimg;
	private double pdiscount;
	private String psize;
	
	public CartDto() {
		// TODO Auto-generated constructor stub
	}

	public CartDto(int cartNo, String pname, int pprice, String pcolor, int amount, int pstno, String pimg,
			float pdiscount, String psize) {
		super();
		this.cartNo = cartNo;
		this.pname = pname;
		this.pprice = pprice;
		this.pcolor = pcolor;
		this.amount = amount;
		this.pstno = pstno;
		this.pimg = pimg;
		this.pdiscount = pdiscount;
		this.psize = psize;
	}

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public String getPcolor() {
		return pcolor;
	}

	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPstno() {
		return pstno;
	}

	public void setPstno(int pstno) {
		this.pstno = pstno;
	}

	public String getPimg() {
		return pimg;
	}

	public void setPimg(String pimg) {
		this.pimg = pimg;
	}

	public double getPdiscount() {
		return pdiscount;
	}

	public void setPdiscount(double pdiscount) {
		this.pdiscount = pdiscount;
	}

	public String getPsize() {
		return psize;
	}

	public void setPsize(String psize) {
		this.psize = psize;
	}

	@Override
	public String toString() {
		return "CartDto [cartNo=" + cartNo + ", pname=" + pname + ", pprice=" + pprice + ", pcolor=" + pcolor
				+ ", amount=" + amount + ", pstno=" + pstno + ", pimg=" + pimg + ", pdiscount=" + pdiscount + ", psize="
				+ psize + "]";
	}
	
	
}
