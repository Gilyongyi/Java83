package com.model2.mvc.service.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.common.util.DBUtil;
import com.model2.mvc.domain.ProductVO;

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
	
	public HashMap<String,Object> getProductList(SearchVO searchVO) throws Exception {
		
		Connection con = DBUtil.getConnection();
		StringBuffer getProdList =new StringBuffer();
		getProdList.append("select v1.rn,v2.count,p1.prod_no,p1.prod_name,p1.price,p1.reg_date,nvl(t1.tran_status_code,0) tsc ");
		getProdList.append("from transaction t1,product p1, ");
		getProdList.append("(select prod_no, rownum rn from(select * from product ");
		if(searchVO.getOrder() != null && searchVO.getOrder().equals("asc") ){
			getProdList.append("order by price asc");
		}else if(searchVO.getOrder() != null && searchVO.getOrder().equals("desc")){
			getProdList.append("order by price desc");
		}else{
			getProdList.append("order by prod_no ");
		}
		getProdList.append(")) v1, (select count(prod_no) count from product) v2 ");
		getProdList.append("where v1.prod_no=p1.prod_no ");
		getProdList.append("and p1.prod_no=t1.prod_no(+) ");
		getProdList.append("and v1.rn between ? and ?");
		
		
		if (searchVO.getSearchCondition() != null && searchVO.getSearchKeyword()!=null && searchVO.getSearchKeyword()!="") {
			if (searchVO.getSearchCondition().equals("1")) {
				getProdList.append(" and p1.prod_name='" +searchVO.getSearchKeyword()+"'");
			} else if (searchVO.getSearchCondition().equals("2")) {
				getProdList.append(" and p1.price='" +searchVO.getSearchKeyword()+"'");
			}
		}
		
		if(searchVO.getOrder() != null && searchVO.getOrder().equals("asc") ){
			getProdList.append(" order by p1.price asc");
		}else if(searchVO.getOrder() != null && searchVO.getOrder().equals("desc")){
			getProdList.append(" order by p1.price desc");
		}else{
			getProdList.append(" order by p1.prod_no");
		}

		PreparedStatement stmt =
				con.prepareStatement(getProdList.toString(),
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
		
		stmt.setInt(1, ((searchVO.getCurrentPage()-1)*searchVO.getPageSize()+1));
		stmt.setInt(2, searchVO.getCurrentPage()*searchVO.getPageSize());
		ResultSet rs = stmt.executeQuery();
		
		rs.last();
		int total = 0;
		if(rs.getRow()>0){
			total = rs.getInt("count");
		}
		
		System.out.println("로우의 수:" + total);

		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("count", new Integer(total));

		rs.absolute(1);
		System.out.println("searchVO.getPage():" + searchVO.getCurrentPage());
		System.out.println("searchVO.getPageUnit():" + searchVO.getPageSize());

		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		if (total > 0) {
			for (int i = 0; i < searchVO.getPageSize(); i++) {
			
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
		StringBuffer insProd =new StringBuffer();
		insProd.append("insert into product ");
		insProd.append("values(seq_product_prod_no.nextval,?,?,?,?,?,sysdate)");
		PreparedStatement stmt = con.prepareStatement(insProd.toString());
		
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
		StringBuffer upProd =new StringBuffer();
		upProd.append("update product set prod_name=?,prod_detail=?,manufacture_day=?,price=?, ");
		upProd.append("image_file=? where prod_no=?");
		PreparedStatement stmt = con.prepareStatement(upProd.toString());
		
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
