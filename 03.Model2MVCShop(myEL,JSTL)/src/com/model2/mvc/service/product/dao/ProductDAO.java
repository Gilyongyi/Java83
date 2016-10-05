package com.model2.mvc.service.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.model2.mvc.common.Search;
import com.model2.mvc.common.util.DBUtil;
import com.model2.mvc.service.product.vo.ProductVO;

public class ProductDAO {
	
	public ProductDAO(){
		
	}
	
	public ProductVO findProduct(int prodNo) throws Exception{
		
		Connection con = DBUtil.getConnection();
		
		String sql ="select * from product where prod_no=?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, prodNo);
		
		ResultSet rs = stmt.executeQuery();
		
		ProductVO productVO = null;
		while (rs.next()) {
			productVO = new ProductVO();
			productVO.setProdNo(rs.getInt("prod_No"));
			productVO.setProdName(rs.getString("prod_name"));
			productVO.setProdDetail(rs.getString("prod_detail"));
			productVO.setManuDate(rs.getString("manufacture_day"));
			productVO.setPrice(rs.getInt("price"));
			productVO.setRegDate(rs.getDate("reg_date"));
		}
		
		con.close();
		
		return productVO;
	}
	
	public HashMap<String,Object> getProductList(Search searchVO) throws Exception {
		
		Connection con = DBUtil.getConnection();
		
		String sql = "select v1.rn,v2.count,p1.prod_no,p1.prod_name,p1.price,p1.reg_date,nvl(t1.tran_status_code,0) tsc"
					+" from transaction t1,product p1,"
					+" (select prod_no, rownum rn from(select * from product order by prod_no)) v1,"
					+" (select count(prod_no) count from product) v2"
					+" where v1.prod_no=p1.prod_no"
					+" and p1.prod_no=t1.prod_no(+)"
					+" and v1.rn between ? and ?";
					
		if (searchVO.getSearchCondition() != null) {
			if (searchVO.getSearchCondition().equals("0")) {
				sql += " and p1.prod_no ='" + searchVO.getSearchKeyword()
						+ "'";
			} else if (searchVO.getSearchCondition().equals("1")) {
				sql += " and p1.prod_name='" + searchVO.getSearchKeyword()
						+ "'";
			} else if (searchVO.getSearchCondition().equals("2")) {
				sql += " and p1.price='" + searchVO.getSearchKeyword()
				+ "'";
			}
		}
		sql += " order by p1.prod_no";
		
		PreparedStatement stmt =
				con.prepareStatement(sql,
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
		stmt.setInt(1, searchVO.getPage()*searchVO.getPageUnit()-2);
		stmt.setInt(2, searchVO.getPage()*searchVO.getPageUnit());
		ResultSet rs = stmt.executeQuery();
		
		rs.last();
		int total = rs.getInt("count");
		
		System.out.println("로우의 수:" + total);

		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("count", new Integer(total));

		rs.absolute(1);
		System.out.println("searchVO.getPage():" + searchVO.getPage());
		System.out.println("searchVO.getPageUnit():" + searchVO.getPageUnit());

		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		if (total > 0) {
			for (int i = 0; i < searchVO.getPageUnit(); i++) {
				ProductVO vo = new ProductVO();
				vo.setProdNo(rs.getInt("prod_no"));
				vo.setProdName(rs.getString("prod_name"));
				vo.setPrice(rs.getInt("price"));
				vo.setRegDate(rs.getDate("reg_date"));
				vo.setProTranCode(rs.getString("tsc"));
				
				list.add(vo);
				if(!rs.next())
					break;
				}
			}
		
		System.out.println("list.size() : "+ list.size());
		map.put("list", list);
		System.out.println("map().size() : "+ map.size());

		con.close();
		
		return map;
		
	}
	
	public void insertProduct(ProductVO productVO) throws Exception {
		Connection con = DBUtil.getConnection();
		
		String sql = "insert into product "+
					"values(seq_product_prod_no.nextval,?,?,?,?,?,sysdate)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, productVO.getProdName());
		stmt.setString(2, productVO.getProdDetail());
		stmt.setString(3, productVO.getManuDate());
		stmt.setInt(4, productVO.getPrice());
		stmt.setString(5, productVO.getFileName());
		stmt.executeUpdate();
		
		con.close();
	}
	
	public void updateProduct(ProductVO productVO) throws Exception{
		Connection con = DBUtil.getConnection();
		
		String sql = "update product set prod_name=?,prod_detail=?,manufacture_day=?,price=?, "
				+"image_file=? where prod_no=?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, productVO.getProdName());
		stmt.setString(2, productVO.getProdDetail());
		stmt.setString(3, productVO.getManuDate());
		stmt.setInt(4, productVO.getPrice());
		stmt.setString(5, productVO.getFileName());
		stmt.setInt(6, productVO.getProdNo());
		stmt.executeUpdate();
		
		con.close();
	}
}
