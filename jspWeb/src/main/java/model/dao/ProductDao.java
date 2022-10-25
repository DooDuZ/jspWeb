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
		return false;
	}
	
	// 4. 제품 출력
	public ArrayList<ProductDto> getproductlist(){
		return null;
	}
	
}
