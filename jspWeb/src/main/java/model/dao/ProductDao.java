package model.dao;

import java.util.ArrayList;

import model.dto.PcategoryDto;
import model.dto.ProductDto;
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
	public ArrayList<ProductDto> getproductlist(){
		ArrayList<ProductDto> list = new ArrayList<>();
		String sql = "select * from product";
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
	
}
