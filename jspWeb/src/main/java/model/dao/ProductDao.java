package model.dao;

import java.sql.Statement;
import java.util.ArrayList;

import model.dto.PcategoryDto;
import model.dto.ProductDto;
import model.dto.StockDto;
public class ProductDao extends Dao{
	
	// 1. 카테고리 등록
	public boolean setpcategory(String pcname) {
		String sql = "insert into pcategory values (null, ?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pcname);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("카테고리 등록 DB오류"+e);
		}		
		return false;
	}
	// 2. 카테고리 출력
	public ArrayList<PcategoryDto> getpcategory() {
		ArrayList<PcategoryDto> list = new ArrayList<>();
		String sql = "select * from pcategory";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				PcategoryDto dto = new PcategoryDto(rs.getInt(1), rs.getString(2));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			System.out.println("카테고리 출력 DB오류"+e);
		}
		return list;
	}
	
	// 3. 제품 등록
	public boolean setproduct(ProductDto dto) {
		String sql = "insert into product values (null, ?, ?, ?, ?, 0, ?, now(),?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPname());
			ps.setString(2, dto.getPcomment());
			ps.setInt(3, dto.getPprice());
			ps.setDouble(4, dto.getPdiscount());
			ps.setString(5, dto.getPimg());
			ps.setInt(6, dto.getPcno());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("제품등록 DB오류"+e);
		}		
		return false;
	}
	
	// 4. 제품 출력
	public ArrayList<ProductDto> getproductlist(String option){
		ArrayList<ProductDto> list = new ArrayList<>();
		String sql = null;
		if(option.equals("all")) {
			sql = "select * from product";
		}else if(option.equals("pactive1")){
			sql = "select * from product where pactive = 1 order by pdate desc;";
		}		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductDto dto = new ProductDto();
				dto.setPno(rs.getInt(1));
				dto.setPname(rs.getString(2));
				dto.setPcomment(rs.getString(3));
				dto.setPprice(rs.getInt(4));
				dto.setPdiscount(rs.getDouble(5));
				dto.setPactive(rs.getByte(6));
				dto.setPimg(rs.getString(7));
				dto.setPdate(rs.getString(8));
				dto.setPcno(rs.getInt(9));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			System.out.println("제품출력 DB오류"+e);
		}
		return null;
	}
	
	// 5. 제품 삭제
	public boolean deleteproduct(int pno) {
		String sql = "delete from product where pno = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pno);
			if(ps.executeUpdate()==1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("제품 삭제 DB오류"+e);			
		}
		return false;		
	}
	
	// 6. 개별 제품 정보 호출
	public ProductDto getProduct(int pno) {
		ProductDto dto = new ProductDto();
		String sql = "select * from product where pno=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pno);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto.setPno(rs.getInt(1));
				dto.setPname(rs.getString(2));
				dto.setPcomment(rs.getString(3));
				dto.setPprice(rs.getInt(4));
				dto.setPdiscount(rs.getDouble(5));
				dto.setPactive(rs.getByte(6));
				dto.setPimg(rs.getString(7));
				dto.setPdate(rs.getString(8));
				dto.setPcno(rs.getInt(9));
			}
			return dto;
		} catch (Exception e) {
			System.out.println("제품 개별 호출 DB오류"+e);
		}
		return null;
	}
	
	public boolean updateproduct(ProductDto dto) {
		String sql = "update product set pname =? , pcomment = ? , pprice = ? , pdiscount = ?, pactive = ? , pimg = ? , pcno =? where pno = ? ;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPname());
			ps.setString(2, dto.getPcomment());
			ps.setInt(3, dto.getPprice());
			ps.setDouble(4, dto.getPdiscount());
			ps.setByte(5, dto.getPactive());
			ps.setString(6, dto.getPimg());
			ps.setInt(7, dto.getPcno());
			ps.setInt(8, dto.getPno());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("제품수정DB오류" + e);
		}		
		return false;
	}
	
	public ArrayList<StockDto> getstock(int pno){
		ArrayList<StockDto> list = new ArrayList<>();
		String sql = "select * from productsize ps, productstock pst where ps.psno = pst.psno and ps.pno = ? "
				+ "order by ps.psize desc;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pno);
			rs = ps.executeQuery();
			while(rs.next()) {
				StockDto dto = new StockDto(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getString(5), rs.getInt(6));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			System.out.println("getstock DB오류"+e);
		}		
		return null;
	}
	
	
	public boolean setstock(String psize, int pno, String pcolor, int pstock){
		String sql = "insert into productsize(psize, pno) values(?,?)";
		try {
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, psize);
			ps.setInt(2, pno);
			ps.executeUpdate();
			// 방금 insert된 pk값 가져오기
				// 1. con.preparedStatement(sql, Statement.RETURN_GENERATED_KEYS)
			// 2. ps.getGeneratedKeys() : pk값 호출
			rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				int psno = rs.getInt(1);	
				sql = "insert into productstock (pcolor, pstock, psno) values(?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, pcolor);
				ps.setInt(2, pstock);
				ps.setInt(3, psno);
				ps.executeUpdate();
				return true;
			}
		} catch (Exception e) {
			System.out.println("재고 수정 db오류" + e);
		}		
		return false;
	}
	
	
	// 좋아요 등록
	public int setplike(int pno, int mno) {
		String sql = "select * from plike where pno = ? and mno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.setInt(2, mno);			
			rs = ps.executeQuery();
			if(rs.next()) {
				sql = "delete from plike where pno = ? and mno =?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, pno);
				ps.setInt(2, mno);			
				ps.executeUpdate();
				return 0;
			}else {
				sql = "insert into plike values (null, ?, ?)";
				ps = con.prepareStatement(sql);
				ps.setInt(1, mno);
				ps.setInt(2, pno);
				ps.executeUpdate();
				return 1;
			}
		} catch (Exception e) {
			System.out.println("찜하기 DB오류"+e);
		}	
		return 3;
	}
}
